package unittest;

import controller.Port;

import java.util.Iterator;

/**
 * @author Saba Alimadadi
 */
public class SubOp extends MathOperation {
    public void evaluate() {
        double first = 0, second = 0;
        Iterator itr = this.getInput().keySet().iterator();
        if (itr.hasNext()) {
            String key = (String) itr.next();
            Port p = this.getInput().get(key);
            first = Double.valueOf(p.getValue().toString());
        }
        if (itr.hasNext()) {
            String key = (String) itr.next();
            Port p = this.getInput().get(key);
            second = Double.valueOf(p.getValue().toString());
        }
        itr = this.getOutput().keySet().iterator();
        if (itr.hasNext()) {
            String key = (String) itr.next();
            Port p = this.getInput().get(key);
            p.setValue(first - second);
        }
    }
}
