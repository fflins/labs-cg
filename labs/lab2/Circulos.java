package lab2;

public class Circulos {

    // Método para desenhar a circunferência usando o algoritmo de ponto médio
    public static void circunferenciaPontoMedio(int raio, Painel p) {
        int x = 0;
        int y = raio;
        int d = 1 - raio;


        ponto_Circulo(p, x, y);

        while (y > x) {
            if (d < 0) {
                d += 2 * x + 3;
            } else {
                d += 2 * (x - y) + 5;
                y--;
            }
            x++;
            ponto_Circulo(p, x, y);
        }
    }

    // Método para desenhar a circunferência usando o método trigonométrico
    public static void circunferenciaTrigonometrica(int raio, Painel p) {
        double theta = 0;
        boolean converted = false;
        final double passo = 1.0;

        // Loop enquanto o círculo não for completamente desenhado
        while (!converted) {
            // Converter o ângulo de graus para radianos
            double radianos = Math.toRadians(theta);

            // Calcular a coordenada x usando a fórmula do círculo
            int x = (int) Math.round(raio * Math.cos(radianos));

            // Calcular a coordenada y usando a fórmula do círculo
            int y = (int) Math.round(raio * Math.sin(radianos));

            // Plotar os pontos 
            ponto_Circulo(p, x, y);
            theta += passo;

            // Condição de parada: círculo completo quando o ângulo alcança 360 graus
            if (theta >= 360) {
                converted = true;
            }
        }
    }

    // Método para desenhar a circunferência usando o método Polinomial
    public static void circunferenciaPolinomial(int raio, Painel p) {
        // Inicialização das variáveis
        int x = 0;
        int i = 1;
        int xend = raio;

        // Loop para desenhar o círculo
        while (x <= xend) {
            // Cálculo da coordenada y usando a equação do círculo
            int y = (int) Math.round(Math.sqrt(raio * raio - x * x));

            // Plotar os pontos determinados pela simetria
            ponto_Circulo(p, x, y);

            // Incrementar x
            x += i;
        }
    }


    // Método para realizar espelhamento dos pontos da circunferência
    private static void ponto_Circulo(Painel p, int x, int y) {
        p.updatePixel( x, y);
        p.updatePixel(y, x);
        p.updatePixel(y, -x);;
        p.updatePixel(x, -y);
        p.updatePixel(-x, -y);
        p.updatePixel(-y, -x);
        p.updatePixel(-y, x);
        p.updatePixel(-x, y); 
      }
}