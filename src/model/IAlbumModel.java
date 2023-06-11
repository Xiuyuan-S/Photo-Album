package model;
import java.util.List;

/**
 * The interface Album model.
 */
public interface IAlbumModel {
    /**
     * Create shape.
     *
     * @param name    the name
     * @param type    the type
     * @param centerX the center x
     * @param centerY the center y
     * @param sizeX   the size x
     * @param sizeY   the size y
     * @param Ored    the ored
     * @param OGreen  the o green
     * @param OBlue   the o blue
     */
    void createShape(String name, String type, double centerX, double centerY,
                     double sizeX, double sizeY, double Ored, double OGreen, double OBlue);

    /**
     * Add shape.
     *
     * @param shape the shape
     */
    void addShape(IShape shape);

    /**
     * Gets shape.
     *
     * @param name the name
     * @return the shape
     */
    IShape getShape(String name);

    /**
     * Remove.
     *
     * @param name the name
     */
    void remove(String name);

    Snapshot getSnapshot(String snapshotID);

    /**
     * Take snapshot.
     *
     * @param description the description
     */
    void takeSnapshot(String description);

    /**
     * Move.
     *
     * @param name         the name
     * @param newPositionX the new position x
     * @param newPositionY the new position y
     */
    void move(String name, double newPositionX, double newPositionY);

    /**
     * Change color.
     *
     * @param name     the name
     * @param newred   the newred
     * @param newgreen the newgreen
     * @param newblue  the newblue
     */
    void changeColor(String name, double newred, double newgreen, double newblue);

    /**
     * Resize.
     *
     * @param name     the name
     * @param newSizeX the new size x
     * @param newSizeY the new size y
     * @throws IllegalArgumentException the illegal argument exception
     */
    void resize(String name, double newSizeX, double newSizeY)
            throws IllegalArgumentException;

    /**
     * Gets list of all shape.
     *
     * @return the all snapshot i ds
     */
    List<IShape> getAllShape();

    /**
     * Gets list of all id.
     *
     * @return the all snapshot i ds
     */
    List<String> getSnapshotIDList();

    /**
     * Gets list of all snapshots.
     *
     * @return the all snapshots
     */
    List<Snapshot> getSnapshotsList();

    /**
     * Reboot.
     */
    void reboot();
}
