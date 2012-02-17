package unittest;

import controller.DependencyGraph;
import controller.Node;
import controller.Port;
import org.junit.Test;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayList;

import static java.lang.Math.pow;

/**
 * This class is used for performing unit tests on the dependency graph
 * @author Saba Alimadadi
 */
public class TestGraph {
    @Test
    public void oneOutputTest() {
        /**
         * TEST 1
         * This is a test for checking the propagation in the graph and checking the final result of update
         */
        // Create the graph
        DependencyGraph graph = new DependencyGraph();
        ArrayList<Node> nodeList = new ArrayList<Node>();

        // Create the empty ports
        ArrayList<Port> portList = new ArrayList<Port>();
        for (int i = 0; i < 22; i ++)
            portList.add(new Port(0));

        double a, b, c, d, e, f, g;
        a = 1;
        b = 2;
        c = 4;
        d = 0.5;
        e = 3;
        f = 4.5;
        g = 10;

        portList.get(1).setValue(a);
        portList.get(0).setValue(b);
        portList.get(5).setValue(c);
        portList.get(11).setValue(d);
        portList.get(6).setValue(e);
        portList.get(7).setValue(f);
        portList.get(14).setValue(g);

        // for division and multiplication
        portList.get(8).setValue(1);
        portList.get(10).setValue(1);
        portList.get(19).setValue(1); 
        portList.get(20).setValue(1);
        portList.get(12).setValue(1);
        portList.get(13).setValue(1);
        
        // Create the operations
        ArrayList<MathOperation> opList = new ArrayList<MathOperation>();
        // Operation 0
        ConstantOp op0 = new ConstantOp();
        op0.addInput("0", portList.get(0));
        op0.addOutput("2", portList.get(2));
        // Operation 1
        ConstantOp op1 = new ConstantOp();
        op1.addInput("1", portList.get(1));
        op1.addOutput("3", portList.get(3));
        // Operation 2
        PowOp op2 = new PowOp();
        op2.addInput("2", portList.get(2));
        op2.addOutput("4", portList.get(4));
        // Operation 3
        PowOp op3 = new PowOp();
        op3.addInput("3", portList.get(3));
        op3.addOutput("8", portList.get(8));
        // Operation 4
        AddOp op4 = new AddOp();
        op4.addInput("3", portList.get(3));
        op4.addInput("4", portList.get(4));
        op4.addOutput("9", portList.get(9));
        // Operation 5
        ConstantOp op5 = new ConstantOp();
        op5.addInput("5", portList.get(5));
        op5.addOutput("10", portList.get(10));
        // Operation 8
        MultOp op8 = new MultOp();
        op8.addInput("8", portList.get(8));
        op8.addInput("9", portList.get(9));
        op8.addInput("10", portList.get(10));
        op8.addOutput("15", portList.get(15));
        // Operation 9
        ConstantOp op9 = new ConstantOp();
        op9.addInput("11", portList.get(11));
        op9.addOutput("16", portList.get(16));
        // Operation 12
        SubOp op12 = new SubOp();
        op12.addInput("first", portList.get(15));
        op12.addInput("second", portList.get(16));
        op12.addOutput("19", portList.get(19));
        // Operation 6
        ConstantOp op6 = new ConstantOp();
        op6.addInput("6", portList.get(6));
        op6.addOutput("12", portList.get(12));
        // Operation 7
        ConstantOp op7 = new ConstantOp();
        op7.addInput("7", portList.get(7));
        op7.addOutput("13", portList.get(13));
        // Operation 10
        DivOp op10 = new DivOp();
        op10.addInput("first", portList.get(12));
        op10.addInput("second", portList.get(13));
        op10.addOutput("17", portList.get(17));
        // Operation 11
        ConstantOp op11 = new ConstantOp();
        op11.addInput("14", portList.get(14));
        op11.addOutput("18", portList.get(18));
        // Operation 13
        AddOp op13 = new AddOp();
        op13.addInput("9", portList.get(9));
        op13.addInput("17", portList.get(17));
        op13.addInput("18", portList.get(18));
        op13.addOutput("20", portList.get(20));
        // Operation 14
        MultOp op14 = new MultOp();
        op14.addInput("19", portList.get(19));
        op14.addInput("20", portList.get(20));
        op14.addOutput("21", portList.get(21));

        opList.add(0, op0);
        opList.add(1, op1);
        opList.add(2, op2);
        opList.add(3, op3);
        opList.add(4, op4);
        opList.add(5, op5);
        opList.add(6, op6);
        opList.add(7, op7);
        opList.add(8, op8);
        opList.add(9, op9);
        opList.add(10, op10);
        opList.add(11, op11);
        opList.add(12, op12);
        opList.add(13, op13);
        opList.add(14, op14);

        for (int i = 0; i < 15; i ++)
            nodeList.add(i, new Node(opList.get(i)));

        /*
        nodeList.get(0).addOutput(nodeList.get(2));
        nodeList.get(1).addOutput(nodeList.get(3));
        nodeList.get(1).addOutput(nodeList.get(4));
        nodeList.get(2).addInput(nodeList.get(0));
        nodeList.get(2).addOutput(nodeList.get(4));
        nodeList.get(3).addOutput(nodeList.get(8));
        nodeList.get(3).addInput(nodeList.get(1));
        nodeList.get(4).addOutput(nodeList.get(8));
        nodeList.get(4).addInput(nodeList.get(1));
        nodeList.get(4).addInput(nodeList.get(2));
        nodeList.get(5).addOutput(nodeList.get(8));
        nodeList.get(8).addOutput(nodeList.get(12));
        nodeList.get(8).addInput(nodeList.get(3));
        nodeList.get(8).addInput(nodeList.get(4));
        nodeList.get(8).addInput(nodeList.get(5));
        nodeList.get(12).addOutput(nodeList.get(14));
        nodeList.get(12).addInput(nodeList.get(8));
        nodeList.get(12).addInput(nodeList.get(9));
        nodeList.get(9).addOutput(nodeList.get(12));
        nodeList.get(6).addOutput(nodeList.get(10));
        nodeList.get(7).addOutput(nodeList.get(10));
        nodeList.get(10).addOutput(nodeList.get(13));
        nodeList.get(10).addInput(nodeList.get(6));
        nodeList.get(10).addInput(nodeList.get(7));
        nodeList.get(11).addOutput(nodeList.get(13));
        nodeList.get(13).addOutput(nodeList.get(14));
        nodeList.get(13).addInput(nodeList.get(10));
        nodeList.get(13).addInput(nodeList.get(11));
        nodeList.get(14).addInput(nodeList.get(12));
        nodeList.get(14).addInput(nodeList.get(13));
        */

        for (Node n : nodeList) {
            graph.addNode(n);
        }
        graph.addDependency(nodeList.get(0), nodeList.get(2));
        graph.addDependency(nodeList.get(1), nodeList.get(3));
        graph.addDependency(nodeList.get(1), nodeList.get(4));
        graph.addDependency(nodeList.get(2), nodeList.get(4));
        graph.addDependency(nodeList.get(3), nodeList.get(8));
        graph.addDependency(nodeList.get(4), nodeList.get(8));
        graph.addDependency(nodeList.get(5), nodeList.get(8));
        graph.addDependency(nodeList.get(8), nodeList.get(12));
        graph.addDependency(nodeList.get(9), nodeList.get(12));
        graph.addDependency(nodeList.get(6), nodeList.get(10));
        graph.addDependency(nodeList.get(7), nodeList.get(10));
        graph.addDependency(nodeList.get(4), nodeList.get(13));
        graph.addDependency(nodeList.get(10), nodeList.get(13));
        graph.addDependency(nodeList.get(11), nodeList.get(13));
        graph.addDependency(nodeList.get(12), nodeList.get(14));
        graph.addDependency(nodeList.get(13), nodeList.get(14));

        graph.update(nodeList.get(0));
        graph.update(nodeList.get(1));
        graph.update(nodeList.get(5));
        graph.update(nodeList.get(6));
        graph.update(nodeList.get(7));
        graph.update(nodeList.get(9));
        graph.update(nodeList.get(11));

        
        double expected = (Math.pow(a, 2) * (a + Math.pow(b, 2)) * c - d) * (a + Math.pow(b, 2) + e / f + g);
        double result = Double.parseDouble(nodeList.get(14).getOperation().getOutput().get("21").getValue().toString());

        org.junit.Assert.assertTrue(expected == result);
//        org.junit.Assert.assertEquals(expected, result, 0.001);

    }

    public static void main(String[] args) {
        Result result = org.junit.runner.JUnitCore.runClasses(TestGraph.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
    }
}
