/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafosCodigoPatito;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Nodo
{
    private int x, y;//Cordenadas del vertices
    private int indice;
    public static final int d = 30; //Diametro del circulo
    private static String nombreN[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
    "M", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};//Nombre de los nodos

    public Nodo(int x, int y, int indice) {
        this.x = x;
        this.y = y;
        this.indice = indice;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public static String[] getNombreN() {
        return nombreN;
    }
    
    public void pintar(Graphics g, Color col)
    {
        Graphics2D draw = (Graphics2D) g;
        draw.setColor(col);//Color del ovalo
        //Se le resta el radio a X y Y. El ancho y alto sera el diametro
        draw.fillOval(x-d/2, y-d/2, d, d);
        draw.setColor(Color.black);//Color de la letra
        Font nuevaFuente = new Font("Monospaced", Font.BOLD, 16);//Nueva fuente de letra
        draw.setFont(nuevaFuente);//Le agrega la fuente al nodo
        
        //Le agrega nombre al vertice
        draw.drawString(nombreN[indice], x-5, y+5);//Dibuja el nombre del vertice
    }
}
