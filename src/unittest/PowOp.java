package unittest;

import controller.Port;

import java.util.Iterator;

/**
 * @author Saba Alimadadi
 */
public class PowOp extends MathOperation {
    public void evaluate() {
        double power = 0;
        Iterator itr = this.getInput().keySet().iterator();
        while (itr.hasNext()) {
            String key = (String) itr.next();
            Port p = this.getInput().get(key);
            double num = Double.valueOf(p.getValue().toString());
            power = num * num;
        }
        System.out.println("Pow -> res: " + power + " - Node: " + node.getId());
        itr = this.getOutput().keySet().iterator();
        if (itr.hasNext()) {
            String key = (String) itr.next();
            Port p = this.getOutput().get(key);
            p.setValue(power);
        }
    }
}
