/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafosCodigoPatito;

import static grafosCodigoPatito.Vista.PanelGrafo;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Recorridos
{
    //Recorrido en profundidad
    public static void DFS(boolean matriz[][], ArrayList<Nodo> Nodos, int nodoI)
    {
        Stack<Integer> pila = new Stack<>();
        ArrayList<Integer> recorrido = new ArrayList<>();
        int CantNodos = Nodos.size();
        boolean[] visitiadoProfunidad = new boolean[CantNodos];
        int j;
        
        visitiadoProfunidad[nodoI] = true;
        pila.add(nodoI);
        
        while (!pila.isEmpty())
        {
            j = pila.peek();
            recorrido.add(pila.peek());
            pila.pop();
            for (int i = 0; i < CantNodos; i++)
            {
                if (matriz[j][i] && !visitiadoProfunidad[i])
                {
                    pila.push(i);
                    visitiadoProfunidad[i] = true;
                }
            }
        }
        //Impresion grafica del recorrido
        Graphics g = PanelGrafo.getGraphics();
        g.clearRect(0, 0, PanelGrafo.getWidth(), PanelGrafo.getHeight());
        Vista.pintar(g);
        Font nuevaFuente = new Font("Monospaced", Font.BOLD, 14);
        g.setFont(nuevaFuente);
        g.setColor(Color.red);
        int TamR = recorrido.size();
        Point v1 = new Point();
        for (int i = 0; i < TamR; i++)
        {
            v1.x = Nodos.get(recorrido.get(i)).getX();
            v1.y = Nodos.get(recorrido.get(i)).getY();
            g.drawString((i+1)+"°", v1.x+Nodo.d/2, v1.y-Nodo.d/2);
        }
    }
    
    //Recorrido en anchura
    public static void BFS(boolean matriz[][], ArrayList<Nodo> Nodos, int nodoI)
    {
        Queue<Integer> cola =  new LinkedList<>();
        ArrayList<Integer> recorrido = new ArrayList<>();
        int CantNodos = Nodos.size();
        boolean[] visitiadoProfunidad = new boolean[CantNodos];
        int j;
        
        visitiadoProfunidad[nodoI] = true;
        cola.add(nodoI);
        
        while (!cola.isEmpty())
        {
            j = cola.peek();
            recorrido.add(cola.peek());
            cola.poll();
            for (int i = 0; i < CantNodos; i++)
            {
                if (matriz[j][i] && !visitiadoProfunidad[i])
                {
                    cola.add(i);
                    visitiadoProfunidad[i] = true;
                }
            }
        }
        
        //Impresion grafica del recorrido
        Graphics g = PanelGrafo.getGraphics();
        g.clearRect(0, 0, PanelGrafo.getWidth(), PanelGrafo.getHeight());
        Vista.pintar(g);
        Font nuevaFuente = new Font("Monospaced", Font.BOLD, 14);
        g.setFont(nuevaFuente);
        g.setColor(Color.red);
        int TamR = recorrido.size();
        Point v1 = new Point();
        for (int i = 0; i < TamR; i++)
        {
            v1.x = Nodos.get(recorrido.get(i)).getX();
            v1.y = Nodos.get(recorrido.get(i)).getY();
            g.drawString((i+1)+"°", v1.x+Nodo.d/2, v1.y-Nodo.d/2);
        }
    }
}
