package model;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * The type Snapshot.
 */
public class Snapshot implements ISnapshot {
    private final LinkedHashMap<String, IShape> shapes;
    //private final List<String> snapshots;
    private final String shotTime, description;
    private final long ID;


    /**
     * Instantiates a new Snapshot.
     *
     * @param ID          the id
     * @param shotTime    the shot time
     * @param description the description
     * @param shapes       the shape
     */
    public Snapshot(long ID, String shotTime, String description, LinkedHashMap<String, IShape> shapes) {
        this.ID = ID;
        this.shotTime = shotTime;
        this.description = description;
        this.shapes = shapes;

    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getID() {
        return this.ID;
    }

    /**
     * Gets time ticket.
     *
     * @return the time ticket
     */
    public String getTimeTicket() {
        return this.shotTime;
    }


    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * To string string.
     *
     * @return the string
     */

    public LinkedHashMap<String, IShape> getCurrentAlbumShapes() {
        return shapes;
    }
    public String toString() {
        String shapeInfo = "";
        for (IShape shape : this.shapes.values()) { // iterate shape in shapes
            shapeInfo += shape.toString();
        }
        return "Snapshot ID: " + this.getID() + "\n" + "Timestamp: " + this.getTimeTicket() + "\n" + "Description: "
                + this.getDescription() + "\n" + "Shape Information: \n" + shapeInfo + "";
    }
}