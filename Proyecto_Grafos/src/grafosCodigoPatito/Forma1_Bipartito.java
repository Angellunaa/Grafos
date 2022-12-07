/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafosCodigoPatito;

import static grafosCodigoPatito.Vista.PanelGrafo;
import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

public class Forma1_Bipartito
{
    private static final int BLANCO = 0;
    private static final int AZUL = 1;
    private static final int ROJO = 2;
    private static ArrayList<Nodo> v1;
    private static ArrayList<Nodo> v2;
    
    public static Boolean EsBipartito(boolean matriz[][], ArrayList<Nodo> Nodos)
    {
        Queue<Integer> cola = new LinkedList<>();
        v1 = new ArrayList<Nodo>();
        v2 = new ArrayList<Nodo>();
        int CantNodos = Nodos.size();
        int[] Visitado = new int[CantNodos];
        //Mete a la cola al primer nodo
        cola.add(0);
        Visitado[0] = AZUL;
        v1.add(Nodos.get(0));

        while(!cola.isEmpty())
        {
            for(int x=0; x < CantNodos; x++)
            {
                if(matriz[cola.peek()][x])//Si hay adyacencia 
                {
                    if(Visitado[x] == BLANCO)//Si el nodo no ha sido visitado
                    {
                        if(Visitado[cola.peek()] == AZUL)//Si el nodo es azul pinta el adyacente de rojo
                        {
                          cola.add(x);
                          Visitado[x]= ROJO;
                          v2.add(Nodos.get(x));
                        }
                        else//Si el nodo es rojo pinta el adyacente de azul
                        {
                          cola.add(x);
                          Visitado[x] = AZUL;
                          v1.add(Nodos.get(x));
                        }
                    }
                    else/*Si el nodo ya ha sido visitado*/if(Visitado[cola.peek()] == Visitado[x])//Si el nodo adyacente tiene el mismo color
                    {
                        v1.clear();
                        v2.clear();
                      return false;
                    }
                }
            }
            cola.poll();
        }
        if(v1.size()+v2.size() < Vista.getListaNodos().size())
        {
            v1.clear();
            v2.clear();
            return false;
        }
        return true;
    }
    public static void BipartitoAngel()
    {
        if(EsBipartito(Vista.getMAdyacencia(), Vista.getListaNodos()) == true)
        {
            for(Nodo nodos : v1)
            {
                nodos.pintar(PanelGrafo.getGraphics(), Color.BLUE);
            }
            for(Nodo nodos : v2)
            {
                nodos.pintar(PanelGrafo.getGraphics(), Color.RED);
            }
            JOptionPane.showMessageDialog(null,"El grafo es bipartito");
            v1.clear();
            v2.clear();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"El grafo no es bipartito");
        }
    }
}
