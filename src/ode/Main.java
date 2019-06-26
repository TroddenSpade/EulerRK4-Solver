package ode;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class Main extends JFrame{
    static JFrame frame;
    private URI github;
    private URI drHA;

    Graph graph;
    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu more = new JMenu("Help");

    JMenuItem about = new JMenuItem(new AbstractAction("About Us") {
        public void actionPerformed(ActionEvent e) {
            modal(frame);
        }
    });

    JMenuItem save = new JMenuItem(new AbstractAction("Save") {
        public void actionPerformed(ActionEvent e) {

        }
    });

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
        try {
            github = new URI("https://github.com/TroddenSpade");
            drHA = new URI("https://wp.kntu.ac.ir/aliakbarian/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
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
        name.setBackground(Color.WHITE);
        setXY.setBackground(Color.WHITE);
        setH.setBackground(Color.WHITE);
        settings.setBackground(Color.WHITE);
        function.setBackground(Color.WHITE);
        polyX.setBackground(Color.WHITE);
        polyY.setBackground(Color.WHITE);
        multi.setBackground(Color.WHITE);
        scX.setBackground(Color.WHITE);
        scY.setBackground(Color.WHITE);
        cost.setBackground(Color.WHITE);
        eExp.setBackground(Color.WHITE);

        more.setPreferredSize(new Dimension(50,30));
        file.setPreferredSize(new Dimension(50,30));
        menuBar.setBorderPainted(false);
        menuBar.setBackground(Color.WHITE);
        menuBar.setForeground(Color.GRAY);
        more.add(about);
        file.add(save);
        menuBar.add(file);
        menuBar.add(more);
        this.setJMenuBar(menuBar);
        settings.setLayout(new BoxLayout(settings, BoxLayout.Y_AXIS));
        settings.setPreferredSize(
                new Dimension(
                        (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/5,
                        (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()));

        graph = new Graph();
        mainPanel.add(graph);
        mainPanel.add(settings,BorderLayout.EAST);

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
        frame = new Main();
    }

    public void modal(JFrame frame){
        JDialog jDialog = new JDialog(frame , "About Us", true);
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        JPanel devs = new JPanel();
        devs.setLayout(new BoxLayout(devs, BoxLayout.Y_AXIS));

        JPanel kntu = new JPanel();
        class OpenUrlAction1 implements ActionListener {
            @Override public void actionPerformed(ActionEvent e) {
                open(github);
            }
        }
        class OpenUrlAction2 implements ActionListener {
            @Override public void actionPerformed(ActionEvent e) {
                open(drHA);
            }
        }
        JLabel dev = new JLabel("Developed By");
        JLabel muhrez = new JLabel("Muhammad Reza Kolagar");
        JLabel drHAL = new JLabel("Under Supervision of Dr.Hadi Aliakbarian");
        JPanel parsa = new JPanel();
        JPanel drHA = new JPanel();
        JButton parsaB = new JButton();
        JButton drHAB = new JButton();
        parsa.setMaximumSize(new Dimension((int)parsaB.getPreferredSize().getWidth()+56
                ,(int)parsaB.getPreferredSize().getHeight()));
        parsa.add(parsaB);
        drHA.add(drHAL);drHA.add(drHAB);
        parsaB.setText("<HTML><p1 color=\"#808080\"><U>Parsa Samadnejad</U></p1>"
                + "</HTML>");
        parsaB.setHorizontalAlignment(SwingConstants.LEFT);
        parsaB.setBorderPainted(false);
        parsaB.setOpaque(false);
        parsaB.setBackground(Color.WHITE);
        parsaB.setToolTipText(github.toString());
        parsaB.addActionListener(new OpenUrlAction1());
        drHAB.setText("<HTML><p1 color=\"#808080\"><U>website</U></p1>"
                + "</HTML>");
        drHAB.setHorizontalAlignment(SwingConstants.LEFT);
        drHAB.setBorderPainted(false);
        drHAB.setOpaque(false);
        drHAB.setBackground(Color.WHITE);
        drHAB.setToolTipText(this.drHA.toString());
        drHAB.addActionListener(new OpenUrlAction2());

        parsa.setAlignmentX(Component.LEFT_ALIGNMENT);
        muhrez.setAlignmentX(Component.LEFT_ALIGNMENT);
        drHA.setAlignmentX(Component.LEFT_ALIGNMENT);
        dev.setBorder(BorderFactory.createEmptyBorder(10,20,0,0));
        parsa.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
        muhrez.setBorder(BorderFactory.createEmptyBorder(0,20,0,0));
        drHA.setBorder(BorderFactory.createEmptyBorder(100,0,0,0));
        devs.add(dev);
        devs.add(parsa);
        devs.add(muhrez);
        devs.add(drHA);
        try {
            Image myImage = ImageIO.read(new File("resources/ode/logo.png"));
            myImage = myImage.getScaledInstance(250, 250, Image.SCALE_AREA_AVERAGING);
            JLabel imageLabel = new JLabel(new ImageIcon(myImage));
            kntu.add(imageLabel);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        container.add(devs);
        container.add(kntu);
        jDialog.add(container);
        jDialog.setSize(700,300);
        jDialog.setResizable(false);
        jDialog.setLocationRelativeTo(null);
        jDialog.setVisible(true);
    }

    private static void open(URI uri) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(uri);
            } catch (Exception e) { /* TODO: error handling */ }
        } else { /* TODO: error handling */ }
    }
}