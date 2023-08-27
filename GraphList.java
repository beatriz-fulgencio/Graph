//implementation based on video: https://www.youtube.com/watch?v=UhFfdBdHCJM

import java.util.ArrayList;

public class GraphList {
    private ArrayList<ArrayList<Integer>> graph;
    private int n; // number of nodes

    public GraphList(int n) {
        this.n = n;
        graph = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<Integer>());
        }
    }

    public void addEdge(int source, int destination) {
        graph.get(source - 1).add(destination);
    }

    public void printGraph() {
        for (int i = 0; i < n; i++) {
            System.out.print(i + 1 + ":");
            for (int x : graph.get(i)) {
                System.out.print(" -> " + x);
            }
            System.out.println();
        }
    }

    public void GreatestDegree(String type) {
        int res = 0;
        int resGraph = 0;

        for (ArrayList<Integer> gr : graph) {
            if (gr.size() > res) {
                res = gr.size();
                resGraph = graph.indexOf(gr);
            }
        }

        System.out.print(type + ":\n degree: " + res + "\n graph:" +( resGraph+1)+":");
        for (int x : graph.get(resGraph)) {
            System.out.print(" -> " + x);
        }
        System.out.println();
    }

}
