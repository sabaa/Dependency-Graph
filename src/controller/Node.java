package controller;

import java.util.ArrayList;

/**
 * This class represents a node in the dependency graph
 * Each node contains an operation, and 2 lists of input and output nodes
 * @author Saba Alimadadi
 */
public class Node {
    /** The operation of the node */
    private Operation operation;
    /** The list of input nodes that this node depends on them */
    private ArrayList<Node> input;
    /** The list of output nodes that depend on this node */
    private ArrayList<Node> output;
    /** Unique id of the node, set by the system */
    private int nodeId;
    /** Number of nodes created so far, used for setting the unique node id */
    private static int numOfNodes = 0;
    /** This field shows whether or not the node was visited during the traversal of the tree in the update process */
    private boolean visited;
    /** This field shows whether or not hte node is located on a path to the updated node or not */
    private boolean onUpdatedNodePath;

    /**
     *  Default constructor, initializes empty lists
     */
    public Node() {
        //operation = new Operation(); // todo or null ???
        input = new ArrayList<Node>();
        output = new ArrayList<Node>();
        // Set the unique id
        nodeId = numOfNodes ++;
        visited = false;
        onUpdatedNodePath = false;
    }

    /**
     * Constructor that gets the operation, and initializes empty lists
     * @param operation Operation
     */
    public Node(Operation operation) {
        //this.operation = operation;
        this.operation.setNode(this);
        input = new ArrayList<Node>();
        output = new ArrayList<Node>();
        // Set the unique id
        nodeId = numOfNodes ++;
        visited = false;
        onUpdatedNodePath = false;
    }

    /**
     * This constructor initializes input and output lists
     * @param input List of input nodes
     * @param output List of output nodes
     */
    public Node(ArrayList<Node> input, ArrayList<Node> output) {
        //operation = new Operation();
        this.operation.setNode(this);
        this.input = input;
        this.output = output;
        // Set the unique id
        nodeId = numOfNodes ++;
        visited = false;
        onUpdatedNodePath = false;
    }

    /**
     * This constructor initializes the operation, and the lists of input/output nodes
     * @param operation Operation
     * @param input List of input nodes
     * @param output List of output nodes
     */
    public Node(Operation operation, ArrayList<Node> input, ArrayList<Node> output) {
        this.operation = operation;
        this.operation.setNode(this);
        this.input = input;
        this.output = output;
        // Set the unique id
        nodeId = numOfNodes ++;
        visited = false;
        onUpdatedNodePath = false;
    }

    /**
     * This method returns the current operation of the node
     * @return The operation
     */
    public Operation getOperation() {
        return operation;
    }

    /**
     * This method sets the operation of the node to the new value
     * @param operation New Operation
     */
    public void setOperation(Operation operation) {
        this.operation = operation;
        this.operation.setNode_(this);
    }

    protected void setOperation_(Operation operation) {
        this.operation = operation;
    }

    /**
     * This method returns the list of input nodes
     * @return List of input nodes
     */
    public ArrayList<Node> getInput() {
        return input;
    }

    /**
     * This method sets the list of input nodes to the new list
     * @param input New list of inputs
     */
    public void setInput(ArrayList<Node> input) {
        this.input = input;
        // The relations are 2 -way
        for (Node n : input) {
            n.addOutput(this);
        }
    }

    /**
     * This method checks whether this node has a certain node as an input or not
     * @param n The node that must be checked whether or not is an input of this node
     * @return Yes/No
     */
    public boolean hasInput(Node n) {
        return input.contains(n);
    }

    /**
     * This method returns the list of output nodes
     * @return List of output nodes
     */
    public ArrayList<Node> getOutput() {
        return output;
    }

    /**
     * This method sets the list of output nodes to the new list
     * @param output New list of outputs
     */
    public void setOutput(ArrayList<Node> output) {
        this.output = output;
        // The relations are 2 -way
        for (Node n : output) {
            n.addInput(this); // todo ooooooooooooooooooo
        }
    }

    /**
     * This method checks whether this node has a certain node as an output or not
     * @param n The node that must be checked whether or not is an output of this node
     * @return Yes/No
     */
    public boolean hasOutput(Node n) {
        return output.contains(n);
    }

    /**
     * This methods adds one node to the list of input nodes for this node
     * @param node New input
     */
    public void addInput(Node node) {
        input.add(node);
        // The relations are 2 -way
        // this makes an infinite loop
        // node.addOutput(this);
        // node.addReverseDependency_output(this);

    }    /*

    public void addReverseDependency_input(Node node) {
        input.add(node);
    }      */

    /**
     * This methods adds one node to the list of output nodes for this node
     * @param node New output
     */
    public void addOutput(Node node) {
        output.add(node);
        // The relations are 2 -way
        // this makes an infinite loop
        // node.addInput(this);
        // node.addReverseDependency_input(this);
    }
    /*
    public void addReverseDependency_output(Node node) {
        output.add(node);
    } */

    /**
     * Returns the id of the node
     * @return Node ID
     */
    public int getId() {
        return nodeId;
    }

    /**
     * Shows whether the node was visited during the process of update or not
     * @return Yes/No
     */
    public boolean isVisited() {
        return visited;
    }

    /**
     * Sets the value of the visited field. True means that the node is visited
     * @param visited True/False
     */
    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * Shows whether the node is located on a path that lead to the updated node or not
     * @return Yes/No
     */
    public boolean isOnUpdatedNodePath() {
        return onUpdatedNodePath;
    }

    /**
     * Sets the value for the field that shows if the node is on a path to the updated node
     * @param onUpdatedNodePath True/False
     */
    public void setOnUpdatedNodePath(boolean onUpdatedNodePath) {
        this.onUpdatedNodePath = onUpdatedNodePath;
    }
}
