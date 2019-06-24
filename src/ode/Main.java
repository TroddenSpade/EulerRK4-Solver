
package ode;

import javafx.scene.shape.Circle;
import sun.tools.jps.Jps;

import java.awt.*;
import javax.swing.*;

public class Main extends JFrame{

    Graph graph;
    JLabel euler = new JLabel("Euler");
    JLabel runge = new JLabel("RungeKutta");
    JLabel x0 = new JLabel("x0 :");
    JTextField inputX0 = new JTextField(5);
    JLabel y = new JLabel("y(x0) :");
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
    JTextField eX = new JTextField(2);
    JTextField eXN = new JTextField(2);

    JLabel yP = new JLabel("Y' = ");
    JLabel aL = new JLabel("F(x,y) =");
    JLabel bL = new JLabel("X^2 +");
    JLabel dL = new JLabel("X +");
    JLabel cL = new JLabel(" +");
    JLabel eL = new JLabel("Y^2 +");
    JLabel fL = new JLabel("Y +");
    JLabel pL = new JLabel("X^");
    JLabel qL = new JLabel(".Y^");
    JLabel gL = new JLabel("+");
    JLabel hL = new JLabel("Sin(");
    JLabel iL = new JLabel("X) +");
    JLabel jL = new JLabel("Sin(");
    JLabel kL = new JLabel("Y) +");
    JLabel lL = new JLabel("Cos(");
    JLabel mL = new JLabel("X) +");
    JLabel nL = new JLabel("Cos(");
    JLabel lastl = new JLabel("Y)");
    JLabel exp = new JLabel("e^");
    JLabel plus = new JLabel("+");

    JButton draw = new JButton("Draw");

    public Main() {
        super("Euler Runge-Kutta");
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel name = new JPanel();
        JPanel setXY = new JPanel();
        JPanel setH = new JPanel();
        JPanel settings = new JPanel();
        JPanel function = new JPanel();
        JPanel polyX = new JPanel();
        JPanel polyY = new JPanel();
        JPanel multi = new JPanel();
        JPanel scX = new JPanel();
        JPanel scY = new JPanel();
        JPanel cost = new JPanel();
        JPanel eExp = new JPanel();
        settings.setLayout(new BoxLayout(settings, BoxLayout.Y_AXIS));
        settings.setPreferredSize(
                new Dimension(
                        (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/5,
                        (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()));

        graph = new Graph();
        mainPanel.add(graph);
        mainPanel.add(settings,BorderLayout.EAST);
        mainPanel.add(function,BorderLayout.SOUTH);

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.getContentPane().add(mainPanel);
        super.pack();
        super.setVisible(true);


        setXY.add(x0);setXY.add(inputX0);
        setXY.add(y);setXY.add(inputY);
        setH.add(h);setH.add(inputH);
        name.add(euler);name.add(runge);

        euler.setForeground(Color.BLUE);
        runge.setForeground(Color.RED);
        euler.setFont(new Font("TimesRoman", Font.BOLD, 32));
        runge.setFont(new Font("TimesRoman", Font.BOLD, 32));
        yP.setFont(new Font("TimesRoman", Font.ITALIC, 24));
        aL.setFont(new Font("TimesRoman", Font.ITALIC, 24));

        settings.add(name);
        settings.add(setXY);settings.add(setXY);settings.add(setH);
        settings.add(function);
        settings.add(polyX);
        settings.add(polyY);
        settings.add(multi);
        settings.add(eExp);
        settings.add(scX);
        settings.add(scY);
        settings.add(cost);
        settings.add(draw);

        function.add(yP);function.add(aL);
        polyX.add(aT);polyX.add(bL);
        polyX.add(bT);polyX.add(dL);
        polyY.add(dT);polyY.add(eL);
        polyY.add(eT);polyY.add(fL);
        eExp.add(eX);eExp.add(exp);eExp.add(eXN);eExp.add(plus);
        cost.add(fT);
        multi.add(cT);multi.add(pL);multi.add(pT);multi.add(qL);multi.add(qT);multi.add(gL);
        scX.add(gT);scX.add(hL);scX.add(hT);scX.add(iL);
        scY.add(iT);scY.add(jL);scY.add(jT);scY.add(kL);
        scX.add(kT);scX.add(lL);scX.add(lT);scX.add(mL);
        scY.add(mT);scY.add(nL);scY.add(nT);scY.add(lastl);scY.add(cL);

        function.setMaximumSize(function.getPreferredSize());
        polyX.setMaximumSize(polyX.getPreferredSize());
        polyY.setMaximumSize(polyY.getPreferredSize());
        eExp.setMaximumSize(eExp.getPreferredSize());
        multi.setMaximumSize(multi.getPreferredSize());
        scX.setMaximumSize(scX.getPreferredSize());
        scY.setMaximumSize(scY.getPreferredSize());
//        cost.setMaximumSize(function.getPreferredSize());

        draw.addActionListener(e -> {
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
                checkZero(qT.getText()),
                checkZero(eXN.getText()),
                checkZero(eX.getText()));
    }

    public void setSettings(){
        graph.setSettings(
                checkZero(inputX0.getText()),
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