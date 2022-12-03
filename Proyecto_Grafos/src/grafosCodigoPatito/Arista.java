/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grafosCodigoPatito;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Arista
{
    private Point V1;
    private Point V2;
    private Point A1;
    private Point A2;
    private final Boolean Dirigida;
    private int peso;
    private final static String nombreL[] = {"A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10",//Nombre de las aristas
        "A11", "A12", "A13", "A14", "A15", "A16", "A17", "A18", "A19", "A20"};
    private static final double DELTA = Math.PI / 6;//Longitud del angulo de apertutra de la cabeza de la flecha
    private static final double C = 30;//Longitud de las lineas de la flecha
    
    public Arista(Point V1, Point V2, Boolean Dirigida, int peso)
    {
        this.V1 = V1;
        this.V2 = V2;
        this.A1 = new Point();
        this.A2 = new Point();
        this.Dirigida = Dirigida;
        this.peso = peso;
    }
    
    private void calcularflecha()
    {
        double[] ajustadas = trasladarFigura(V1.x, V1.y);
        double[] cateto = calcularCatetos(ajustadas[0], ajustadas[0]);
        int[] factor = calcularFactor(ajustadas[0], ajustadas[1]);
        double xp = V2.x + (factor[0] * cateto[0]);
        double yp = V2.y + (factor[1] * cateto[1]);
        ajustadas = trasladarFigura(xp, yp);
        A1 = rotarHorario(ajustadas[0], ajustadas[1]);
        A2 = rotarAntiHorario(ajustadas[0], ajustadas[1]);
    }
    
    private double[] trasladarFigura(double x, double y)
    {
        double xp = x - V2.x;
        double yp = V2.y - y;
        double[] coordenadas = {xp, yp};
        return coordenadas;
    }
    
    private double[] calcularCatetos(double x, double y)
    {
        double angulo = Math.atan(y/x);
        double a = Math.sqrt(Math.pow(C,2)/(1+Math.pow(Math.tan(angulo),2)));
        double b = Math.sqrt(Math.pow(C,2) - Math.pow(a, 2));
        double[] ab = {a, b};
        return ab;
    }
    
    private int[] calcularFactor(double x, double y)
    {
        double fx = x/Math.abs(x);
        double fy = y/(Math.abs(y)*-1);
        int[] factor = {(int)fx, (int)fy};
        return factor;
    }
    
    private Point rotarHorario(double x, double y)
    {
        double xp = x * Math.cos(DELTA) + y * Math.sin(DELTA);
        double yp = (-1 * x * Math.sin(DELTA)) + y * Math.cos(DELTA);
        xp = V2.x + xp;
        yp = V2.y -yp;
        return new Point((int)xp, (int)yp);
    }
    
    private Point rotarAntiHorario(double x, double y)
    {
        double xp = x * Math.cos(DELTA) +(-1 * y * Math.sin(DELTA));
        double yp = x * Math.sin(DELTA) + y * Math.cos(DELTA);
        xp = V2.x + xp;
        yp = V2.y - yp;
        return new Point((int)xp, (int)yp);
    }
    
    public void pintar(Graphics g, Color col)
    {
        Graphics2D draw = (Graphics2D) g;
        BasicStroke grosor = new BasicStroke(5);
        draw.setStroke(grosor);
        draw.setColor(col);//Color de la arista
        if(Dirigida == false)
        {
            if(V1.x == V2.x && V1.y == V2.y)
            {
                draw.drawArc(V1.x - Nodo.d/2, V1.y - Nodo.d, 25, 25, 300, 300);
            }
            else
            {
                draw.drawLine(V1.x, V1.y, V2.x, V2.y);
            }
        }
        else
        {
            if(V1.x == V2.x && V1.y == V2.y)
            {
                draw.drawArc(V1.x - Nodo.d/2, V1.y - Nodo.d, 25, 25, 300, 300);
            }
            else
            {
                calcularflecha();
                draw.drawLine(V1.x, V1.y, V2.x, V2.y);
                draw.drawLine(A1.x, A1.y, V2.x, V2.y);
                draw.drawLine(A2.x, A2.y, V2.x, V2.y);
            }
        }
        if(peso > 1)
        {
            Font Fuente = new Font("MONOSPACED",Font.BOLD, 18);
            draw.setFont(Fuente);
            draw.setColor(new Color(255, 87, 51));
            if(V1.x > V2.x && V1.y > V2.y)
            {
                draw.drawString(String.valueOf(peso), V1.x - Math.abs((V1.x-V2.x)/2), V1.y - Math.abs((V1.y-V2.y)/2));
            }
            else if(V1.x < V2.x && V1.y < V2.y)
            {
                draw.drawString(String.valueOf(peso), V2.x - Math.abs((V1.x-V2.x)/2), V2.y - Math.abs((V1.y-V2.y)/2));
            }
            else if(V1.x > V2.x && V1.y < V2.y)
            {
                draw.drawString(String.valueOf(peso), V1.x - Math.abs((V1.x-V2.x)/2), V2.y - Math.abs((V1.y-V2.y)/2));
            }
            else
            {
                draw.drawString(String.valueOf(peso), V2.x - Math.abs((V1.x-V2.x)/2), V1.y - Math.abs((V1.y-V2.y)/2));
            }
        }
    }

    public Point getV1() {
        return V1;
    }

    public void setV1(Point V1) {
        this.V1 = V1;
    }

    public Point getV2() {
        return V2;
    }

    public void setV2(Point V2) {
        this.V2 = V2;
    }

    public static String[] getNombreL() {
        return nombreL;
    }
}
