package ode;

import java.awt.*;
import java.util.ArrayList;

public class Shape {
    private static int no = 0;
    private ArrayList<Point> frontPoints;
    private ArrayList<Point> backPoints;
    private int noColor;
    Shape(ArrayList<Point> frontPoints,ArrayList<Point> backPoints){
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
}

