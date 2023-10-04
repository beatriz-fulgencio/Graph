package Search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int vertex;

        File file1 = new File("./graph-test-100-2.txt");
        File file2 = new File("./graph-test-50000-2.txt");

        System.out.println("Choose the sourse file:\n1: 100 vertexes\n2: 50000 vertexes");
        int type = Integer.parseInt(sc.nextLine());

        System.out.println("Digite o vértice que deseja buscar:");
        vertex = Integer.parseInt(sc.nextLine());

        sc.close();

        Scanner fileSc = new Scanner(type==1?file1:file2);
        int n = fileSc.nextInt();
        fileSc.nextLine();
        Graph graph = new Graph(n);

        while (fileSc.hasNextLine()) {
            int s = fileSc.nextInt();
            int d = fileSc.nextInt();

            graph.addEdge(s, d);
            fileSc.nextLine();
        }
        graph.sortNodes();
        Stack<String> arestas = graph.seach(vertex);
       for(int i=0;i<arestas.size();i++){
        System.out.println(arestas.get(i));
       }
       
       fileSc.close();

    }
}
