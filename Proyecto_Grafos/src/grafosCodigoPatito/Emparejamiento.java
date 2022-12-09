/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafosCodigoPatito;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;

public class Emparejamiento
{
    //---------------------------------------------------------------------------------------------------------------------
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
        boolean visitado[] = new boolean[n];
        Arrays.fill(visitado, false);
        int indice = 0;
        ArrayList<Arista> LAristas = Vista.getListaAristas();
        
        for(Nodo nodo : Nodos)
        {
            indice = Nodos.indexOf(nodo);
            if(!visitado[indice])
            {
                for(int i = 0; i < n; i++)
                {
                    if(matriz[indice][i])
                    {
                        if(!visitado[i])
                        {
                            nodo1 = Nodos.get(indice);
                            nodo2 = Nodos.get(i);
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
                            visitado[indice] = true;
                            visitado[i] = true;
                            break;
                        }
                    }
                }
            }
        }
    }
    
    //---------------------------------------------------------------------------------------------------------------------
    
    static int lca(int[] match, int[] base, int[] p, int a, int b)
    {
        boolean[] used = new boolean[match.length];
        while (true)
        {
            a = base[a];
            used[a] = true;
            if (match[a] == -1)
                break;
            a = p[match[a]];
        }
        while (true)
        {
            b = base[b];
            if (used[b])
                return b;
            b = p[match[b]];
        }
    }
 
    static void markPath(int[] match, int[] base, boolean[] blossom, int[] p,
            int v, int b, int children)
    {
        for (; base[v] != b; v = p[match[v]])
        {
            blossom[base[v]] = blossom[base[match[v]]] = true;
            p[v] = children;
            children = match[v];
        }
    }
 
    static int findPath(List<Integer>[] graph, int[] match, int[] p, int root)
    {
        int n = graph.length;
        boolean[] used = new boolean[n];
        Arrays.fill(p, -1);
        int[] base = new int[n];
        for (int i = 0; i < n; ++i)
            base[i] = i;
        used[root] = true;
        int qh = 0;
        int qt = 0;
        int[] q = new int[n];
        q[qt++] = root;
        while (qh < qt)
        {
            int v = q[qh++];
            for (int to : graph[v])
            {
                if (base[v] == base[to] || match[v] == to)
                    continue;
                if (to == root || match[to] != -1 && p[match[to]] != -1)
                {
                    int curbase = lca(match, base, p, v, to);
                    boolean[] blossom = new boolean[n];
                    markPath(match, base, blossom, p, v, curbase, to);
                    markPath(match, base, blossom, p, to, curbase, v);
                    for (int i = 0; i < n; ++i)
                        if (blossom[base[i]])
                        {
                            base[i] = curbase;
                            if (!used[i])
                            {
                                used[i] = true;
                                q[qt++] = i;
                            }
                        }
                }
                else if (p[to] == -1)
                {
                    p[to] = v;
                    if (match[to] == -1)
                        return to;
                    to = match[to];
                    used[to] = true;
                    q[qt++] = to;
                }
            }
        }
        return -1;
    }
 
    public static int maxMatching(List<Integer>[] graph)
    {
        Graphics g = Vista.PanelGrafo.getGraphics();
        g.clearRect(0, 0, Vista.PanelGrafo.getWidth(), Vista.PanelGrafo.getHeight());
        Vista.pintar(g);
        Nodo nodo1;
        Nodo nodo2;
        Point n1 = new Point();
        Point n2 = new Point();
        ArrayList<Arista> LAristas = Vista.getListaAristas();
        ArrayList<Nodo> Nodos = Vista.getListaNodos();
        int n = graph.length;
        int[] match = new int[n];
        Arrays.fill(match, -1);
        int[] p = new int[n];
        for (int i = 0; i < n; ++i)
        {
            if (match[i] == -1)
            {
                int v = findPath(graph, match, p, i);
                while (v != -1)
                {
                    int pv = p[v];
                    int ppv = match[pv];
                    match[v] = pv;
                    match[pv] = v;
                    v = ppv;
                }
            }
        }
        //Impresion de las aristas
        for (int i=0; i<n; i++)
        {
            if(i < match[i])
            {
                nodo1 = Nodos.get(i);
                nodo2 = Nodos.get(match[i]);
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
            }
        }
        int matches = 0;
        for (int i = 0; i < n; ++i)
            if (match[i] != -1)
                ++matches;
        return matches / 2;
    }
    
    public static void Maximo(ArrayList<Nodo> Nodos)
    {
        ArrayList<Arista> LAristas = Vista.getListaAristas();
        int v = Nodos.size();
        Point n1 = new Point();
        Point n2 = new Point();
        List<Integer>[] g = new List[v];
        int v1 = 0, v2 = 0;
        for (int i = 0; i < v; i++)
        {
            g[i] = new ArrayList<Integer>();
        }

        for(Arista arista : LAristas)
        {
            n1.x = arista.getV1().x;
            n1.y = arista.getV1().y;
            n2.x = arista.getV2().x;
            n2.y = arista.getV2().y;
            for(Nodo nodo : Nodos)
            {
                if(nodo.getX() == n1.x && nodo.getY() == n1.y)
                {
                    v1 = Nodos.indexOf(nodo);
                }
                if(nodo.getX() == n2.x && nodo.getY() == n2.y)
                {
                    v2 = Nodos.indexOf(nodo);
                }
            }
            g[v1].add(v2);
        }
        
        System.out.println("El pareo maximo es de: " + maxMatching(g));
    }
    
    //---------------------------------------------------------------------------------------------------------------------
    public static void Perfecto (ArrayList<Nodo> Nodos)
    {
        ArrayList<Arista> LAristas = Vista.getListaAristas();
        int v = Nodos.size();
        Point n1 = new Point();
        Point n2 = new Point();
        List<Integer>[] g = new List[v];
        int v1 = 0, v2 = 0;
        if(v%2==1)
        {
            JOptionPane.showMessageDialog(null, "No es posible un emparejamiento perfecto");
        }
        else
        {
            for (int i = 0; i < v; i++)
            {
                g[i] = new ArrayList<Integer>();
            }

            for(Arista arista : LAristas)
            {
                n1.x = arista.getV1().x;
                n1.y = arista.getV1().y;
                n2.x = arista.getV2().x;
                n2.y = arista.getV2().y;
                for(Nodo nodo : Nodos)
                {
                    if(nodo.getX() == n1.x && nodo.getY() == n1.y)
                    {
                        v1 = Nodos.indexOf(nodo);
                    }
                    if(nodo.getX() == n2.x && nodo.getY() == n2.y)
                    {
                        v2 = Nodos.indexOf(nodo);
                    }
                }
                g[v1].add(v2);
            }

            System.out.println("El pareo perfecto es de: " + maxMatching(g));
        }
    }
}
