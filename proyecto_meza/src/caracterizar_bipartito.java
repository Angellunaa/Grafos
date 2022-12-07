import java.util.LinkedList;
import java.util.Scanner;

/*
Bipartito:
0 0 1 1 0 1
0 0 0 0 1 1
1 0 0 0 0 0
1 0 0 0 0 0
0 1 0 0 0 0
1 1 0 0 0 0

No bipartito:
0 0 1 1 0 1
0 0 0 0 1 1
1 0 0 0 0 0
1 0 0 0 0 0
0 1 0 0 0 1
1 1 0 0 1 0
*/

public class caracterizar_bipartito {
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa cantidad de nodos:");
        int n = sc.nextInt();
        
        System.out.print("\nIngresa matriz de adyacencia:\n");
        int matriz[][] = new int[n][n];
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                matriz[i][j] = sc.nextInt();
            }
        }
        
        int colores[] = new int[n];
        
        System.out.print("\nEn que nodo inicia? ");
        int origen = sc.nextInt();
        
        colores[origen]=1;
        
        LinkedList cola = new LinkedList();
        cola.offer(origen);
        
        while(cola.peek()!=null)
        {
            origen = (int) cola.peek();
            cola.poll();
            
            for(int x=0; x<n; x++)
            {
                if(matriz[origen][x]!=0 && colores[x]==0)
                {
                    colores[x]= colores[origen]*-1;
                    cola.offer(x);
                }
                else if(matriz[origen][x]!=0 && colores[origen]==colores[x])
                {
                    System.out.print("\nEl grafo no es bipartito");
                    System.exit(0);
                }
            }
        }
        
        System.out.println("\nEl grafo si es bipartito, ya que cumple con:");
        
        System.out.println("1.- No tiene ciclo impar");
        System.out.println("\n2.- Es bicoloreable (numero cromatico menor o igual a 2)");
        System.out.println("      Color:     rojo = 1        azul = -1\n        ");
        for(int i=0; i<n; i++)
        {
            System.out.print(colores[i]+"  ");
        }
        System.out.println("\n\n3.- El espectro del grafo es simetrico");
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
    }
}
