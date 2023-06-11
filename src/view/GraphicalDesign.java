package view;

import model.IShape;
import model.Snapshot;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * design canvas of graphical view.
 */
public class GraphicalDesign extends JPanel {
    private Snapshot currentSnapshot;

    public GraphicalDesign(Snapshot currentSnapshot) {
        this.currentSnapshot = currentSnapshot;
        setBackground(Color.WHITE);
    }
    /**
     * design canvas of graphical view using shapes.
     */
    public void paintComponent(Graphics graphic) {
        // design by shape
        super.paintComponent(graphic);
        List<IShape> currentShapes = currentSnapshot.getCurrentAlbumShapes().values().stream().collect
                (Collectors.toUnmodifiableList());
        for (IShape shape : currentShapes) {
            if (shape.getClass().equals(model.Rectangle.class)) {
                graphic.setColor(new Color((int) shape.getColorRed(),
                        (int) shape.getColorGreen(),
                        (int) shape.getColorBlue()));
                graphic.fillRect((int) shape.getPositionX(), (int) shape.getPositionY(),
                        (int) shape.getSizeX(), (int) shape.getSizeY());
            }
            if (shape.getClass().equals(model.Oval.class)) {
                graphic.setColor(new Color((int) shape.getColorRed(),
                        (int) shape.getColorGreen(),
                        (int) shape.getColorBlue()));
                graphic.fillOval((int) shape.getPositionX(), (int) shape.getPositionY(),
                        (int) shape.getSizeX(), (int) shape.getSizeY());
            }
        }

    }
}
