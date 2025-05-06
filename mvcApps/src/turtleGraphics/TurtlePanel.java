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
            JPanel subPanel = new JPanel();
            subPanel.setOpaque(false);
            JButton button = new JButton(cmd);
            subPanel.add(button, BorderLayout.CENTER);
            buttons.add(subPanel);
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
