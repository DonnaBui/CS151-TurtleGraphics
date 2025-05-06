package turtleGraphics;

import java.awt.Color;

public class Point {
    private int x, y, thickness; 
    private Color color; 
    private boolean penDown;
    
    public Point(int x, int y, Color color, boolean penDown, int thickness) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.penDown = penDown;
        this.thickness = thickness;
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

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }
}

