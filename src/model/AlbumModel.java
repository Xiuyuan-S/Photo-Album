package model;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * The type Album model.
 */
public class AlbumModel implements IAlbumModel {
    private final LinkedHashMap<String, Snapshot> snapshotMap;
    private final LinkedHashMap<String, IShape> shapeMap;
    private final Random ids = new Random();

    /**
     * Instantiates a new Album model.
     */
    public AlbumModel() {
        snapshotMap = new LinkedHashMap<>();
        shapeMap = new LinkedHashMap<>();
    }

    /**
     * Add shape.
     *
     * @param shape the shape
     */
    @Override
    public void addShape(IShape shape) {
        if (shape == null || shape.getName().equals("")) {
            throw new IllegalArgumentException("Invalid input");
        } else {
            shapeMap.put(shape.getName(), shape);
        }
    }

    /**
     * Create shape.
     *
     * @param name      the name
     * @param type      the type
     * @param positionX the position x
     * @param positionY the position y
     * @param sizeX     the size x
     * @param sizeY     the size y
     * @param ORed      the o red
     * @param OGreen    the o green
     * @param OBlue     the o blue
     */
    @Override
    public void createShape(String name, String type, double positionX, double positionY, double sizeX, double sizeY,
                            double ORed, double OGreen, double OBlue) {
        if (type.equalsIgnoreCase("rectangle")) {
            addShape(new Rectangle(name, positionX, positionY, sizeX, sizeY, ORed, OGreen, OBlue));
        }
        if (type.equalsIgnoreCase("oval")) {
            addShape(new Oval(name, positionX, positionY, sizeX, sizeY, ORed, OGreen, OBlue));
        }
    }

    /**
     * Gets shape.
     *
     * @param name the name
     * @return the shape
     */
    @Override
    public IShape getShape(String name) {
        if (shapeMap.containsKey(name)) {
            return shapeMap.get(name);
        } else {
            throw new IllegalArgumentException("No such shape exists");
        }
    }

    @Override
    public Snapshot getSnapshot(String snapshotID) {
        if (snapshotMap.containsKey(snapshotID)) {
            return snapshotMap.get(snapshotID);
        } else {
            throw new IllegalArgumentException("No such snapshot exist");
        }
    }

    /**
     * Take snapshot.
     *
     * @param description the description
     */
    @Override
    public void takeSnapshot(String description) {
        long shotID = ids.nextLong(1, 999999999); // generates random id
        String shotTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss")
                .format(new Timestamp(System.currentTimeMillis())); // generates time stamp
        LinkedHashMap<String, IShape> newSnapMap = new LinkedHashMap<>(); //stores copied shapes
        for (Map.Entry<String, IShape> shape : shapeMap.entrySet()) {
            newSnapMap.put(shape.getKey(), shape.getValue().copy());
        }
        Snapshot snapshot = new Snapshot(shotID, shotTime, description, newSnapMap);
        snapshotMap.put(String.valueOf(shotID), snapshot);
    }

    /**
     * Move.
     *
     * @param name         the name
     * @param newPositionX the new position x
     * @param newPositionY the new position y
     */
    @Override
    public void move(String name, double newPositionX, double newPositionY) {
        if (shapeMap.containsKey(name)) {
            shapeMap.get(name).setPositionX(newPositionX);
            shapeMap.get(name).setPositionY(newPositionY);
        } else {
            throw new IllegalArgumentException("Invalid position");
        }
    }

    /**
     * Change color.
     *
     * @param name the name
     * @param r    the r
     * @param g    the g
     * @param b    the b
     */
    @Override
    public void changeColor(String name, double r, double g, double b) {
        if (shapeMap.containsKey(name)) {
            shapeMap.get(name).changeColor(r, g, b);
        } else {
            throw new IllegalArgumentException("Invalid color");
        }
    }

    /**
     * Resize.
     *
     * @param name     the name
     * @param newSizeX the new size x
     * @param newSizeY the new size y
     */
    @Override
    public void resize(String name, double newSizeX, double newSizeY) {
        if (shapeMap.containsKey(name)) {
            shapeMap.get(name).setSizeX(newSizeX);
            shapeMap.get(name).setSizeY(newSizeY);
        } else {
            throw new IllegalArgumentException("Invalid size");
        }
    }

    /**
     * Remove.
     *
     * @param name the name
     */
    @Override
    public void remove(String name) {
        if (shapeMap.containsKey(name)) {
            shapeMap.remove(name);
        } else {
            throw new IllegalArgumentException("no such shape exists");
        }
    }

    /**
     * Gets all shape.
     *
     * @return the all shape
     */
    @Override
    public List<IShape> getAllShape() { // save info as list
        return new ArrayList<>(shapeMap.values());
    }

    /**
     * Gets all snapshot i ds.
     *
     * @return the all snapshot i ds
     */
    @Override
    public List<String> getSnapshotIDList() {
        return new ArrayList<>(snapshotMap.keySet());
    }

    /**
     * Gets all snapshots.
     *
     * @return the all snapshots
     */
    @Override
    public List<Snapshot> getSnapshotsList() {
        return new ArrayList<>(snapshotMap.values());
    }

    /**
     * Reboot.
     */
    @Override
    public void reboot() {
        this.shapeMap.clear();
        this.snapshotMap.clear();
    }
}