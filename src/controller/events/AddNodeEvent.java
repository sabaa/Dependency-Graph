package controller.events;

/**
 * This class represents a dependency graph event when a node is added
 * @author Saba Alimadadi
 */
public class AddNodeEvent extends DepGraphEvent {
    private static final int id = 1; // todo ooooooooooooo ?????????????
    private static final String command = "AddNodeEvent";
    public AddNodeEvent(Object source) {
        super(source, id, command);
    }
}
