package Search;

import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private HashMap<Integer, Node> graph = new HashMap<Integer, Node>();
    int n;
    int t;

    public Graph(int n) {
        this.n = n;

        for (int i = 0; i < n; i++) {
            graph.put(i, new Node(i + 1));
        }
    }

    public void addEdge(int source, int destination) {
        graph.get(source - 1).adjacent.add(graph.getOrDefault(destination - 1, new Node(destination - 1)));
    }

    public ArrayList<String> seach(int vertex) {
        t = 0;
        for (int i = 0; i < n; i++) {
            if (graph.get(i).TD == 0) {
                DFS(graph.get(i));
            }
        }

        return graph.get(vertex - 1).arestas;

    }

    private void DFS(Node node) {
        node.visited = true;
        t += 1;
        for (Node v : node.adjacent) {
            if (v.TD == 0 && v.TT==0) {
                v.father = node;
                v.TD = t;
                node.arestas.add(node.element + "->" + v.element + ":arvore");
                DFS(v);
            } else if (v.TT == 0) {
                node.arestas.add(node.element + "->" + v.element + ":retorno");
            } else {
                if (node.TD < v.TD) {
                    node.arestas.add(node.element + "->" + v.element + ":avanço");
                    ;// avanco
                } else {
                    node.arestas.add(node.element + "->" + v.element + ":cruzamento");
                    ;// cruz
                }
            }
        }
        t += 1;
        node.TT = t;
    }

}
