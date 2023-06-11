package model;


public interface IShape {
    /**
     * Gets name.
     *
     * @return the name
     */
    String getName();

    /**
     * Sets color.
     *
     * @param red   the red
     * @param green the green
     * @param blue  the blue
     */
    void setColor(double red, double green, double blue);

    double getColorRed();

    /**
     * Gets color green.
     *
     * @return the color green
     */
    double getColorGreen();

    /**
     * Gets color blue.
     *
     * @return the color blue
     */
    double getColorBlue();

    /**
     * Sets position x.
     *
     * @param newPositionX the new position x
     */
    void setPositionX(double newPositionX);

    /**
     * Sets size x.
     *
     * @param newSizeX the new size x
     */
    void setSizeX(double newSizeX);

    /**
     * Sets position y.
     *
     * @param newPositionY the new position y
     */
    void setPositionY(double newPositionY);

    /**
     * Gets position x.
     *
     * @return the position x
     */
    double getPositionX();

    /**
     * Gets position y.
     *
     * @return the position y
     */
    double getPositionY();

    /**
     * Sets size y.
     *
     * @param newSizeY the new size y
     */
    void setSizeY(double newSizeY);

    /**
     * Gets size x.
     *
     * @return the size x
     */
    double getSizeX();

    /**
     * Gets size y.
     *
     * @return the size y
     */
    double getSizeY();

    //void changePos(double x, double y);

    /**
     * Change color.
     *
     * @param r the r
     * @param g the g
     * @param b the b
     */
    void changeColor(double r, double g, double b);

    /**
     * To string string.
     *
     * @return the string
     */
    String toString();

    /**
     * Copy shape.
     *
     * @return the shape
     */
    IShape copy();
}