package unittest;

import controller.Port;

import java.util.Iterator;

/**
 * @author Saba Alimadadi
 */
public class DivOp extends MathOperation {
    public void evaluate() {
        double first = 0, second = 0;

        if (this.getInput().get("first") != null) {
            first = Double.valueOf(this.getInput().get("first").getValue().toString());
        }
        if (this.getInput().get("second") != null) {
            second = Double.valueOf(this.getInput().get("second").getValue().toString());
        }

        double f = (second == 0)?-Integer.MAX_VALUE:(first/second);
        //System.out.println("Div -> res: " + f + " - Node: " + node.getId());
        Iterator itr = this.getOutput().keySet().iterator();
        if (itr.hasNext()) {
            String key = (String) itr.next();
            Port p = this.getOutput().get(key);
            if (second == 0) {
                System.err.println("ILLEGAL DIVISION");
                p.setValue(Integer.MAX_VALUE);
            }
            else
                p.setValue(first / second);
        }
    }
}
