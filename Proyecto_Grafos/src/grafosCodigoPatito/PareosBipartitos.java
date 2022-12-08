/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafosCodigoPatito;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PareosBipartitos
{
    public static void Tonto(boolean matriz[][], ArrayList<Nodo> Nodos)
    {
        if(Bipartito.EsBipartito(matriz, Nodos))//El algoritmo procedera si es bipartito
        {
            Graphics g = Vista.PanelGrafo.getGraphics();
            g.clearRect(0, 0, Vista.PanelGrafo.getWidth(), Vista.PanelGrafo.getHeight());
            Vista.pintar(g);
            ArrayList<Nodo> Conjunto1 = Bipartito.getV1();
            ArrayList<Nodo> Conjunto2 = Bipartito.getV2();
            ArrayList<Arista> LAristas = Vista.getListaAristas();
            Point n1 = new Point();
            Point n2 = new Point();
            for(Nodo nodoc1 : Conjunto1)
            {
                for(Nodo nodoc2 : Conjunto2)
                {
                    if(matriz[Nodos.indexOf(nodoc1)][Nodos.indexOf(nodoc2)])
                    {
                        n1.x = nodoc1.getX();
                        n1.y = nodoc1.getY();
                        n2.x = nodoc2.getX();
                        n2.y = nodoc2.getY();
                        for(Arista arista : LAristas)
                        {
                            if(arista.getV1().equals(n1) && arista.getV2().equals(n2) || arista.getV1().equals(n2) && arista.getV2().equals(n1))
                            {
                                arista.pintar(g, Color.RED);
                            }
                        }
                        nodoc1.pintar(g, Color.CYAN);
                        nodoc2.pintar(g, Color.CYAN);
                        Conjunto2.remove(nodoc2);
                        break;
                    }
                }
                Conjunto2.remove(nodoc1);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "El algoritmo solo puede aplicarse en grafos bipartitos");
        }
    }
}
