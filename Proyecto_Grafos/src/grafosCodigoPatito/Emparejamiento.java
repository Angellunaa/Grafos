/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafosCodigoPatito;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;

public class Emparejamiento
{
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
    
    public static void Tonto(boolean matriz[][], ArrayList<Nodo> Nodos)
    {
        Graphics g = Vista.PanelGrafo.getGraphics();
        g.clearRect(0, 0, Vista.PanelGrafo.getWidth(), Vista.PanelGrafo.getHeight());
        Vista.pintar(g);
        Nodo nodo1;
        Nodo nodo2;
        Point n1 = new Point();
        Point n2 = new Point();
        int n = Nodos.size();
        int visitado[] = new int[n];
        int origen=0;
        int contV=0;
        ArrayList<Arista> LAristas = Vista.getListaAristas();
        LinkedList cola = new LinkedList();
        cola.offer(origen); 
        boolean termino = false;
        while(!compvisit(visitado, n))
        {
            for(int i=0; i<n; i++)
            {
                if(matriz[origen][i] && (visitado[i] == 0) && cola.size()!= 2)
                {
                    visitado[origen] = 1;
                    visitado[i] = 1;
                    cola.offer(i);
                    if(cola.size() == 2)
                    {
                        nodo1 = Nodos.get((int) cola.peek());
                        cola.poll();
                        nodo2 = Nodos.get((int) cola.peek());
                        cola.poll();
                        n1.x = nodo1.getX();
                        n1.y = nodo1.getY();
                        n2.x = nodo2.getX();
                        n2.y = nodo2.getY();
                        
                        for(Arista arista : LAristas)
                        {
                            if(arista.getV1().equals(n1) && arista.getV2().equals(n2) || arista.getV1().equals(n2) && arista.getV2().equals(n1))
                            {
                                arista.pintar(g, Color.RED);
                            }
                        }
                        nodo1.pintar(g, Color.CYAN);
                        nodo2.pintar(g, Color.CYAN);
                        
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
                            termino = true;
                            break;
                        }
                    }
                }
            }
            if(termino) break;
        }
    }
    
    public static void Maximo()
    {
        
    }
    
}
