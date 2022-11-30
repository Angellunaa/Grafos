package recorridos_bfs_dfs;

import java.util.ArrayList;
import java.util.Stack;

class Grafo {

    public int[][] g = {{0, 1, 1, 0, 0, 0, 0},
                              {0, 0, 0, 1, 0, 0, 0},
                              {0, 0, 0, 0, 1, 0, 0},
                              {1, 0, 0, 0, 0, 1, 1},
                              {0, 0, 0, 1, 0, 0, 0},
                              {0, 0, 0, 0, 0, 0, 0},
                              {0, 0, 0, 0, 0, 0, 0}};
    
    private boolean[] visitiadoAnchura = new boolean[7];
    private boolean[] visitiadoProfunidad = new boolean[7];

    public Grafo() {
    }

    public int[][] getG() {
        return g;
    }

public ArrayList<Integer> recorridoAnchura(int nodoI) {
        ArrayList<Integer> recorridos = new ArrayList<Integer>();
        visitiadoAnchura[nodoI] = true;
        ArrayList<Integer> cola = new ArrayList<Integer>();
        recorridos.add(nodoI);
        cola.add(nodoI);
        while (!cola.isEmpty()) {
            int j = cola.remove(0); 
            for (int i = 0; i < g.length; i++) {
                if (g[j][i] == 1 && !visitiadoAnchura[i]) {
                    cola.add(i);
                    recorridos.add(i);
                    visitiadoAnchura[i] = true;
                }
            }
        }
        return recorridos;
    }

    public Stack<Integer> recorridoProfunidad(int nodoI) {
        Stack<Integer> recorridos = new Stack<Integer>();
        visitiadoProfunidad[nodoI] = true;
        Stack<Integer> pila = new Stack<Integer>();
        recorridos.add(nodoI);
        pila.add(nodoI);
        while (!pila.isEmpty()) {
            int j = pila.remove(0);
            for (int i = 0; i < g.length; i++) {
                if (g[j][i] == 1 && !visitiadoProfunidad[i]) {
                    pila.add(i);
                    recorridos.addAll(recorridoProfunidad(i));
                    visitiadoProfunidad[i] = true;
                }
            }
        }
        return recorridos;
    }
}

public class Prueba {

    public static void main(String[] args) {
        Grafo g=new Grafo();
        ArrayList<Integer> enAnchura=g.recorridoAnchura(0);//Nodo inicial 0
        System.out.println("Recorrido en anchura de un grafo representado como matriz: ");
        for(int i=0;i<enAnchura.size();i++)
        {
            System.out.print(""+enAnchura.get(i)+" ");
        }
        Stack<Integer> enProfundidad=g.recorridoProfunidad(0);//Nodo inicial 0
        System.out.println("");
        System.out.println("Recorrido en profundidad de un grafo representado como matriz: ");
        for(int i=0;i<enProfundidad.size();i++)
        {
            System.out.print(""+enProfundidad.get(i)+" ");
        }
        System.out.println("\n");
    }

}
