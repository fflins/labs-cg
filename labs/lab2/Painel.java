package lab2;

import javax.swing.*;
import java.awt.*;

public class Painel extends JPanel {
    private int[][] pixels;
    private final int cellSize = 16;
    private int n;  // Tamanho da matriz

    public Painel(int n) {
        this.n = n;
        this.pixels = new int[n][n];
        setPreferredSize(new Dimension(n * cellSize, n * cellSize));
    }

    public void updatePixel(int x, int y) {
        int centerX = n / 2;
        int centerY = n / 2;
        int transformedX = centerX + x;
        int transformedY = centerY - y;

        if (transformedX >= 0 && transformedX < n && transformedY >= 0 && transformedY < n) {
            pixels[transformedX][transformedY] = 1;
            repaint();
        }
    }

    public void cleanPanel() {
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                pixels[i][j] = 0;
            }
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int centerX = n / 2;
        int centerY = n / 2;

        // Desenhar a grade, os pixels e os números
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                // Pintar a coluna central de vermelho
                if ((i == centerX) || (j == centerY)) {
                    g.setColor(Color.LIGHT_GRAY);
                } else if (pixels[i][j] == 1) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.WHITE);
                }
                g.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
                g.setColor(Color.GRAY); // Cor da grade
                g.drawRect(i * cellSize, j * cellSize, cellSize, cellSize);

                // Desenhar números nos eixos
                g.setColor(Color.BLACK);
                if (i == centerX) { // Eixo Y
                    g.drawString(String.valueOf(centerY - j), i * cellSize + 2, j * cellSize + cellSize - 2);
                }
                if (j == centerY) { // Eixo X
                    g.drawString(String.valueOf(i - centerX), i * cellSize + 2, j * cellSize + cellSize - 2);
                }
            }
        }
    }
}
