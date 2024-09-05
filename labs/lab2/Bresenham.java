package lab2;
public class Bresenham {

    public static void bresenhamLine(int x0, int y0, int x1, int y1, Painel p) {
        int dx, dy, d, x, y;
        dx = x1 - x0;
        dy = y1 - y0;
        x = x0;
        y = y0;
        d = 2 * dy - dx;
    
        while (x < x1) {
            if (d > 0) { //Escolhe NE
                p.updatePixel(x, y);  
                y = y + 1;
                d = d + 2 * dy - 2 * dx;
            } else {
                p.updatePixel(x, y);  //Escolhe E
                d = d + 2 * dy;
            }
            x = x + 1;
        }
    }
    
}  
