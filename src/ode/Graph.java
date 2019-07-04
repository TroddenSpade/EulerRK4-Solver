
package ode;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Graph extends JComponent {

    int unit = 50;

    double x0 = 0, x = 0, y = 0, hx = 0;
    double a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0, i = 0, j = 0, k = 0, l = 0, m = 0, n = 0,
            p = 0, q = 0, o=0, r=0;

    Graphics2D g2d;

    ArrayList<Shape> shapes = new ArrayList<>();

    public Graph() {
        super();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        super.setPreferredSize(new Dimension((int) (screenSize.getWidth() * 5 / 6), (int) (screenSize.getHeight() * 1)));
    }

    public ArrayList<Shape> getShapes() {
        return shapes;
    }

    @Override
    protected void paintComponent(Graphics graphics) {


        g2d = (Graphics2D) graphics;
        draw(g2d);
    }

    public void draw(Graphics2D g2d){
        int width = super.getWidth();
        int height = super.getHeight();

        g2d.setBackground(Color.white);
        g2d.clearRect(0, 0, width, height);
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(Color.GRAY);
        g2d.drawLine(width / 2, 0, width / 2, height);
        g2d.drawLine(0, height / 2, width, height / 2);
        g2d.setStroke(new BasicStroke(
                1,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                10, new float[]{10, 2}, 0));
        try {
            Image myImage = ImageIO.read(new File("resources/ode/kntu.png"));
            myImage = myImage.getScaledInstance(200, 200, Image.SCALE_AREA_AVERAGING);
            AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f);
            g2d.setComposite(composite);
            g2d.drawImage(myImage, width/2-100, height/2-100,null);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        AlphaComposite composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f);
        g2d.setComposite(composite);
        g2d.setColor(Color.LIGHT_GRAY);
        for (int i = width / 2 + unit; i < width; i += unit)
            g2d.drawLine(i, 0, i, height);

        for (int i = width / 2 - unit; i > 0; i -= unit)
            g2d.drawLine(i, 0, i, height);

        for (int i = height / 2 + unit; i < height; i += unit)
            g2d.drawLine(0, i, width, i);

        for (int i = height / 2 - unit; i > 0; i -= unit)
            g2d.drawLine(0, i, width, i);

        for (int i = width / 2, i2 = 0; i < width; i += unit, i2++)
            g2d.drawString(i2 + "", i + 5, height / 2 - 5);
        for (int i = width / 2 - unit, i2 = -1; i > 0; i -= unit, i2--)
            g2d.drawString(i2 + "", i + 5, height / 2 - 5);
        for (int i = height / 2 + unit, i2 = -1; i < height; i += unit, i2--)
            g2d.drawString("" + i2, width / 2 + 5, i - 5);
        for (int i = height / 2 - unit, i2 = 1; i > 0; i -= unit, i2++)
            g2d.drawString("" + i2, width / 2 + 5, i - 5);
        g2d.setStroke(new BasicStroke(2));

        for(Shape shape : shapes){
            shape.draw(g2d);
        }
    }


    public void euler(JPanel shapesInfo) {
        double x0 = this.x0,y = this.y, h = this.hx;
        double y2 = this.y;

        Point prev = null;
        ArrayList<Point> frontPoints = new ArrayList<>();
        int mw = super.getWidth() / 2;
        int mh = super.getHeight() / 2;

        if (h == 0) return;
        for (double a = x0; a <= 15; a += h) {
            int a2 = (int) (a * unit + mw);
            int b2 = (int) (-y * unit + mh);
            frontPoints.add(new Point(a2,b2));
            y = y + h * func(a, y);
        }
        prev = null;
        ArrayList<Point> backPoints = new ArrayList<>();
        for (double a = x0; a >= -15; a -= h) {
            int a2 = (int) (a * unit + mw);
            int b2 = (int) (-y2 * unit + mh);
            backPoints.add(new Point(a2,b2));
            y2 = y2 - h * func(a, y2);
        }
        shapes.add(new Shape(frontPoints,backPoints,0,shapesInfo,h));

    }

    public void rungeKutta(JPanel shapesInfo) {
        double x0 = this.x0, y = this.y, h = this.hx;
        double y2 = this.y;

        Point prev = null;
        int mw = super.getWidth() / 2;
        int mh = super.getHeight() / 2;

        double k1, k2, k3, k4;

        if (h == 0) return;
        ArrayList<Point> frontPoints = new ArrayList<>();
        for (double i = x0; i <= 15; i += h) {
            int a2 = (int) (i * unit + mw);
            int b2 = (int) (-y * unit + mh);
            frontPoints.add(new Point(a2,b2));
            k1 = h * (func(i, y));
            k2 = h * (func(i + 0.5 * h, y + 0.5 * k1));
            k3 = h * (func(i + 0.5 * h, y + 0.5 * k2));
            k4 = h * (func(i + h, y + k3));
            y = y + (1.0 / 6.0) * (k1 + 2 * k2 + 2 * k3 + k4);
        }

        prev = null;
        ArrayList<Point> backPoints = new ArrayList<>();
        for (double i = x0; i >= -15; i -= h) {
            int a2 = (int) (i * unit + mw);
            int b2 = (int) (-y2 * unit + mh);
            backPoints.add(new Point(a2,b2));
            k1 = h * (func(i, y2));
            k2 = h * (func(i + 0.5 * h, y2 + 0.5 * k1));
            k3 = h * (func(i + 0.5 * h, y2 + 0.5 * k2));
            k4 = h * (func(i + h, y2 + k3));
            y2 = y2 - (1.0 / 6.0) * (k1 + 2 * k2 + 2 * k3 + k4);
        }
        shapes.add(new Shape(frontPoints,backPoints,1,shapesInfo,h));
    }

    public void setNums(double a, double b, double c, double d,
                        double e, double f, double g, double h,
                        double i, double j, double k, double l,
                        double m, double n, double p, double q, double o, double r) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        this.g = g;
        this.h = h;
        this.i = i;
        this.j = j;
        this.k = k;
        this.l = l;
        this.m = m;
        this.n = n;
        this.p = p;
        this.q = q;
        this.o = o;
        this.r = r;
    }

    public void setSettings(double x0, double y, double hx) {
        this.x0 = x0;
        this.y = y;
        this.hx = hx;
    }

    double func(double x, double y) {
        return a * x * x + b * x + d * y * y + e * y + f * Math.pow(x, p) * Math.pow(y, q) +
                g * Math.sin(h * x) + i * Math.sin(j * y) + k * Math.cos(l * x) + m * Math.cos(n * y)
                + o*Math.pow(Math.E,r) + c;
    }

    public void clearShapes() {
        this.shapes.clear();
    }

    public BufferedImage getBI(){
        g2d.dispose();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        return new BufferedImage(
//                (int) (screenSize.getWidth() * 5 / 6),
//                (int) (screenSize.getHeight());
        return null;
    }

    public void convert(ArrayList<Shape> shapes){
        int mw = super.getWidth() / 2;
        int mh = super.getHeight() /2;

        if(shapes.size()>1){
            ArrayList<Point> frontPoints = new ArrayList<>();
            for (double a = 0; a < 12; a += 0.01) {
                int a2 = (int) (a * unit + mw);
                int b1 = (int) shapes.get(0).getPoint(a2);
                int b2 = (int) shapes.get(1).getPoint(a2);
                frontPoints.add(new Point(a2,mh-Math.abs(b1-b2)));
            }
            ArrayList<Point> backPoints = new ArrayList<>();
            for (double a = 0; a > -12; a -= 0.01) {
                int a2 = (int) (a * unit + mw);
                int b1 = (int) shapes.get(0).getPoint(a2);
                int b2 = (int) shapes.get(1).getPoint(a2);
                backPoints.add(new Point(a2,mh-Math.abs(b1-b2)));
            }
            this.shapes.add(new Shape(frontPoints,backPoints));
        }
    }
}

class ImagePanel extends JPanel {

    private Image img;

    public ImagePanel(String img) {
        this(new ImageIcon(img).getImage());
    }

    public ImagePanel(Image img) {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

}