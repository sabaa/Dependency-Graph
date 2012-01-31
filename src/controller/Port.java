package controller;

import java.util.ArrayList;

/**
 * This class represents the ports that can be used as inputs/outputs to the operations
 * The main thing that a port contains is a generic value
 @author Saba Alimadadi
 */
public class Port<E> {
    /** The value of the port */
    private E value;
    /** List of operations that have this port as input */
    private ArrayList<Operation> relatedOperations_inputPort;
    /** List of operations that have this port as output */
    private ArrayList<Operation> relatedOperations_outputPort;
    /** Shows whether the port is on update path during the current update or not */
    private boolean onUpdatePath;
    /** This shows whether the port was recently modified or not */
    private boolean modified;

    /** Default constructor */
    public Port() {
        relatedOperations_inputPort = new ArrayList<Operation>();
        relatedOperations_outputPort = new ArrayList<Operation>();
        onUpdatePath = false;
        modified = true;
    }

    /**
     * Constructor that sets the value of the port
      * @param value The new value of the port
     */
    public Port(E value) {
        this.value = value;
        relatedOperations_inputPort = new ArrayList<Operation>();
        relatedOperations_outputPort = new ArrayList<Operation>();
        onUpdatePath = false;
        modified = true;
    }

    /**
     * Returns the current value of the port
     * @return Value
     */
    public E getValue() {
        return value;
    }

    /**
     * Sets the new value for the port
     * @param value New value
     */
    public void setValue(E value) {
        this.value = value;
        this.modified = true;//setOnUpdatePath(true);
    }

    /**
     * Returns the list operations that have this port as output
     * @return ArrayList of operations
     */
    public ArrayList<Operation> getRelatedOperations_inputPort() {
        return this.relatedOperations_inputPort;
    }

    /**
     * Add an operation to the list of operations that this port serves as input for
     * @param op New operation
     */
    public void addRelatedOperations_inputPort(Operation op) {
        this.relatedOperations_inputPort.add(op);
        // op.addInput(); ??????????
        modified = true;//setOnUpdatePath(true);
    }

    /**
     * Returns the list operations that have this port as input
     * @return ArrayList of operations
     */
    public ArrayList<Operation> getRelatedOperations_outputPort() {
        return this.relatedOperations_outputPort;
    }

    /**
     * Add an operation to the list of operations that this port serves as output for
     * @param op New operation
     */
    public void addRelatedOperations_outputPort(Operation op) {
        this.relatedOperations_outputPort.add(op);
        // op.addOutput(); ??????????
        modified = true;//setOnUpdatePath(true);
    }

    /**
     * This method checks whether the port is on update path or not
     * @return Yes/No
     */
    public boolean isOnUpdatePath() {
        return onUpdatePath;
    }

    /**
     * This method sets the value for the flag that shows whether the port is on update path or not
     * @param onUpdatePath
     */
    public void setOnUpdatePath(boolean onUpdatePath) {
        this.onUpdatePath = onUpdatePath;
    }

    /**
     * This method shows whether the port was recently modified or not
     * @return Yes/No
     */
    public boolean isModified() {
        return modified;
    }

    /**
     * This method sets a new value for the modified field, that shows whether the port is on update path or not
     * @param modified True/False
     */
    public void setModified(boolean modified) {
        this.modified = modified;
    }
}
