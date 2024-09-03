package lab2;

public class ElipsePontoMedio {

  // Método para desenhar uma elipse usando o método do ponto médio
  public static void elipsePontoMedio(int xCenter, int yCenter, int Rx, int Ry, Painel painel) {
      int Rx2 = Rx * Rx;
      int Ry2 = Ry * Ry;
      int twoRx2 = 2 * Rx2;
      int twoRy2 = 2 * Ry2;
      int p;
      int x = 0;
      int y = Ry;
      int px = 0;
      int py = twoRx2 * y;


      pontoElipse(xCenter, yCenter, x, y, painel);

      // Região 1
      p = (int) Math.round(Ry2 - (Rx2 * Ry) + (0.25 * Rx2));
      while (px < py) {
          x++;
          px += twoRy2;
          if (p < 0) {
              p += Ry2 + px;
          } else {
              y--;
              py -= twoRx2;
              p += Ry2 + px - py;
          }
          pontoElipse(xCenter, yCenter, x, y, painel);
      }

      // Região 2
      p = (int) Math.round(Ry2 * (x + 0.5) * (x + 0.5) + Rx2 * (y - 1) * (y - 1) - Rx2 * Ry2);
      while (y > 0) {
          y--;
          py -= twoRx2;
          if (p > 0) {
              p += Rx2 - py;
          } else {
              x++;
              px += twoRy2;
              p += Rx2 - py + px;
          }
          pontoElipse(xCenter, yCenter, x, y, painel);
      }
  }

  // Método para realizar espelhamento dos pontos da elipse
  private static void pontoElipse(int xCenter, int yCenter, int x, int y, Painel painel) {
      painel.updatePixel( xCenter + x, yCenter + y);
      painel.updatePixel( xCenter - x, yCenter + y);
      painel.updatePixel( xCenter + x, yCenter - y);
      painel.updatePixel( xCenter - x, yCenter - y);
  }
}
