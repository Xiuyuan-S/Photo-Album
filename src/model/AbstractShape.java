package model;
import java.util.Objects;

/**
 * The type Abstract shape.
 */
public abstract class AbstractShape implements IShape {
    private double positionX, positionY;
    private double sizeX, sizeY;
    private double ORed, OGreen, OBlue;
    private final String name;

    /**
     * Instantiates a new Abstract shape.
     *
     * @param name      the name
     * @param positionX the position x
     * @param positionY the position y
     * @param sizeX     the size x
     * @param sizeY     the size y
     * @param ORed      the o red
     * @param OGreen    the o green
     * @param OBlue     the o blue
     */
    public AbstractShape(String name, double positionX, double positionY, double sizeX, double sizeY,
                         double ORed, double OGreen, double OBlue) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("You need to enter a valid name");
        }
        if (ORed < 0 || ORed > 255 || OGreen < 0 || OGreen > 255 || OBlue < 0 || OBlue > 255) {
            throw new IllegalArgumentException("Invalid color");
        }
        this.name = name;
        this.positionX = positionX;
        this.positionY = positionY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.ORed = ORed;
        this.OGreen = OGreen;
        this.OBlue = OBlue;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    @Override
    public String getName() {
        return name;
    }

    /*@Override
    public void move(double x, double y) {
        positionX = x;
        positionY = y;
    }

     */

    /**
     * Sets color.
     *
     * @param red   the red
     * @param green the green
     * @param blue  the blue
     */
    @Override
    public void setColor(double red, double green, double blue) {
        this.ORed = red;
        this.OGreen = green;
        this.OBlue = blue;
    }

    /**
     * Gets color red.
     *
     * @return the color red
     */
    @Override
    public double getColorRed() {
        return ORed;
    }

    /**
     * Gets color green.
     *
     * @return the color green
     */
    @Override
    public double getColorGreen() {
        return OGreen;
    }

    /**
     * Gets color blue.
     *
     * @return the color blue
     */
    @Override
    public double getColorBlue() {
        return OBlue;
    }

    /**
     * Sets position x.
     *
     * @param newPositionX the new position x
     */
    @Override
    public void setPositionX(double newPositionX) {
        this.positionX = newPositionX;
    }

    /**
     * Sets position y.
     *
     * @param newPositionY the new position y
     */
    @Override
    public void setPositionY(double newPositionY) {
        this.positionY = newPositionY;
    }

    /**
     * Gets position x.
     *
     * @return the position x
     */
    @Override
    public double getPositionX() {
        return this.positionX;
    }

    /**
     * Gets position y.
     *
     * @return the position y
     */
    @Override
    public double getPositionY() {
        return this.positionY;
    }

    /**
     * Sets size x.
     *
     * @param newSizeX the new size x
     */
    @Override
    public void setSizeX(double newSizeX) {
        if (sizeX > 0) {
            this.sizeX = newSizeX;
        } else {
            throw new IllegalArgumentException("invalid size");
        }
    }

    /**
     * Sets size y.
     *
     * @param newSizeY the new size y
     */
    @Override
    public void setSizeY(double newSizeY) {
        if (sizeY > 0) {
            this.sizeY = newSizeY;
        } else {
            throw new IllegalArgumentException("invalid size");
        }
    }

    /**
     * Gets size x.
     *
     * @return the size x
     */
    @Override
    public double getSizeX() {
        return sizeX;
    }

    /**
     * Gets size y.
     *
     * @return the size y
     */
    @Override
    public double getSizeY() {
        return sizeY;
    }
    /*@Override
    public void changePos(double x, double y) {
        move(x, y);
    }

     */

    /**
     * Change color.
     *
     * @param r the r
     * @param g the g
     * @param b the b
     */
    @Override
    public void changeColor(double r, double g, double b) {
        if (r > 0 || r < 255 || g > 0 || g < 255 || b > 0 || b < 255) {
            ORed = r;
            OGreen = g;
            OBlue = b;
        }
    }

    /**
     * Hash code int.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, positionX, positionY, sizeX, sizeY, ORed, OGreen, OBlue);
    }

    /**
     * Equals boolean.
     *
     * @param o the o
     * @return the boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractShape that = (AbstractShape) o;
        return Double.compare(that.positionX, positionX) == 0 && Double.compare(that.positionY, positionY) == 0
                && Double.compare(that.sizeX, sizeX) == 0 && Double.compare(that.sizeY, sizeY) == 0
                && name.equals(that.name) && Double.compare(that.ORed, ORed) == 0
                && Double.compare(that.OGreen, OGreen) == 0 && Double.compare(that.OBlue, OBlue) == 0;
    }

}