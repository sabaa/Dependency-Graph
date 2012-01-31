package controller;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class represents an operation inside each node of the dependency graph
 * It mainly depicts the way that a dependency node gets updated
 * The operation class could have one or more inputs and outputs in terms of Ports
 *
 * @author Saba Alimadadi
 */
public class Operation {
    /** Information about the operation */
    protected OperationInfo info;
    /** Input ports of the operation */
    protected HashMap<String, Port> input;
    /** Output ports of the operation */
    protected HashMap<String, Port> output;
    /** The reference to the container node */
    protected Node node;

    /**
     * Default constructor, creates empty maps for input and output
     */
    public Operation() {
        info = new OperationInfo(); ///////////
        input = new HashMap<String, Port>();
        output = new HashMap<String, Port>();
    }

    /**
     * Constructor that gets the operation info and creates empty maps for input and output
     * @param info Operation Info
     */
    public Operation(OperationInfo info) {
        this.info = info;
        input = new HashMap<String, Port>();
        output = new HashMap<String, Port>();
    }

    /**
     * Constructor that gets the input and output
     * @param input Input Port(s)
     * @param output Output Port(s)
     */
    public Operation(HashMap<String, Port> input, HashMap<String, Port> output) {
        info = new OperationInfo(); ///////////
        this.input = input;
        this.output = output;
    }

    /**
     * Constructor that initializes all fields using parameters provided by the user
     * @param info Operation Info
     * @param input Input Port(s)
     * @param output Output Port(s)
     */
    public Operation(OperationInfo info, HashMap<String, Port> input, HashMap<String, Port> output) {
        this.info = info;
        this.input = input;
        this.output = output;
    }

    /**
     * Returns the current info about the operation
     * @return Operation Info
     */
    public OperationInfo getInfo() {
        return info;
    }

    /**
     * Updates the info about the operation
     * @param info Operation Info
     */
    public void setInfo(OperationInfo info) {
        this.info = info;
    }

    /**
     * Returns the map of input(s) of the operation
     * @return Input Ports
     */  // TODO SHOULD RETURN READ-ONLY LIST
    public HashMap<String, Port> getInput() {
        return input;
    }

    /**
     * Sets the input of the operation
     * @param input Input Ports
     */
    /*public void setInput(HashMap<String, Port> input) {
        this.input = input;
        // should check to update the dependency relations between nodes in the graph
        // throw an event
    }*/

    /**
     * Returns the map of output(s) of the operation
     * @return Output Ports
     */  // TODO SHOULD RETURN READ-ONLY LIST
    public HashMap<String, Port> getOutput() {
        return output;
    }

    /**
     * Sets the output of the operation
     * @param output Output Ports
     */
    /*public void setOutput(HashMap<String, Port> output) {
        this.output = output;
        // should check to update the dependency relations between nodes in the graph
        // throw an event
    }*/

    /**
     * This method adds a Port to the map of input ports for this operation
     * @param s String key for the map
     * @param p The new input port
     */
    public void addInput(String s, Port p) {
        if (p == null)
            return;
        // Add the port to the inputs of the operation
        input.put(s, p);
        // Add the operation to the list of operations that the port plays as input for
        p.addRelatedOperations_inputPort(this);
        p.setModified(true);//p.setOnUpdatePath(true);
        // Check to update the dependency relations between nodes in the graph        
        for (Object o : p.getRelatedOperations_outputPort()) {
            Operation op = (Operation)o;
            // If the two nodes are node already connected (the node containing the op and the node containing the p
            if (!this.node.hasInput(op.getNode())) {
                this.getNode().addInput(op.getNode());
                //op.getNode().addOutput(this.getNode());
                // whether you add input or output to a node the reverse relation is made automatically (???)
            }
        }
        // throw an event
    }

    /**
     * This method adds a Port to the map of output ports for this operation
     * @param s String key for the map
     * @param p The new output port
     */
    public void addOutput(String s, Port p) {
        if (p == null)
            return;
        output.put(s, p);
        // Add the operation to the list of operations that the port plays as output for
        p.addRelatedOperations_outputPort(this);
        p.setModified(true);//p.setOnUpdatePath(true);

        // throw an event?
    }

    /**
     * Returns the node that contains this operation
     * @return Node
     */
    public Node getNode() {
        return node;
    }

    /**
     * Sets the node that should contain this operation
     * @param node The node that has this operation
     */
    public void setNode(Node node) {
        this.node = node;
        node.setOperation_(this);
    }

    protected void setNode_(Node node) {
        this.node = node;
    }

    /**
     * This method executes the operation using input ports and updates the outputs
     * Should be implemeted by the user
     */
    public void evaluate() {
        // todo throw an event
    }
}
