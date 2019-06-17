
package ode;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JComponent;

public class Graph extends JComponent{

    int unit = 50, invRes=10;

    double x0=0, x=0,y=0,hx=0;
    double a =0,b =0,c =0,d =0,e =0,f =0,g =0,h =0,i =0,j =0,k =0,l =0,m =0,n =0,p =0,q =0;

    Graphics2D g2d;

    public Graph() {
        super();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        super.setPreferredSize(new Dimension((int)(screenSize.getWidth()*5/6), (int)(screenSize.getHeight()*1)));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        g2d = (Graphics2D) graphics;
        g2d.setBackground(Color.white);
        int width = super.getWidth();
        int height = super.getHeight();
        g2d.clearRect(0, 0, width, height);
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(Color.GRAY);
        g2d.drawLine(width/2, 0, width/2, height);
        g2d.drawLine(0, height/2, width, height/2);
        g2d.setStroke(new BasicStroke(
                        1,
                        BasicStroke.CAP_BUTT,
                        BasicStroke.JOIN_MITER,
                        10, new float[] {10, 2}, 0));
        g2d.setColor(Color.LIGHT_GRAY);
        for(int i=width/2+unit; i<width; i+=unit)
            g2d.drawLine(i, 0, i, height);

        for(int i=width/2-unit; i>0; i-=unit)
            g2d.drawLine(i, 0, i, height);

        for(int i=height/2+unit; i<height; i+=unit)
            g2d.drawLine(0, i, width, i);

        for(int i=height/2-unit; i>0; i-=unit)
            g2d.drawLine(0, i, width, i);


        for(int i=width/2, i2=0; i<width; i+=unit, i2++)
            g2d.drawString(i2+"", i+5, height/2-5);
        for(int i=width/2-unit, i2=-1; i>0; i-=unit, i2--)
            g2d.drawString(i2+"", i+5, height/2-5);
        for(int i=height/2+unit, i2=-1; i<height; i+=unit, i2--)
            g2d.drawString(""+i2, width/2+5, i-5);
        for(int i=height/2-unit, i2=1; i>0; i-=unit, i2++)
            g2d.drawString(""+i2, width/2+5, i-5);
        g2d.setStroke(new BasicStroke(2));

        euler(g2d);
        rungeKutta(g2d);
    }


    public void euler(Graphics2D g2d) {
        g2d.setColor(Color.BLUE);
        double x0=this.x0,x=this.x,y=this.y,h=this.hx;

        Point prev = null;
        int mw = super.getWidth()/2;
        int mh = super.getHeight()/2;

        if(h == 0) return;
        for(double a=x0; a<=x; a+=h){
            int a2 = (int)(a*unit + mw);
            int b2 = (int)(-y*unit + mh);
            System.out.println(a+","+y);
            if(prev != null){
                g2d.drawLine(prev.x, prev.y, a2, b2);
            }
            prev = new Point(a2, b2);
            y = y + h * func(a,y);
        }

    }

    public void rungeKutta(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        double x0=this.x0,x=this.x,y=this.y,h=this.hx;

        Point prev = null;
        int mw = super.getWidth()/2;
        int mh = super.getHeight()/2;

        double k1, k2, k3, k4;

        if(h == 0)  return;
        for (double i=x0; i <=x; i+=h){
            int a2 = (int)(i*unit + mw);
            int b2 = (int)(-y*unit + mh);
            if(prev != null){
                g2d.drawLine(prev.x, prev.y, a2, b2);
            }
            prev = new Point(a2, b2);

            k1 = h * (func(i, y));
            k2 = h * (func(i + 0.5 * h, y + 0.5 * k1));
            k3 = h * (func(i + 0.5 * h, y + 0.5 * k2));
            k4 = h * (func(i + h, y + k3));
            y = y + (1.0 / 6.0) * (k1 + 2 * k2 + 2 * k3 + k4);
        }
    }

    public void setNums(double a,double b,double c,double d,
                        double e,double f,double g,double h,
                        double i,double j,double k,double l,double m,double n,double p,double q) {
        this.a = a;this.b = b;this.c = c;this.d = d;this.e = e;this.f = f;
        this.g = g;this.h = h;this.i = i;this.j = j;this.k = k;this.l = l;
        this.m = m;this.n = n;this.p = p;this.q = q;
    }

    public void setSettings(double x0,double x, double y, double hx){
        this.x0=x0;
        this.x = x;
        this.y = y;
        this.hx = hx;
    }

    double func(double x, double y){
        return a*x*x + b*x + d*y*y + e*y + f*Math.pow(x,p)*Math.pow(y,q) +
                g*Math.sin(h*x) + i*Math.sin(j*y) +k*Math.cos(l*x) + m*Math.cos(n*y) + c;
    }

}
