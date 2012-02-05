package controller.events;

import java.awt.event.ActionEvent;
import java.util.EventObject;

/**
 * This class represents the events related to the dependency graph
 * @author Saba Alimadadi
 */
public class DepGraphEvent extends ActionEvent /*EventObject*/ {
    // todo actionevent or eventobject ???????????????????????????
    // todo ooooooooooooooooooooooooooooooooooooooooo
    /**
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    /*public DepGraphEvent(Object source) {
        super(source);
    }*/

    public DepGraphEvent(Object source, int id, String command) {
        super(source, id, command);
    }
}
