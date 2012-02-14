package unittest;

import controller.Port;

import java.util.Iterator;

/**
 * @author Saba Alimadadi
 */
public class SubOp extends MathOperation {
    public void evaluate() {
        double first = 0, second = 0;
        if (this.getInput().get("first") != null) {
            first = Double.valueOf(this.getInput().get("first").getValue().toString());
        }
        if (this.getInput().get("second") != null) {
            second = Double.valueOf(this.getInput().get("second").getValue().toString());
        }

        System.out.println("Sub -> res: " + (first - second) + " - Node: " + node.getId());
        Iterator itr = this.getOutput().keySet().iterator();
        if (itr.hasNext()) {
            String key = (String) itr.next();
            Port p = this.getOutput().get(key);
            p.setValue(first - second);
        }
    }
}
