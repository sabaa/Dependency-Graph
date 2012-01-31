package test;

import controller.Operation;

/**
 * Sample operation
 * @author Saba Alimadadi
 */
public class MyOperation extends Operation {
    public void evaluate() {
        System.out.println("----->>>" + info.getOperationId());        
    } 
}
