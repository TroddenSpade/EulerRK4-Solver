
package ode;

import java.awt.*;
import javax.swing.*;

public class Main extends JFrame{

    Graph graph;
    JLabel x0 = new JLabel("x0 :");
    JTextField inputX0 = new JTextField(5);
    JLabel x = new JLabel("x :");
    JTextField inputX = new JTextField(5);
    JLabel y = new JLabel("y(0) :");
    JTextField inputY = new JTextField(5);
    JLabel h = new JLabel("h :");
    JTextField inputH = new JTextField(5);

    JTextField aT = new JTextField(2);
    JTextField bT = new JTextField(2);
    JTextField cT = new JTextField(2);
    JTextField dT = new JTextField(2);
    JTextField eT = new JTextField(2);
    JTextField fT = new JTextField(2);
    JTextField gT = new JTextField(2);
    JTextField hT = new JTextField(2);
    JTextField iT = new JTextField(2);
    JTextField jT = new JTextField(2);
    JTextField kT = new JTextField(2);
    JTextField lT = new JTextField(2);
    JTextField mT = new JTextField(2);
    JTextField nT = new JTextField(2);
    JTextField pT = new JTextField(2);
    JTextField qT = new JTextField(2);

    JLabel yP = new JLabel("Y' = ");
    JLabel aL = new JLabel("F(x,y) =");
    JLabel bL = new JLabel("X^2 +");
    JLabel dL = new JLabel("X +");
    JLabel cL = new JLabel(" +");
    JLabel eL = new JLabel("Y^2 +");
    JLabel fL = new JLabel("Y +");
    JLabel pL = new JLabel("X^");
    JLabel qL = new JLabel(".Y^");
    JLabel gL = new JLabel(" +");
    JLabel hL = new JLabel("Sin(");
    JLabel iL = new JLabel("X) +");
    JLabel jL = new JLabel("Sin(");
    JLabel kL = new JLabel("Y) +");
    JLabel lL = new JLabel("Cos(");
    JLabel mL = new JLabel("X) +");
    JLabel nL = new JLabel("Cos(");
    JLabel lastl = new JLabel("Y)");

    JButton drawEuler = new JButton("Euler");
    JButton drawRunge = new JButton("Runge kutta");

    public Main() {
        super("Euler - RungeKutta");
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel setX = new JPanel();
        JPanel setY = new JPanel();
        JPanel setH = new JPanel();
        JPanel settings = new JPanel();
        JPanel function = new JPanel();
        settings.setLayout(new BoxLayout(settings, BoxLayout.Y_AXIS));
        settings.setPreferredSize(
                new Dimension(
                        (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/6,
                        (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()));

        graph = new Graph();
        mainPanel.add(graph);
        mainPanel.add(settings,BorderLayout.EAST);
        mainPanel.add(function,BorderLayout.SOUTH);

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.getContentPane().add(mainPanel);
        super.pack();
        super.setVisible(true);


        setX.add(x0);setX.add(inputX0);setX.add(x);
        setX.add(inputX);setY.add(y);setY.add(inputY);
        setH.add(h);setH.add(inputH);

        settings.add(setX);settings.add(setY);settings.add(setH);
        settings.add(drawEuler);settings.add(drawRunge);

        function.add(yP);
        function.add(aL);function.add(aT);
        function.add(bL);function.add(bT);
        function.add(dL);function.add(dT);
        function.add(eL);function.add(eT);
        function.add(fL);function.add(fT);
        function.add(cL);function.add(cT);
        function.add(pL);function.add(pT);
        function.add(qL);function.add(qT);
        function.add(gL);function.add(gT);
        function.add(hL);function.add(hT);
        function.add(iL);function.add(iT);
        function.add(jL);function.add(jT);
        function.add(kL);function.add(kT);
        function.add(lL);function.add(lT);
        function.add(mL);function.add(mT);
        function.add(nL);function.add(nT);
        function.add(lastl);

        drawEuler.addActionListener(e -> {
            setSettings();
            setFunction();
            graph.repaint();
        });
        drawRunge.addActionListener(e -> {
            setSettings();
            setFunction();
            graph.repaint();
        });

    }

    public void setFunction(){
        graph.setNums(
                checkZero(aT.getText()),
                checkZero(bT.getText()),
                checkZero(cT.getText()),
                checkZero(dT.getText()),
                checkZero(eT.getText()),
                checkZero(fT.getText()),
                checkZero(gT.getText()),
                checkZero(hT.getText()),
                checkZero(iT.getText()),
                checkZero(jT.getText()),
                checkZero(kT.getText()),
                checkZero(lT.getText()),
                checkZero(mT.getText()),
                checkZero(nT.getText()),
                checkZero(pT.getText()),
                checkZero(qT.getText()));
    }

    public void setSettings(){
        graph.setSettings(
                checkZero(inputX0.getText()),
                checkZero(inputX.getText()),
                checkZero(inputY.getText()),
                checkZero(inputH.getText()));
    }

    public double checkZero(String str) {
        double num;
        try {
            num = Double.parseDouble(str);
        }catch (Exception e){
            return 0;
        }
        return num;
    }

    public static void main(String[] args) {
        //Create a new object
        new Main();
    }

}