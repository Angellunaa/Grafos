
import java.util.LinkedList;
import java.util.Scanner;



public class GN_tonto {
    
    static boolean compvisit(int visitado[], int n)
    {
        for(int x=0; x<n; x++)
            {
                if(visitado[x]==0)
                {
                    return false;
                }
            }
        return true;
    }
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa cantidad de nodos:");
        int n = sc.nextInt();
        
        System.out.print("\nIngresa matriz de adyacencia");
        int matriz[][] = new int[n][n];
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                matriz[i][j] = sc.nextInt();
            }
        }
        
        int visitado[] = new int[n];
        int origen=0;
        int contV=0;
        LinkedList cola = new LinkedList();
        cola.offer(origen); 
        while(!compvisit(visitado, n))
        {
            
            for(int i=0; i<n; i++)
            {
                if(matriz[origen][i]==1 && (visitado[i]==0) && cola.size()!=2)
                {
                    visitado[origen]=1;
                    visitado[i]=1;
                    cola.offer(i);
                    if(cola.size()==2)
                    {
                        System.out.print("\n"+cola.poll()+" ---- "+cola.poll());
                        
                        for(int x=0; x<n; x++)
                        {
                            if(visitado[x]==0)
                            {
                                origen=x;
                                contV+=1;
                            }
                        }
                        cola.offer(origen);
                        if(n%2==1 && contV==1)
                        {
                            System.exit(0);
                        }
                    }
                }
                
            }
        }
    }
}
