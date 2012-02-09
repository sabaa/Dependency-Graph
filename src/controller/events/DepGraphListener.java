package controller.events;

import controller.DependencyGraph;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import java.util.EventObject;

/**
 * This class is a listener for dependency graph events
 * @author Saba Alimadadi
 */
public class DepGraphListener implements EventListener/*implements ActionListener */{
    /** Reference to the dependency graph */
    private DependencyGraph dependencyGraph;

    /**
     * The constructor gets the dependency graph, and adds this as an actionListener to it
     * @param dependencyGraph Reference to the dependency graph
     */
    public DepGraphListener(DependencyGraph dependencyGraph) {
        this.dependencyGraph = dependencyGraph;
        dependencyGraph.addEventListener(this);
        // todo oooooooo
    }

    /**
     * This method catches and handles an event happened in dependency graph
     * @param e The event
     */
    public void actionPerformed(DepGraphEvent e) {
        if (e.getId() == 1) {
            System.out.println("id = 1");
            System.out.println(e.getCommand());
        }
        else if (e.getId() == 2) {
            System.out.println("id = 2");
            System.out.println(e.getCommand());
        }
    }
}
