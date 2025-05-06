package turtleGraphics;

import mvc.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class ExportImageCommand extends Command {
    private TurtleView view;

    public ExportImageCommand(Turtle model, View view) {
        super(model);
        this.view = (TurtleView) view;
    }

    @Override
    public void execute() {
        try {
            String filename = Utilities.ask("Enter a name for the file to be exported");

            BufferedImage image = new BufferedImage(view.getWidth(), view.getHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2 = image.createGraphics();
            view.paint(g2);
            g2.dispose();

            File outputFile = new File(filename + ".png");
            ImageIO.write(image, "png", outputFile);
            
            Utilities.inform("Image successfully saved at " + outputFile.getAbsolutePath());
        } catch (Exception e) {
            Utilities.error("Export failed: " + e.getMessage());
        }
    }
}
