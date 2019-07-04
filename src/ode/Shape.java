package ode;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Shape {
    private static int no = 0;
    private ArrayList<Point> frontPoints;
    private ArrayList<Point> backPoints;
    private int noColor;

    Shape(ArrayList<Point> frontPoints,ArrayList<Point> backPoints,int type,JPanel shapesInfo,double h){
        if (no>3)   return;
        this.noColor = this.no;
        this.frontPoints = frontPoints;
        this.backPoints = backPoints;
        this.no++;
        JLabel label;
        if(type == 0){
            label = new JLabel("Euler     "+"h:" + h);
            label.setForeground(Colors.values()[noColor].getColor());
            label.setFont(new Font("Boulder", Font.BOLD, 16));
            shapesInfo.add(label);
        }else if(type == 1){
            label = new JLabel("Runge-Kutta  "+"h:" + h);
            label.setForeground(Colors.values()[noColor].getColor());
            label.setFont(new Font("Boulder", Font.BOLD, 16));
            shapesInfo.add(label);
        }
    }

    Shape(ArrayList<Point> frontPoints,ArrayList<Point> backPoints){
//        if (no>7)   return;
        this.noColor = this.no;
        this.frontPoints = frontPoints;
        this.backPoints = backPoints;
        this.no++;
    }

    public void draw(Graphics2D g2d){
        g2d.setColor(Colors.values()[noColor%8].getColor());
        Point prev = null;
        for(Point point : frontPoints){
            if(prev != null){
                g2d.drawLine(prev.x, prev.y, point.x, point.y);
            }
            prev = point;
        }
        prev = null;
        for(Point point : backPoints){
            if(prev != null){
                g2d.drawLine(prev.x, prev.y, point.x, point.y);
            }
            prev = point;
        }
    }

    public double getPoint(double x){
        Point prev;
        Point next;
        if(frontPoints.get(0).getX() == x){
            return frontPoints.get(0).getY();
        }else if(frontPoints.get(0).getX() < x) {
            int i = 0;
            while (frontPoints.get(i).getX() <= x) {
                i++;
            }
            next = frontPoints.get(i);
            prev = frontPoints.get(i - 1);
            double y = (next.getY() - prev.getY()) / (next.getX() - prev.getX()) * (x - prev.getX()) + prev.getY();
            return y;
        }else if(frontPoints.get(0).getX() == x){

        }else if (backPoints.get(0).getX() > x){
            int i = 1;
            while(backPoints.get(i).getX() >= x){
                i++;
            }
            next = backPoints.get(i-1);
            prev = backPoints.get(i);
            return (next.getY()-prev.getY())/(next.getX()-prev.getX())*(x-prev.getX()) + prev.getY();
        }
        return 0;
    }

    public static void reset(){
        no = 0;
    }
}

