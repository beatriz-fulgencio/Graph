package Representation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        try {
            File file1 = new File("graph-test-100-2.txt");
            File file2 = new File("graph-test-50000-2.txt");

            Scanner scn = new Scanner(System.in);
            System.out.println("Choose the sourse file:\n1: 100 vertexes\n2: 50000 vertexes");
            int type = scn.nextInt();

            System.out
                    .println("Choose the type of representation of the graph:\n1: Adjacency List\n2: Adjacency Matrix");
            int typeCode = scn.nextInt();

            scn.close();
            Scanner sc;

            if (type == 1) {
                sc = new Scanner(file1);
            } else if (type == 2) {
                sc = new Scanner(file2);
            } else {
                throw new Exception("No such type");
            }

            // change the file from 1 to 2 to change the source file
            if (typeCode == 1) {
                int n = sc.nextInt();
                sc.nextLine();

                GraphList graphsucc = new GraphList(n);
                GraphList graphpred = new GraphList(n);

                while (sc.hasNextLine()) {
                    int s = sc.nextInt();
                    int d = sc.nextInt();

                    graphsucc.addEdge(s, d);
                    graphpred.addEdge(d, s);
                    sc.nextLine();
                }
                sc.close();

                graphsucc.GreatestDegree("Greatest out-degree");
                graphpred.GreatestDegree("Greatest in-degree");
            } else if (typeCode == 2) {
                int n = sc.nextInt();
                sc.nextLine();

                GraphMatrix graph = new GraphMatrix(n);

                while (sc.hasNextLine()) {
                    int s = sc.nextInt();
                    int d = sc.nextInt();

                    graph.addEdge(s, d);
                    sc.nextLine();
                }
                sc.close();

                graph.GreatestOutDegree();
                graph.GreatestInDegree();
            } else {
                sc.close();

                throw new Exception("No such type");

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
