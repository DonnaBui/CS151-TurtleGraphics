package turtleGraphics;

import mvc.*;

import java.awt.*;
import javax.swing.*;

public class TurtleFactory implements AppFactory {
    View currentView;

    public Model makeModel() {
        return new Turtle();
    }

    public View makeView(Model m) {
        this.currentView = new TurtleView((Turtle) m);
        return currentView;
    }

    public String[] getEditCommands() {
        return new String[] {"North", "East", "South", "West", "Clear", "Pen", "Color", "Export", "Thickness"};
    }

    public Command makeEditCommand(Model model, String type, Object source) {
        Turtle turtle = (Turtle) model;
        return switch (type) {
            case "North" -> new MoveCommand(turtle, Heading.NORTH);
            case "South" -> new MoveCommand(turtle, Heading.SOUTH);
            case "East"  -> new MoveCommand(turtle, Heading.EAST);
            case "West"  -> new MoveCommand(turtle, Heading.WEST);
            case "Clear" -> new ClearCommand(turtle);
            case "Pen"   -> new TogglePenCommand(turtle);
            case "Color" -> new SetColorCommand(turtle);
            case "Export" -> new ExportImageCommand(turtle, currentView);
            case "Thickness" -> new SetThicknessCommand(turtle);
            default -> null;
        };
    }

    public String getTitle() {
        return "Turtle Graphics";
    }

    public String[] getHelp() {
        return new String[] {
            "North/South/East/West: Move the turtle in that direction for X steps.",
            "Clear: Clear the canvas.",
            "Pen: Toggle pen up/down.",
            "Color: Change the pen color.",
            "Export: Export the drawing to a PNG image.",
            "Thickness: Change the thickness of the pen's strokes."
        };
    }

    public String about() {
        return "Turtle Graphics - CS151 SP25 Donna Bui";
    }


    class MoveCommand extends Command {
        private Heading heading;
    
        public MoveCommand(Model model, Heading heading) {
            super(model);
            this.heading = heading;
        }
    
        public void execute() {
            try {
                int steps = Integer.parseInt(Utilities.ask("Enter number of steps:"));
                ((Turtle) model).move(heading, steps);
            } catch (Exception e) {
                Utilities.error(e);
            }
        }
    }

    class ClearCommand extends Command {
        public ClearCommand(Model model) {
            super(model);
        }
    
        public void execute() {
            ((Turtle) model).clear();
        }
    }

    class TogglePenCommand extends Command {
        public TogglePenCommand(Model model) {
            super(model);
        }
    
        public void execute() {
            Turtle t = (Turtle) model;
            t.setPen(!t.isToggled());
        }
    }

    class SetColorCommand extends Command {
        public SetColorCommand(Model model) {
            super(model);
        }
    
        public void execute() {
            Turtle t = (Turtle) model;
            Color newColor = JColorChooser.showDialog(null, "Pick a color", t.getColor());
            if (newColor != null) t.setColor(newColor);
        }
    }

    class SetThicknessCommand extends Command {
    
        public SetThicknessCommand(Model model) {
            super(model);
        }
    
        public void execute() {
            try {
                int thickness = Integer.parseInt(Utilities.ask("Enter pen thickness in pixels:"));
                ((Turtle) model).setThickness(thickness);
            } catch (Exception e) {
                Utilities.error(e);
            }
        }
    }

} 