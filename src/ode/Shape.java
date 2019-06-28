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
        if (no>7)   return;
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

    public static void reset(){
        no = 0;
    }
}

