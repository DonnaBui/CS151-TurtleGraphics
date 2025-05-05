package turtleGraphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import mvc.*;

public class TurtlePanel extends AppPanel {

    public TurtlePanel(AppFactory factory) {
        super(factory);
        controlPanel.setLayout(new BorderLayout());
        controlPanel.setBackground(Color.cyan);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(4, 2, 10, 10));
        buttons.setOpaque(false);

        String[] commands = factory.getEditCommands();
        for (String cmd : commands) {
            JButton button = new JButton(cmd);
            button.setPreferredSize(new Dimension(100, 40));
            buttons.add(button);
            button.addActionListener(this);
        }

        controlPanel.add(buttons, BorderLayout.CENTER);

        this.setLayout((new GridLayout(1, 2)));
        this.add(controlPanel);
        this.add(view);
    }

    public static void main(String[] args) {
        AppFactory factory = new TurtleFactory();
        AppPanel panel = new TurtlePanel(factory);
        panel.display();
    }
} 
