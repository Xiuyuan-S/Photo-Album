package model;

/**
 * The type Rectangle.
 */
public class Rectangle extends AbstractShape {
    private double width, height;

    /**
     * Instantiates a new Rectangle.
     *
     * @param name   the name
     * @param x      the x
     * @param y      the y
     * @param width  the width
     * @param height the height
     * @param ORed   the o red
     * @param OGreen the o green
     * @param OBlue  the o blue
     */
    public Rectangle(String name, double x, double y, double width, double height,
                     double ORed, double OGreen, double OBlue) {
        super(name, x, y, width, height, ORed, OGreen, OBlue);
        //this.width = width;
        //this.height = height;
    }

    /**
     * Sets width.
     *
     * @param width the width
     */
    public void setWidth(double width) {
        if (width < 0) {
            throw new IllegalArgumentException("Please enter a valid width");
        }
        this.width = width;
    }

    /**
     * Sets height.
     *
     * @param height the height
     */
    public void setHeight(double height) {
        if (height < 0) {
            throw new IllegalArgumentException("Please enter a valid Height");
        }
        this.height = height;
    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Copy shape.
     *
     * @return the shape
     */
    @Override
    public IShape copy() {
        IShape rectangle = new Rectangle(getName(), getPositionX(), getPositionY(), getSizeX(),
                getSizeY(), getColorRed(),
                getColorGreen(), getColorBlue());
        return rectangle;
    }

    /**
     * To string string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Name: " + getName() + "\n" + "Type: Rectangle\nMin corner: (" + getPositionX() + ","
                + getPositionY() + "), Width: "
                + getSizeX() + ", Height: " + getSizeY() + ", Color: (" + getColorRed() + ","
                + getColorGreen()
                + "," + getColorGreen() + ")\n";
    }
}