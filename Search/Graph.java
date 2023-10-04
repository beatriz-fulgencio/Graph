package Search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;

public class Graph {

    private HashMap<Integer, Node> graph = new HashMap<Integer, Node>();
    int n;
    int t;
    // private boolean[] marked;
    Stack<String> edges =new Stack<String>();


    public Graph(int n) {
        this.n = n;

        for (int i = 0; i < n; i++) {
            graph.put(i, new Node(i + 1));
        }
    }

    public void addEdge(int source, int destination) {
        graph.get(source - 1).adjacent.add(graph.getOrDefault(destination - 1, new Node(destination - 1)));
    }

    public Stack<String> seach(int vertex) {
        t = 1;
        Vector<VisitedNode> visited = new Vector<VisitedNode>(n);

        for (int i = 0; i < n; i++)
            visited.add(new VisitedNode(false, 0));

        for (int i = 0; i < n; i++) {
            if (graph.get(i).TD == 0) {
                graph.get(i).TD =t;
                DFS(graph.get(i), graph.get(vertex));
                //nonRecursiveDFS(graph.get(i), visited);
            }
        }
        edges.push("-----");
        for(String s : graph.get(vertex - 1).arestas){
            edges.push(s);
        }

        return edges;

    }

    // private void nonRecursiveDFS(Node node, Vector<VisitedNode> visited) {
    //     // Create a stack for DFS
    //     Stack<Node> stack = new Stack<>();

    //     stack.push(node);

    //     while (!stack.empty()) {
    //         t++;
    //         // Pop a vertex from stack and print it
    //         node = stack.peek();
    //         stack.pop();
    //         node.adjacent.get(0).father = node;

    //         if (!visited.get(node.element - 1).visited) {
    //             visited.set(node.element - 1, new VisitedNode(true, t));
    //             if (node.father != null) {
    //                 node.father.adjacent.remove(node);
    //                 node.father.arestas.add(node.father.element + "->" + node.element + ":arvore");
    //             }
    //             node.TD = t;
    //         } else {
    //             if (graph.get(node.element - 1).TT != 0) {
    //                 if (node.father != null)
    //                     node.father.arestas.add(node.father.element + "->" + node.element + ":retorno");
    //             }
    //             if (visited.get(node.element - 1).TD < node.TD) {
    //                 if (node.father != null)
    //                     node.father.arestas.add(node.father.element + "->" + node.element + ":avanço");
    //             } else {
    //                 if (node.father != null)
    //                     node.father.arestas.add(node.father.element + "->" + node.element + ":cruzamento");
    //             }
    //         }

    //         Iterator<Node> itr = node.adjacent.iterator();

    //         while (itr.hasNext()) {
    //             Node v = itr.next();
    //             if (!visited.get(v.element - 1).visited) {
    //                 v.father = node;
    //                 stack.push(v);
    //             }
    //         }
    //         if (node.father != null && node.father.adjacent.isEmpty()) {
    //             node.father.TT = t + 1;
    //         }
    //     }

    // }

    private void DFS(Node node, Node node2) {
        node.visited = true;
        t += 1;

        for (Node v : node.adjacent) {
            if (v.TD == 0 && v.TT == 0) {
                v.father = node;
                v.TD = t;
                node.arestas.add(node.element + "->" + v.element + ":arvore");
                edges.push(node.element + "->" + v.element + ":arvore");

                if (t > 15430) {
                    System.out.println("hello");
                }
                DFS(v, node2);
            } else if (v.TT == 0) {
                node.arestas.add(node.element + "->" + v.element + ":retorno");
            } else {
                if (node.TD < v.TD) {
                    node.arestas.add(node.element + "->" + v.element + ":avanço");
                    // avanco
                } else {
                    node.arestas.add(node.element + "->" + v.element + ":cruzamento");
                    // cruz
                }
            }
        }
        t += 1;
        node.TT = t;
    }

    public void sortNodes() {
        for (int i = 0; i < n; i++) {
            graph.get(i).sortAdjacent();
            ;
        }
    }



}
