package turtleGraphics;

import java.io.Serializable;
import java.util.*;
import java.awt.*;
import mvc.*;

public class Turtle extends Model implements Serializable {
    public static final int WORLD_SIZE = 250;
    private ArrayList<Point> path;

    public Turtle() {
        path = new ArrayList<>();
        path.add(new Point(WORLD_SIZE / 2, WORLD_SIZE / 2, Color.BLACK, true, 6));
    }

    public Point getLocation() { // MoveCommand class handles this error in TurtleFactory
        if (path.isEmpty()) throw new IllegalStateException("Error: No existing path");
        return path.get(path.size() - 1);
    }

    public void move(Heading heading, int steps) throws Exception {
        Point current = getLocation();
        int x = current.getX();
        int y = current.getY();

        switch (heading) {
            case WEST -> x = Math.max(0, x - steps);
            case EAST -> x = Math.min(WORLD_SIZE, x + steps);
            case SOUTH -> y = Math.min(WORLD_SIZE, y + steps);
            case NORTH -> y = Math.max(0, y - steps);
            default -> throw new Exception("Invalid heading");
        }

        path.add(new Point(x, y, current.getColor(), current.isToggled(), current.getThickness()));
        changed();
    }

    public void clear() {
        Point current = getLocation();
        path.clear();
        path.add(new Point(current.getX(), current.getY(), current.getColor(), current.isToggled(), current.getThickness()));
        changed();
    }

    public void setPen(boolean status) {
        Point current = getLocation();
        current.setPen(status);
        changed();
    }

    public boolean isToggled() {
        return getLocation().isToggled();
    }

    public void setColor(Color c) {
        Point current = getLocation();
        current.setColor(c);
        changed();
    }

    public Color getColor() {
        return getLocation().getColor();
    }

    public void setThickness(int thickness) {
        Point current = getLocation();
        current.setThickness(thickness);
        changed();
    }

    public int getThickness() {
        return getLocation().getThickness();
    }

    public Iterator<Point> iterator() {
        return path.iterator();
    }
}
