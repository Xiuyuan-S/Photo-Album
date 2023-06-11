package model;
import java.util.List;

/**
 * The interface Snapshot.
 */
public interface ISnapshot {
    /**
     * Gets id.
     *
     * @return the id
     */
//public void takeSnapshot();
    public long getID();

    /**
     * Gets time ticket.
     *
     * @return the time ticket
     */
    public String getTimeTicket();

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription();

    /**
     * To string string.
     *
     * @return the string
     */
    public String toString();

}
