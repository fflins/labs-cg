package lab2;
public class Dda {

  public static int round(float n) { //Função de arredondamento
    if (n - (int) n < 0.5) 
      return (int) n; 
    return (int) (n + 1); 
  } 
  
  public static void DDALine(int x0, int y0, int x1, int y1, Painel painel) { 

    int dx = x1 - x0; 
    int dy = y1 - y0; 

    int maior; 

    if (Math.abs(dx) > Math.abs(dy)) 
        maior = Math.abs(dx); 
    else
        maior = Math.abs(dy); 

    float x_incr = (float) dx / maior; 
    float y_incr = (float) dy / maior; 
    float x = x0;
    float y = y0;
    
    for (int i = 0; i <= maior; i++) {
        painel.updatePixel(Math.round(x), Math.round(y));  
        x += x_incr;
        y += y_incr;
    }
} 
}


