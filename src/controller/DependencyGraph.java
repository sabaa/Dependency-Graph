package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * The Dependency Graph class. Contains and handles all dependency nodes and their dependency relations
 *
 * @author Saba Alimadadi
 */
public class DependencyGraph {
    /**
     * All the nodes that no other node depends on them, thus they have no higher level ancestors
     */
    private ArrayList<Node> firstLevelNodes;
    /**
     * List of all nodes in the graph
     */
    private ArrayList<Node> nodesList;
    /**
     * List of nodes after applying topoligical sort to them
     */
    private ArrayList<Node> topologicallySortedList;

    /**
     * Default constructor
     */
    public DependencyGraph() {
        firstLevelNodes = new ArrayList<Node>();
        nodesList = new ArrayList<Node>();
        topologicallySortedList = new ArrayList<Node>();
    }

    /**
     * This method is for adding a new node to the dependency graph
     *
     * @param n New node
     */
    public void addNode(Node n) {
        firstLevelNodes.add(n);
        nodesList.add(n);
        // todo later check for connections based on ports and put node in appropriate place if applicable
    }

    /**
     * This method adds a dependency relation from dependedOnNode to the dependentNode
     *
     * @param dependedOnNode The other nodes depend on this
     * @param dependentNode  This node depends on the other node
     * @param key            The key that determines the relation between the two nodes
     */
    public void addDependency(Node dependedOnNode, Node dependentNode/*, String key*/) {
        if (dependedOnNode == null || dependentNode == null/* || key == null*/)
            return;
        if (!hasNode(dependedOnNode) || !hasNode(dependentNode))
            return;

        // Check if the dependedOnNode had no dependentNodes before (it was in the firstLevelNodes list),
        // remove it from there and make new relations
        for (Node n : firstLevelNodes) {
            if (n.getId() == dependedOnNode.getId()) {
                firstLevelNodes.remove(n);
                break;
            }
        }
        // Add dependency relations in both directions
        dependedOnNode.addOutput(dependentNode);
        dependentNode.addInput(dependedOnNode);
    }

    /**
     * This method checks whether the graph contains a certain node or not
     *
     * @param key Node
     * @return Yes/No - whether or not the graph contains the key node
     */
    public boolean hasNode(Node key) {
        if (key == null)
            return false;
        for (Node n : nodesList)
            if (n.getId() == key.getId())
                return true;
        return false;
    }

    /**
     * Returns the nodes that the input node depends on
     * @param n
     * @return
     */
    public ArrayList<Node> getNodesDependedOnBy(Node n) {
        return n.getOutput();
    }

    /**
     * Returns the nodes that depend on the input node
     * @param n
     * @return
     */
    public ArrayList<Node> getDependentNodes(Node n) {
        return n.getInput();
    }

    /**
     * This method updated all dependent nodes (direct or indirect) on an updated node in the graph
     *
     * @param updatedNode The node that was originally updated
     */
    public void update(Node updatedNode) {
        if (!hasNode(updatedNode))
            return;
        /*updatedNode.setOnUpdatedNodePath(true);
        Iterator itr = updatedNode.getOperation().getOutput().keySet().iterator();
        while (itr.hasNext()) {
            String key = (String) itr.next();
            Port p = updatedNode.getOperation().getOutput().get(key);
            p.setOnUpdatePath(true);
        } */
        /*topologicallySortedList.clear();*/
        topologicalSort(updatedNode);
        boolean dependentOnUpdatedNode = false;
        for (Node n : topologicallySortedList) {
            if (dependentOnUpdatedNode) {
                if (n.isOnUpdatedNodePath())
                    n.getOperation().evaluate();
            } else if (n.getId() == updatedNode.getId()) {
                n.getOperation().evaluate();
                dependentOnUpdatedNode = true;
            }
        }

        resetVisitedAndOnUpdatePathFlags();
        resetPortsOnUpdatePathFlags();
    }

    /**
     * This method performs a topological sort on all nodes of the graph by calling the recursive method for this
     * @param updatedNode The originally updated node
     * @return The resulting list of the topological sort on the graph
     */
    private void topologicalSort(Node updatedNode) {
        topologicallySortedList.clear();
        resetVisitedAndOnUpdatePathFlags();
        for (Node n : firstLevelNodes)
            dfsTopologicalSort(n, updatedNode);
    }

    /**
     * This method performs a topological sort on all nodes of the graph
     * @param node Current Node that is being process
     * @param originallyUpdatedNode The original node that was updated
     */
    private boolean dfsTopologicalSort(Node node, Node originallyUpdatedNode) {
        if (node.isVisited())
            return node.isOnUpdatedNodePath();

        boolean nodeOnUpdatePath = false;
        if (node.getId() == originallyUpdatedNode.getId())
            nodeOnUpdatePath = true;
        /*return true;*/

        // If one of input ports is on update path, then the node is on update path
        Iterator inputItr = node.getOperation().getInput().keySet().iterator();
        while (inputItr.hasNext()) {
            String key = (String) inputItr.next();
            Port inP = node.getOperation().getInput().get(key);
            if (inP.isOnUpdatePath()) {
                nodeOnUpdatePath = true;
            }
        }

        // If one of the inputs is on update path then the node itself is on update path
        for (Node n : node.getInput()) {
            boolean onPath = dfsTopologicalSort(n, originallyUpdatedNode);
            nodeOnUpdatePath = nodeOnUpdatePath || onPath;
        }

        if (nodeOnUpdatePath) {
            // Node is on update path
            node.setOnUpdatedNodePath(true);
            // And the output ports are also on update path
            Iterator outputItr = node.getOperation().getOutput().keySet().iterator();
            while (outputItr.hasNext()) {
                String key2 = (String) outputItr.next();
                Port outP = node.getOperation().getOutput().get(key2);
                // todo just commented this for testing - MUST RETURN BACK TO THE CODE!
                //if (outP.isModified())
                outP.setOnUpdatePath(true);
            }
        }

        // Node is visited
        node.setVisited(true);
        // Node gets added to the sort list
        topologicallySortedList.add(topologicallySortedList.size(), node);

        return nodeOnUpdatePath;
    }

    /**
     * This method resets all the values for the booleans that indicate whether the node was visited or
     * was on a path to the updated node during this traversal of the graph in the process of updating and propagation of change
     */
    private void resetVisitedAndOnUpdatePathFlags() {
        for (Node n : nodesList) {
            n.setVisited(false);
            n.setOnUpdatedNodePath(false);
        }
    }

    /**
     * This method resets the onUpdatePath boolean in all ports of the graph to false, after the update is finished
     */
    private void resetPortsOnUpdatePathFlags() {
        // Reset all the input ports of all the nodes (that are also the same as output ports for other node)
        for (Node n : nodesList) {
            HashMap<String, Port> inputPorts = n.getOperation().getInput();
            Iterator itr = inputPorts.keySet().iterator();
            while (itr.hasNext()) {
                String key = (String) itr.next();
                Port p = inputPorts.get(key);
                p.setOnUpdatePath(false);
                p.setModified(false);
            }
        }
        // Separately reset the output ports of the firstLevelNodes, since they are not used as inputs for other nodes
        for (Node n : firstLevelNodes) {
            HashMap<String, Port> outputPorts = n.getOperation().getOutput();
            Iterator itr = outputPorts.keySet().iterator();
            while (itr.hasNext()) {
                String key = (String) itr.next();
                Port p = outputPorts.get(key);
                p.setOnUpdatePath(false);
                p.setModified(false);
            }
        }
    }

}
