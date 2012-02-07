package test;

import controller.DependencyGraph;
import controller.Node;
import controller.Port;
import controller.events.DepGraphListener;

/**
 * An example for making a dependency graph
 *
 * @author Saba Alimadadi
 */
public class SampleGraph {
    public static void main(String[] args) {
        DependencyGraph graph = new DependencyGraph();
        DepGraphListener listener = new DepGraphListener(graph);

        // Create nodes
        Node n1, n2, n3, n4, n5, n6;
        n1 = new Node();
        n2 = new Node();
        n3 = new Node();
        n4 = new Node();
        n5 = new Node();
        n6 = new Node();

        // Create operations
        MyOperation op1, op2, op3, op4, op5, op6;
        op1 = new MyOperation();
        op2 = new MyOperation();
        op3 = new MyOperation();
        op4 = new MyOperation();
        op5 = new MyOperation();
        op6 = new MyOperation();

        // Create ports
        Port p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11;
        p1 = new Port(1);
        p2 = new Port(2);
        p3 = new Port(3);
        p4 = new Port(4);
        p5 = new Port(5);
        p6 = new Port(6);
        p7 = new Port(7);
        p8 = new Port(8);
        p9 = new Port(9);
        p10 = new Port(10);
        p11 = new Port(11);

        // Set the operations of the nodes
        n1.setOperation(op1);
        n2.setOperation(op2);
        n3.setOperation(op3);
        n4.setOperation(op4);
        n5.setOperation(op5);
        n6.setOperation(op6);

        // Add input ports to operations
        op2.addInput("p1-op1", p1);
        op3.addInput("p2-op3", p2);
        op4.addInput("p3-op4", p3);
        op5.addInput("p5-op5", p5);
        //op5.addInput("p6-op6", p6);
        op6.addInput("p7-op7", p7);

        // Add output ports to operations
        op1.addOutput("p1-op1", p1);
        op1.addOutput("p2-op1", p2);
        op1.addOutput("p3-op1", p3);
        op2.addOutput("p4-op2", p4);
        op2.addOutput("p5-op2", p5);
        op3.addOutput("p6-op3", p6);
        op4.addOutput("p7-op4", p7);
        op4.addOutput("p8-op4", p8);
        op5.addOutput("p9-op5", p9);
        op5.addOutput("p10-op5", p10);
        op6.addOutput("p11-op6", p11);

        // Add the nodes to the graph
        graph.addNode(n1);
        graph.addNode(n2);
        graph.addNode(n3);
        graph.addNode(n4);
        graph.addNode(n5);
        graph.addNode(n6);

        // Add the dependency relations between the nodes
        graph.addDependency(n1, n2/*, "n1->n2"*/);
        graph.addDependency(n1, n3);
        graph.addDependency(n1, n4);
        graph.addDependency(n2, n5);
        //graph.addDependency(n5, n3);
        graph.addDependency(n4, n6);

        graph.update(n1);


        System.out.println("");

  /*      MyOperation operation1 = new MyOperation();
        MyOperation operation2 = new MyOperation();
        MyOperation operation3 = new MyOperation();
        MyOperation operation4 = new MyOperation();
        MyOperation operation = new MyOperation();
        Port p1, p2, p3, p4, p5;
        Node n = new Node();
        Node n2, n3, n4;
        n2 = new Node();
        n3 = new Node();
        n4 = new Node();

        p1 = new Port();
        p2 = new Port();
        p3 = new Port();
        p4 = new Port();
        p5 = new Port();

        operation.addInput("1", p1);
        operation.addInput("2", p2);
        operation.addOutput("3", p3);
        operation.addOutput("4", p4);
        operation.addOutput("5", p5);

        n.setOperation(operation);


        DependencyGraph graph = new DependencyGraph();
        graph.addNode(n);
        graph.addNode(n2);
        graph.addNode(n3);
        graph.addNode(n4);

        n.getOperation().evaluate();
        System.out.println("");
*/
        /*MyOperation operation1 = new MyOperation();
                MyOperation operation2 = new MyOperation();
                MyOperation operation3 = new MyOperation();
                MyOperation operation4 = new MyOperation();
                MyOperation operation = new MyOperation();
                Port p1, p2, p3, p4, p5;
                Node n = new Node();
                Node n2, n3, n4;
                n2 = new Node();
                n3 = new Node();
                n4 = new Node();

                p1 = new Port();
                p2 = new Port();
                p3 = new Port();
                p4 = new Port();
                p5 = new Port();

                operation.addInput("1", p1);
                operation.addInput("2", p2);
                operation.addOutput("3", p3);
                operation.addOutput("4", p4);
                operation.addOutput("5", p5);

                n.setOperation(operation);
                n.addInput(n2);
                n.addInput(n3);
                n.addOutput(n4);

                n.getOperation().evaluate();
                System.out.println("");
        */
    }

}
