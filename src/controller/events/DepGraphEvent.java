package controller.events;

import java.awt.event.ActionEvent;
import java.util.EventObject;

/**
 * This class represents the events related to the dependency graph
 * @author Saba Alimadadi
 */
public class DepGraphEvent extends /*ActionEvent*/ EventObject {
    // todo
    /** The id associated with each type of events */
    private int id;
    /** Command of each type of events */
    private String command;

    /**
     *
     * @param source The object on which the Event initially occurred.
     * @param id ID of the type of event
     * @param command String command representing the event
     */
    public DepGraphEvent(Object source, int id, String command) {
        super(source);
        this.id = id;
        this.command = command;
    }

    /**
     * Returns the id related with each type of events
     * @return ID
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the command of each type of events
     * @return String command
     */
    public String getCommand() {
        return command;
    }
}
