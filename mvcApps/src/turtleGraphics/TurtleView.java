package turtleGraphics;

import mvc.*;
import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

public class TurtleView extends View {

    public TurtleView(Turtle turtle) {
        super(turtle);
        setPreferredSize(new Dimension(Turtle.WORLD_SIZE, Turtle.WORLD_SIZE));
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    @Override
    public void paintComponent(Graphics gc) {
        super.paintComponent(gc);
        Color oldColor = gc.getColor();
        Turtle turtle = (Turtle) model;
        Iterator<Point> it = turtle.iterator();

        if (it.hasNext()) {
            Point p1 = it.next();
            while (it.hasNext()) {
                Point p2 = it.next();
                if (!p1.isToggled()) {
                    gc.setColor(p1.getColor());
                    Graphics2D g2 = (Graphics2D) gc; // Set the thickness of the line
                    g2.setStroke(new BasicStroke(p1.getThickness()));
                    g2.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
                }
                p1 = p2;
            }
        }

        // draw turtle
        Point curr = turtle.getLocation();
        int size = turtle.getThickness();
        gc.setColor(Color.GREEN);
        if (curr.isToggled()) {
            gc.drawOval(curr.getX() - size/2, curr.getY() - size/2, size, size);
        } else {
            gc.fillOval(curr.getX() - size/2, curr.getY() - size/2, size, size);
        }

        gc.setColor(oldColor);
    }
} 