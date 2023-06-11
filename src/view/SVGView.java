package view;

import model.IAlbumModel;
import model.IShape;
import model.Snapshot;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * web view.
 */
public class SVGView implements IView {
    private IAlbumModel model;
    private StringBuilder SB;
    private final String nameOfOutputfile;
    private File outputFile;
    private final int widthofWindow;
    private final int heightofWindow;

    public SVGView(String nameOfOutputfile, int maxX, int maxY) {
        this.nameOfOutputfile = nameOfOutputfile;
        this.widthofWindow = maxX;
        this.heightofWindow = maxY;
    }

    /**
     * upload snapshots.
     */
    public void snapshotFunction(Snapshot snapshot) {
        SB.append("<div>\n");
        String snapshotDescription = "<h4>Description:" + snapshot.getDescription() + "</h4>\n";
        String snapshotID = "<h2>Snapshot ID: " + snapshot.getID() + "</h2>\n";
        String snapshotTimeticket = "<h4>Timestamp: " + snapshot.getTimeTicket() + "</h4>\n";
        String svgwindow = "<svg width=" + this.widthofWindow + " height=" + this.heightofWindow
                + ">\n";
        SB.append(snapshotID);
        SB.append(snapshotTimeticket);
        SB.append(snapshotDescription);
        SB.append(svgwindow);

        List<IShape> currentShapes = snapshot.getCurrentAlbumShapes().values().stream().collect
                (Collectors.toUnmodifiableList());

        // shapes
        for (IShape shape : currentShapes) {
            if (shape.getClass().equals(model.Rectangle.class)) {
                String rectangleSetUp = "<rect id=" + shape.getName()
                        + " x=" + shape.getPositionX()
                        + " y=" + shape.getPositionY()
                        + " width=" + shape.getSizeX()
                        + " height=" + shape.getSizeY()
                        + " fill=rgb(" + shape.getColorRed()
                        + "," + shape.getColorGreen()
                        + "," + shape.getColorBlue() + ")>"
                        + "</rect>\n";
                SB.append(rectangleSetUp);
            }
            
            if (shape.getClass().equals(model.Oval.class)) {
                String ovalSetUp = "<ellipse id=" + shape.getName()
                        + " cx=" + shape.getPositionX()
                        + " cy=" + shape.getPositionY()
                        + " rx=" + shape.getSizeX()
                        + " ry=" + shape.getSizeY()
                        + " fill=rgb(" + shape.getColorRed()
                        + "," + shape.getColorGreen()
                        + "," + shape.getColorBlue() + ")>"
                        + "</ellipse>\n";
                SB.append(ovalSetUp);
            }
        }
        SB.append("</svg>\n");
        SB.append("</div>\n");
        SB.append("<br>\n\n");
        setCurrentSnapshot(snapshot);
    }

    @Override
    public void setCurrentSnapshot(Snapshot currentSnapshot) {
        int currentSnapshotNumber = this.model.getSnapshotsList().indexOf(currentSnapshot);
        if (0 == currentSnapshotNumber) {
            createFile();
        } else snapshotFunction(this.model.getSnapshotsList().get(currentSnapshotNumber - 1));
    }

    /**
     * load modle to this view.
     */
    public void render(IAlbumModel model) {
        this.model = model;
        Snapshot currentSnapshot = this.model.getSnapshotsList().get
                (this.model.getSnapshotsList().size() - 1);
        outputFile = new File(this.nameOfOutputfile);
        SB = new StringBuilder();
        SB.append("""
            <!DOCTYPE html>
            <html>
            <head>
                <style>
                    h1 {
                        border-style: solid;
                        border-width: 8px;
                        border-color: red;
                        background: yellow;
                    }
                        
                    div {
                        border-style: solid;
                        border-width: 8px;
                        border-color: blue;
                        background: pink;
                    }
                </style>
            </head>
            <body>
            <h1> Welcome to Shapes Photo Album -- SVG!!! </h1>
            """);

        snapshotFunction(currentSnapshot);
    }

    /**
     * create output file.
     */
    public void createFile(){
        // generates output file
        SB.append("""
            \n</body>
            \n</html>""");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.outputFile))) {
            bufferedWriter.write(SB.toString());

        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
