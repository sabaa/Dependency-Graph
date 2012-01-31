package controller;

/**
 * The information about an operation
 * @author Saba Alimadadi
 */
public class OperationInfo {
    // TODO
    /** Unique integer id of the operation */
    private int operationId;
    private static int numOfOperations = 0;

    /**
     * The constructor generates a new id for the new operation
     */
    public OperationInfo() {
        this.operationId = numOfOperations ++;
    }

    /**
     * Returns the unique id
     * @return operation id
     */
    public int getOperationId() {
        return operationId;
    }

    /**
     * Sets the unique id, has limited accessibility
     * @param operationId id
     */
    protected void setOperationId(int operationId) {
        this.operationId = operationId;
    }

}
