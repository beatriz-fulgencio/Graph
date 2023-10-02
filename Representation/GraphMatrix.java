package Representation;

public class GraphMatrix {
    private boolean[][] matrix;

    public GraphMatrix(int n) {
        matrix = new boolean[n][n];

        // Initialize
        for (int i = 0; i < matrix.length; i++) {
            for (int y = 0; y < matrix[i].length; y++) {
                matrix[i][y] = false;
            }
        }
    }

    public void addEdge(int source, int destination) {
        matrix[source - 1][destination - 1] = true;
    }

    public int getDegree(int v, boolean type) { // type =true -> successors ; type =false; predecessors
        int count = 0;
        if (type) {
            for (int y = 0; y < matrix[v].length; y++) {
                if (matrix[v][y])
                    count++;
            }
            return count;
        } else {
            for (int y = 0; y < matrix[v].length; y++) {
                if (matrix[y][v])
                    count++;
            }
            return count;
        }

    }

    

    public void GreatestOutDegree() {
        int res = 0;
        int resGraph = 0;

        for (int i = 0; i < matrix.length; i++) {
          int count =  getDegree(i, true);
            if (count > res) {
                res = count;
                resGraph = i;
            }
        }

        System.out.print("Greatest out-degree" + ":\n degree: " + res + "\n graph:" + (resGraph + 1) + ":");

        for (int i = 0; i < matrix[resGraph].length; i++) {
            if (matrix[resGraph][i])
                System.out.print(" -> " + (i + 1));
        }
        System.out.println();

    }

    public void GreatestInDegree() {
        int res = 0;
        int resGraph = 0;

        for (int i = 0; i < matrix[0].length; i++) {
            int count = getDegree(i, false);
            if (count > res) {
                res = count;
                resGraph = i;
            }
        }

        System.out.print("Greatest in-degree" + ":\n degree: " + res + "\n graph:" + (resGraph + 1) + ":");

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[i][resGraph])
                System.out.print(" -> " + (i + 1));
        }
        System.out.println();

    }
}
