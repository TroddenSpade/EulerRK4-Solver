package ode;

import java.awt.*;
import javax.imageio.ImageIO;
import javax.jnlp.FileContents;
import javax.jnlp.FileOpenService;
import javax.jnlp.FileSaveService;
import javax.jnlp.ServiceManager;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main extends JFrame{
    static JFrame frame;
    private URI github;
    private URI drHA;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    Graph graph;
    Graph dif = new Graph();
    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu more = new JMenu("Help");
    JMenu space = new JMenu("<html><p style='margin-left:"+
            ((int) (screenSize.getWidth() * 5 / 6)/2-220)+
            "'><p/>");
    JMenuItem graphMenu;
    JMenuItem diffMenu;

    JLabel euler = new JLabel("Euler-RK4 Solver");
    JLabel initial = new JLabel("Initial Values");
    JLabel x0 = new JLabel("<html>X<sub>0</sub>:</html>");
    JTextField inputX0 = new JTextField(5);
    JLabel y = new JLabel("<html>Y(X<sub>0</sub>):</html>");
    JTextField inputY = new JTextField(5);
    JLabel h = new JLabel("Step  h :");
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
    JTextField oT = new JTextField(2);
    JTextField rT = new JTextField(2);

    JLabel aL = new JLabel("A:");
    JLabel bL = new JLabel("B:");
    JLabel dL = new JLabel("D:");
    JLabel cL = new JLabel("C:");
    JLabel eL = new JLabel("E:");
    JLabel fL = new JLabel("F:");
    JLabel pL = new JLabel("p:");
    JLabel qL = new JLabel("q:");
    JLabel gL = new JLabel("G:");
    JLabel hL = new JLabel("H:");
    JLabel iL = new JLabel("I:");
    JLabel jL = new JLabel("J:");
    JLabel kL = new JLabel("K:");
    JLabel lL = new JLabel("L:");
    JLabel mL = new JLabel("M:");
    JLabel nL = new JLabel("N:");
    JLabel oL = new JLabel("O:");
    JLabel rL = new JLabel("r:");
    JLabel func = new JLabel(
            "<html><h2> <i>Y</i>' = A<i>x</i><sup>2</sup> + B<i>x</i> + D<i>y</i><sup>2</sup> + E<i>y</i> + "
            +"F<i>x</i><sup>p</sup><i>y</i><sup>q</sup> + "
            +"G.sin(H<i>x</i>) + I.sin(J<i>y</i>) + Kcos(L<i>x</i>) + Mcos(N<i>y</i>) + "
            +"O<i>x</i><sup>r</sup> + "
            +"C"
            +"</h2></html>");

    JButton clear = new JButton("clear Screen");
    JButton clearF = new JButton("clear TextFields");
    JButton drawEuler = new JButton("Draw Euler");
    JButton drawRunge = new JButton("Draw RK4");

    public Main() {
        super("Euler-RK4 Solver");
        JPanel mainPanel = new JPanel(new BorderLayout());
        try {
            github = new URI("https://github.com/TroddenSpade");
            drHA = new URI("https://wp.kntu.ac.ir/aliakbarian/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        graphMenu = new JMenuItem(new AbstractAction("Graph") {
            public void actionPerformed(ActionEvent e) {
                graphMenu.setBackground(Color.cyan);
                diffMenu.setBackground(Color.white);
                mainPanel.remove(dif);
                mainPanel.add(graph);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        graphMenu.setBackground(Color.cyan);

        diffMenu = new JMenuItem(new AbstractAction("Difference") {
            public void actionPerformed(ActionEvent e) {
                diffMenu.setBackground(Color.cyan);
                graphMenu.setBackground(Color.white);
                mainPanel.remove(graph);
                mainPanel.add(dif);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });

        JMenuItem about = new JMenuItem(new AbstractAction("About Us") {
            public void actionPerformed(ActionEvent e) {
                helpModal(frame);
            }
        });

        JMenuItem save = new JMenuItem(new AbstractAction("Save") {
            public void actionPerformed(ActionEvent e) {
                saveModal(frame);
            }
        });
        space.setOpaque(false);
        graphMenu.setMaximumSize(new Dimension(80,30));
        diffMenu.setMaximumSize(new Dimension(110,30));
        JPanel name = new JPanel();
        JPanel initialvalues = new JPanel();
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
        JPanel shapesInfo = new JPanel();
        JPanel buttons = new JPanel();
        JPanel funcP = new JPanel();
        name.setBackground(Color.WHITE);
        initialvalues.setBackground(Color.WHITE);
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
        shapesInfo.setBackground(Color.WHITE);
        buttons.setBackground(Color.WHITE);
        funcP.setBackground(Color.WHITE);
        func.setForeground(Color.GRAY);

        more.setPreferredSize(new Dimension(50,30));
        file.setPreferredSize(new Dimension(50,30));
        menuBar.setBorderPainted(false);
        menuBar.setBackground(Color.WHITE);
        menuBar.setForeground(Color.GRAY);
        more.add(about);
        file.add(save);
        menuBar.add(file);
        menuBar.add(more);
        menuBar.add(space);
        menuBar.add(graphMenu);
        menuBar.add(diffMenu);
        this.setJMenuBar(menuBar);
        settings.setLayout(new BoxLayout(settings, BoxLayout.Y_AXIS));
        shapesInfo.setLayout(new BoxLayout(shapesInfo, BoxLayout.Y_AXIS));
        shapesInfo.setAlignmentX(java.awt.Component.CENTER_ALIGNMENT);
        settings.setPreferredSize(
                new Dimension(
                        (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/5,
                        (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()));

        graph = new Graph();
        mainPanel.add(dif);
        mainPanel.add(settings,BorderLayout.EAST);
        mainPanel.add(funcP,BorderLayout.SOUTH);

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.getContentPane().add(mainPanel);
        super.pack();
        super.setVisible(true);

        clear.setForeground(Color.GRAY);
        clearF.setForeground(Color.GRAY);

        funcP.add(func);
        initialvalues.add(initial);
        setXY.add(x0);setXY.add(inputX0);
        setXY.add(y);setXY.add(inputY);
        setH.add(h);setH.add(inputH);
        name.add(euler);
        buttons.add(drawRunge);buttons.add(drawEuler);buttons.add(clear);buttons.add(clearF);

        euler.setForeground(Color.GRAY);
        euler.setFont(new Font("Boulder", Font.BOLD, 30));

        settings.add(name);
        settings.add(initialvalues);
        settings.add(setXY);settings.add(setH);
        settings.add(function);
        settings.add(polyX);
        settings.add(polyY);
        settings.add(multi);
        settings.add(eExp);
        settings.add(scX);
        settings.add(scY);
        settings.add(cost);
        settings.add(shapesInfo);
        settings.add(buttons);

        polyX.add(aL);polyX.add(aT);
        polyX.add(bL);polyX.add(bT);
        polyX.add(dL);polyX.add(dT);
        polyX.add(eL);polyX.add(eT);
        cost.add(oL);cost.add(oT);cost.add(rL);cost.add(rT);
        cost.add(cL);cost.add(cT);
        multi.add(fL);multi.add(fT);multi.add(pL);multi.add(pT);multi.add(qL);multi.add(qT);
        scX.add(gL);scX.add(gT);scX.add(hL);scX.add(hT);
        scX.add(iL);scX.add(iT);scX.add(jL);scX.add(jT);
        scY.add(kL);scY.add(kT);scY.add(lL);scY.add(lT);
        scY.add(mL);scY.add(mT);scY.add(nL);scY.add(nT);

        initialvalues.setMaximumSize(initialvalues.getPreferredSize());
        setXY.setMaximumSize(setXY.getPreferredSize());
        function.setMaximumSize(function.getPreferredSize());
        polyX.setMaximumSize(polyX.getPreferredSize());
        polyY.setMaximumSize(polyY.getPreferredSize());
        eExp.setMaximumSize(eExp.getPreferredSize());
        multi.setMaximumSize(multi.getPreferredSize());
        scX.setMaximumSize(scX.getPreferredSize());
        scY.setMaximumSize(scY.getPreferredSize());
//        cost.setMaximumSize(function.getPreferredSize());
        shapesInfo.setPreferredSize(
                new Dimension(
                (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth()/5,
                (int)function.getPreferredSize().getHeight()*5));

//        clear.setBackground(Color.cyan);
//        clearF.setBackground(Color.cyan);

        drawRunge.addActionListener(e -> {
            if (Shape.getNo()>2)   return;
            setSettings();
            setFunction();
            graph.rungeKutta(shapesInfo);
            graph.repaint();
            dif.convert(graph.getShapes());
            dif.repaint();
            shapesInfo.revalidate();
            shapesInfo.repaint();
        });
        drawEuler.addActionListener(e -> {
            if (Shape.getNo()>2)   return;
            setSettings();
            setFunction();
            graph.euler(shapesInfo);
            graph.repaint();
            dif.convert(graph.getShapes());
            dif.repaint();
            shapesInfo.revalidate();
            shapesInfo.repaint();
        });
        clear.addActionListener(e -> {
            graph.clearShapes();
            dif.clearShapes();
            shapesInfo.removeAll();
            shapesInfo.revalidate();
            shapesInfo.repaint();
            Shape.reset();
            dif.repaint();
            graph.repaint();
        });
        clearF.addActionListener(e ->{
            inputX0.setText("");
            inputH.setText("");
            inputY.setText("");
            aT.setText("");
            bT.setText("");
            cT.setText("");
            dT.setText("");
            eT.setText("");
            fT.setText("");
            gT.setText("");
            hT.setText("");
            iT.setText("");
            jT.setText("");
            kT.setText("");
            lT.setText("");
            mT.setText("");
            nT.setText("");
            oT.setText("");
            pT.setText("");
            qT.setText("");
            rT.setText("");
        });
        try {
            Thread.sleep(500);
            mainPanel.remove(graph);
            mainPanel.add(dif);
            mainPanel.revalidate();
            mainPanel.repaint();
            mainPanel.remove(dif);
            mainPanel.add(graph);
            mainPanel.revalidate();
            mainPanel.repaint();
        }catch (Exception e){}
        this.setResizable(false);
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
                checkZero(oT.getText()),
                checkZero(rT.getText()));
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

    public void helpModal(JFrame frame){
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
        muhrez.setForeground(Color.BLUE);
        JLabel drHAL = new JLabel("Under Supervision of Dr.Hadi Aliakbarian");
        JPanel parsa = new JPanel();
        JPanel drHA = new JPanel();
        JButton parsaB = new JButton();
        JButton drHAB = new JButton();
        parsa.setMaximumSize(new Dimension((int)parsaB.getPreferredSize().getWidth()+56
                ,(int)parsaB.getPreferredSize().getHeight()));
        parsa.add(parsaB);
        drHA.add(drHAL);drHA.add(drHAB);
        parsaB.setText("<HTML><p1 color=\"#8B008B\"><U>Parsa Samadnejad</U></p1>"
                + "</HTML>");
        parsaB.setHorizontalAlignment(SwingConstants.LEFT);
        parsaB.setBorderPainted(false);
        parsaB.setOpaque(false);
        parsaB.setBackground(Color.WHITE);
        parsaB.setToolTipText(github.toString());
        parsaB.addActionListener(new OpenUrlAction1());
        drHAB.setText("<HTML><p1 color=\"#808080\"><U>WebSite</U></p1>"
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

    public void saveModal(JFrame frame){
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG Images", "jpg");
        fileChooser.setFileFilter(filter);
        if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            File file = new File(fileChooser.getSelectedFile()+".jpg");

            BufferedImage image = new BufferedImage(graph.getWidth(), graph.getHeight(), BufferedImage.TYPE_INT_BGR);
            Graphics2D graphic2D = image.createGraphics();
            graph.draw(graphic2D);
            try {
                ImageIO.write(image,"jpg",file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void open(URI uri) {
        if (Desktop.isDesktopSupported()) {
            try {
                Desktop.getDesktop().browse(uri);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else;

    }
}