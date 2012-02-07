package controller.events;

import controller.Node;

/**
 * This class represents a dependency graph event when a node is added
 * @author Saba Alimadadi
 */
public class AddNodeEvent extends DepGraphEvent {
    /** The node added to the graph */
    private Node node;
    private static final int id = 1; // todo ooooooooooooo ?????????????
    private static final String command = "AddNodeEvent";

    /**
     * Constructor
     * @param source The dependency graph
     * @param n New node
     */
    public AddNodeEvent(Object source, Node n) {
        super(source, id, command);
        this.node = n;
    }

    /**
     * Returns the node that was added to the graph and caused the event
     * @return The added node
     */
    public Node getNode() {
        return node;
    }
}
