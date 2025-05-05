package turtleGraphics;

import java.awt.Color;

public class Point {
    private int x, y; 
    private Color color; 
    private boolean penDown;

    public Point(int x, int y, Color color, boolean penDown) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.penDown = penDown;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }

    public boolean isToggled() {
        return penDown;
    }

    public void setPen(boolean status) {
        this.penDown = status;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}

