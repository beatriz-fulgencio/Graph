package Search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Stack;

public class Node {
     int element;
    boolean visited;
    int TD;
    int TT;
    Node father;
    ArrayList<Node> adjacent = new ArrayList<Node>();
    
    Stack<String> arestas =new Stack<String>();


    Node(int e){
        this.element = e;
        TD=0;
        TT=0;
        visited=false;
        father=null;
    }
    
    public void sortAdjacent(){
       adjacent.sort(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            if (o1.element ==o2.element ) return 0;
            if(o1.element > o2.element ) return 1;
            return -1;
        }
       });
    }
}
