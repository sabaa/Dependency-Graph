package unittest;

import controller.Port;

import java.util.Iterator;

/**
 * @author Saba Alimadadi
 */
public class AddOp extends MathOperation {
    public void evaluate() {
        double sum = 0;
        Iterator itr = this.getInput().keySet().iterator();
        while (itr.hasNext()) {
            String key = (String) itr.next();
            Port p = this.getInput().get(key);
            sum += Double.valueOf(p.getValue().toString());
        }
        System.out.println("Add: " + sum + " - Node: " + node.getId());
        itr = this.getOutput().keySet().iterator();
        if (itr.hasNext()) {
            String key = (String) itr.next();
            Port p = this.getOutput().get(key);
            p.setValue(sum);
        }
    }
}
