package m_mehdi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class CalculatorGui implements ActionListener , KeyListener {
    JFrame calcFrame;
    String copied = "";
    double result = 0;
    double num = 0;
    double min = 0;
    double div = 0;
    double multi = 0;
    double sinValue= 0;
    double c = 0;
    public CalculatorGui() {
        Frame();

    }
    public void Frame() {
        calcFrame = new JFrame();
        calcFrame.setTitle("AUT Calculator");
        calcFrame.setSize(240, 400);
        calcFrame.setLocation(100, 200);
        calcFrame.addKeyListener(this);
        calcFrame.setFocusable(true);
        calcFrame.setLayout(null);
        calcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textArea();
        textField();
        keyboardPanel();
        Menu();
        calcFrame.setVisible(true);
    }
    JPanel keyboardPanel = new JPanel();
    public void keyboardPanel() {
        keyboardPanel.setSize(200,200);
        keyboardPanel.setLocation(10, 120);
        keyboardPanel.setLayout(new GridLayout(6,3));
        for (int i = 9; i > 0; i--) {
            JButton btn = new JButton();
            btn.setText("" + i);
            btn.addActionListener(this);
            btn.setToolTipText("Number "+i);
            keyboardPanel.add(btn);
        }
        JButton sumBtn = new JButton();
        sumBtn.setText("+");
        sumBtn.setToolTipText("Addition");
        keyboardPanel.add(sumBtn);
        sumBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b = text.getText();
                num = Double.parseDouble(b);
                text.setText("");

            }
        });
        JButton zeroBtn = new JButton();
        zeroBtn.setText("0");
        zeroBtn.setToolTipText("Zero");
        zeroBtn.addActionListener(this);
        keyboardPanel.add(zeroBtn);
        JButton minBtn = new JButton();
        minBtn.setText("-");
        minBtn.setToolTipText("Submission");
        keyboardPanel.add(minBtn);
        minBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b = text.getText();
                min = Double.parseDouble(b);
                text.setText("");
            }
        });
        JButton multiBtn = new JButton();
        multiBtn.setText("*");
        multiBtn.setToolTipText("Multiplication");
        keyboardPanel.add(multiBtn);
        multiBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b = text.getText();
                multi = Double.parseDouble(b);
                text.setText("");
            }

        });

        JButton doBtn = new JButton();
        doBtn.setText("=");
        doBtn.setToolTipText("Result");
        keyboardPanel.add(doBtn);
        doBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n = text.getText();
                double x = Double.parseDouble(n);
                if (num > 0) {
                    result = x + num;
                } else if (min > 0) {
                    result = min - x;
                } else if (div > 0) {
                    result = div / x;
                } else if (multi > 0) {
                    result = multi * x;
                }
                text.setText("" + result);
            }
        });
        JButton divBtn = new JButton();
        divBtn.setText("/");
        divBtn.setToolTipText("Division");
        keyboardPanel.add(divBtn);
        divBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b = text.getText();
                div = Double.parseDouble(b);
                text.setText("");
            }
        });
        JButton erase = new JButton();
        erase.setText("C");
        erase.setToolTipText("Erase All");
        keyboardPanel.add(erase);
        erase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText("");
            }
        });
        JButton sin = new JButton();
        sin.setText("Sin");
        sin.setToolTipText("Sinus value");
        keyboardPanel.add(sin);
        sin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b = text.getText();
                sinValue = Double.parseDouble(b);
                c = Math.toRadians(sinValue);
                c = Math.sin(c);
                text.setText(""+c);

            }
        });
        JButton cos = new JButton();
        cos.setText("Cos");
        cos.setToolTipText("Cosine value");
        keyboardPanel.add(cos);
        cos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b = text.getText();
                sinValue = Double.parseDouble(b);
                c = Math.toRadians(sinValue);
                c = Math.cos(c);
                text.setText(""+c);

            }
        });


        calcFrame.add(keyboardPanel);


    }

    JTextArea display = new JTextArea(3,10);
    public void textArea() {
        display.setEditable(false);
        display.setFont(new Font("Arial", 14,14));
        calcFrame.add(display);
    }
    JScrollPane scrollPane = new JScrollPane(display);
    public void scrollPane() {
        scrollPane.setPreferredSize(new Dimension(200, 100));
        scrollPane.setLocation(50,20);
        calcFrame.add(scrollPane);
        calcFrame.getContentPane().add(scrollPane);

    }
    JTextField text = new JTextField("");
    public void textField() {
        text.setSize(190,40);
        text.setLocation(15,30);
        text.setEditable(false);
        text.setToolTipText("Screen to show the input and result");
        calcFrame.add(text);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        for (int i = 9; i > 0; i--) {
            if (b.getText().contains(""+i)) {
                String temp = text.getText();
                temp += (i);
                text.setText(temp);
            }
        }
        if (b.getText().contains(""+0)) {
            String zero = text.getText();
            zero += 0;
            text.setText(zero);
        }


    }
    public void Menu() {
        JMenuBar bar = new JMenuBar();
        calcFrame.setJMenuBar(bar);
        JMenu menu = new JMenu("Menu");
        menu.setMnemonic('M');
        bar.add(menu);
        JMenuItem exit = new JMenuItem("EXIT");
        exit.setToolTipText("Exit The Program");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        menu.add(exit);
        JMenuItem copy = new JMenuItem("COPY");
        copy.setToolTipText("Copy The Text");
        copy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                copied = text.getText();
            }
        });
        menu.add(copy);
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
    }





    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
            System.exit(00);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

