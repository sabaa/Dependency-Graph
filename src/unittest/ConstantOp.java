package unittest;

import controller.Port;

import java.util.Iterator;

/**
 * @author Saba Alimadadi
 */
public class ConstantOp extends MathOperation {
    public void evaluate() {
        double num = 0;
        Iterator itr = this.getInput().keySet().iterator();
        if (itr.hasNext()) {
            String key = (String) itr.next();
            Port p = this.getInput().get(key);
            num = Double.valueOf(p.getValue().toString());
        }
        System.out.println("Cons -> num: " + num + " - Node: " + node.getId());
        itr = this.getOutput().keySet().iterator();
        if (itr.hasNext()) {
            String key = (String) itr.next();
            Port p = this.getOutput().get(key);
            p.setValue(num);
        }
    }
}
