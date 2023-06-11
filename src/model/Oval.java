package model;

/**
 * The type Oval.
 */
public class Oval extends AbstractShape {
    private double centerX, centerY, xRadius, yRadius;
    private double ORed, OGreen, OBlue;

    /**
     * Instantiates a new Oval.
     *
     * @param name    the name
     * @param x       the x
     * @param xRadius the x radius
     * @param y       the y
     * @param yRadius the y radius
     * @param ORed    the o red
     * @param OGreen  the o green
     * @param OBlue   the o blue
     */
    public Oval(String name, double x, double xRadius, double y, double yRadius,
                double ORed, double OGreen, double OBlue) {
        super(name, x, y, xRadius, yRadius, ORed, OGreen, OBlue);
    }

    /**
     * Sets x radius.
     *
     * @param xRadius the x radius
     */
    public void setXRadius(double xRadius) {
        if (xRadius <= 0) {
            throw new IllegalArgumentException("Invalid radius");
        }
        this.xRadius = xRadius;
    }

    /**
     * Sets y radius.
     *
     * @param yRadius the y radius
     */
    public void setYRadius(double yRadius) {
        if (yRadius <= 0) {
            throw new IllegalArgumentException("Invalid radius");
        }
        this.yRadius = yRadius;
    }

    /**
     * Gets x radius.
     *
     * @return the x radius
     */
    public double getXRadius() {
        return xRadius;
    }

    /**
     * Gets y radius.
     *
     * @return the y radius
     */
    public double getYRadius() {
        return yRadius;
    }

    /**
     * Copy shape.
     *
     * @return the shape
     */
    @Override
    public IShape copy() {
        IShape oval = new Oval(getName(), getPositionX(), getPositionY(), getSizeX(), getSizeY(),
                getColorRed(),
                getColorGreen(), getColorBlue());
        return oval;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Name: " + getName() + "\n" + "Type: Oval\nCenter: (" + getPositionX() + ","
                + getPositionY() + "), X radius: "
                + getSizeX() + ", Y radius: " + getSizeY()
                + ", Color: (" + getColorRed() + "," + getColorGreen() + "," + getColorBlue() + ")\n";
    }
}