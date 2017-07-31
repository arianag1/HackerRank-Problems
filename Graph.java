//Main Method
import java.io.*;
import java.util.*;

public class test{

    public static void main(String[] args) {
        //int [] dis;
        LinkedList<Integer> store = new LinkedList<Integer>();
        Graph graph;
        Scanner scan = new Scanner(System.in);
        //int queries = scan.nextInt();
        //for(int i = 1; i <= queries; i++){
            int n = scan.nextInt();
            int m = scan.nextInt();
            graph = new Graph(m);
            //dis = new int [n];
            for(int j = 1; j <= m; j++){
                int u = scan.nextInt();
                int v = scan.nextInt();
                graph.addEdge(u,v);
            }
            int startNode = scan.nextInt();
            graph.bfs(startNode, store);
            for(int nodes:store){
                    System.out.print(nodes + " ");
            }
            System.out.print("\n");
           
            //graph.clearGraph();
    //    }      
    }
}

//Graph Class
import java.util.*;

public class Graph{
    ArrayList<Edge> graph;
    public Graph(int size){
        graph = new ArrayList<Edge>(size);
    }
    public boolean addEdge(int u, int v){
        return graph.add(new Edge(u,v));
    }
    public void bfs(int startNode, LinkedList<Integer> queue){
        LinkedList<Integer> adj = new LinkedList<Integer>();

        adj.add(startNode);
        queue.add(startNode);
    
        while(!adj.isEmpty()){
            startNode = adj.remove();
           
            for(Edge edge:graph){
                if(edge.getFirst() == startNode){
                    int second = edge.getSecond();
                    if(!queue.contains(second)){
                        adj.add(second);
                        queue.add(second);
                    }
                }
                else if(edge.getSecond() == startNode){
                    int first = edge.getFirst();
                    if(!queue.contains(first)){
                        adj.add(first);
                        queue.add(first);
                    }
                }
            }
        }
    
    }
}

//EDGE CLASS
import java.util.*;


public class Edge{
  
  int u,v;

    public Edge(int u, int v){
 
       this.u = u;

       this.v = v;
 
   }
 
   public int getFirst(){
 
       return this.u;
   
   }
    
   public int getSecond(){
 
       return this.v;

    }

    public String toString(){
 
       return this.u + " " + this.v;
   
 }

}


