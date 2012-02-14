package unittest;

import controller.Operation;
import controller.Port;

import java.util.Iterator;

/**
 * Sample operation for unit test representing math functions
 * @author Saba Alimadadi
 */
public abstract class MathOperation extends Operation {
    public void evaluate() {
        double value = 0;
        Iterator itr = this.getInput().keySet().iterator();
        if (itr.hasNext()) {
            String key = (String) itr.next();
            Port p = this.getInput().get(key);
            value = Double.valueOf(p.getValue().toString());
        }
        itr = this.getOutput().keySet().iterator();
        if (itr.hasNext()) {
            String key = (String) itr.next();
            Port p = this.getInput().get(key);
            p.setValue(value);
        }

    }
}
