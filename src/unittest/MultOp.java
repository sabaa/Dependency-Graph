package unittest;

import controller.Port;

import java.util.Iterator;

/**
 * @author Saba Alimadadi
 */
public class MultOp extends MathOperation {
    public void evaluate() {
        double product = 1;
        Iterator itr = this.getInput().keySet().iterator();
        while (itr.hasNext()) {
            String key = (String) itr.next();
            Port p = this.getInput().get(key);
            product *= Double.valueOf(p.getValue().toString());
        }
        System.out.println("Mult -> res: " + product + " - Node: " + node.getId());
        itr = this.getOutput().keySet().iterator();
        if (itr.hasNext()) {
            String key = (String) itr.next();
            Port p = this.getOutput().get(key);
            p.setValue(product);
        }
    }
}
