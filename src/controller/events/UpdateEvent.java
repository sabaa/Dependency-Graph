package controller.events;

import controller.Node;

/**
 * * This class represents a dependency graph event when a node is updated
 * @author Saba Alimadadi
 */
public class UpdateEvent extends DepGraphEvent {
    /** The node added to the graph */
    private Node node;
    private static final int id = 3;
    private static final String command = "UpdateEvent";
    /**
     * @param source  The object on which the Event initially occurred.
     */
    public UpdateEvent(Object source, Node n) {
        super(source, id, command);
        this.node = n;
    }
}
