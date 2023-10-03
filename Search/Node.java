package Search;

import java.util.ArrayList;
import java.util.LinkedList;

public class Node {
     int element;
    boolean visited;
    int TD;
    int TT;
    Node father;
    LinkedList<Node> adjacent = new LinkedList<Node>();
    
    ArrayList<String> arestas =new ArrayList<String>();


    Node(int e){
        this.element = e;
        TD=0;
        TT=0;
        visited=false;
        father=null;
    }

    
}
