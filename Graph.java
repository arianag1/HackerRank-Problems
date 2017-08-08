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


import java.util.*;

public class Graph{
    ArrayList<Edge> graph;
    public Graph(int size){
        this.graph = new ArrayList<Edge>(size);
    }
    public boolean addEdge(int u, int v){
        return this.graph.add(new Edge(u,v));
    }
    public void clearGraph(){
        this.graph.clear();
    }
    public void bfs(int startNode, LinkedList<Integer> queue){
        LinkedList<Integer> adj = new LinkedList<Integer>();

        adj.add(startNode);
        queue.add(startNode);
    
        while(!adj.isEmpty()){
            int tempNode = adj.remove();
           
            for(Edge edge:this.graph){
                if(edge.getFirst() == tempNode){
                    int second = edge.getSecond();
                    if(!queue.contains(second)){
                        adj.add(second);
                        queue.add(second);
                    }
                }
                else if(edge.getSecond() == tempNode){
                    int first = edge.getFirst();
                    if(!queue.contains(first)){
                        adj.add(first);
                        queue.add(first);
                    }
                }
            }
        }
    }
    public void bfsShortestDis(int startNode, int [] dis){
        LinkedList<Integer> adj = new LinkedList<Integer>();
        LinkedList<Integer> queue = new LinkedList<Integer>();
        adj.add(startNode);
        setTo(dis, -1);
        
        dis[startNode-1] = 0;
        
        while(!adj.isEmpty()){
            int tempNode = adj.remove();
            
            for(Edge edge:this.graph){
                if(edge.getFirst() == tempNode){
                    int second = edge.getSecond();
                    if(dis[second-1] == -1){
                        adj.add(second);
                        dis[second-1] = dis[tempNode-1] + 6;
                    }
                }
                else if(edge.getSecond() == tempNode){
                    int first = edge.getFirst();
                    if(dis[first-1] == -1){
                        adj.add(first);
                        dis[first-1] = dis[tempNode-1] + 6;
                    }
                }
            }
            
        }
    }
    public void dfs(int startNode, int length, LinkedList<Integer> list){
     Stack search = new Stack();
     
     boolean [] visited = new boolean [length + 1];
     setDFS(visited);
     
     search.push(startNode);
     list.add(startNode);
     
     while(!search.isEmpty()){
         int tempNode = search.pop();
         if(visited[tempNode] == false){
             visited[tempNode] = true;
             for(Edge edge : this.graph()){
                 if(edge.getFirst() == tempNode){
                     list.add(edge.getSecond());
                     search.push(edge.getSecond());
                     visited[edge.getSecond()] = true;
                }
                else if(edge.getSecond() == tempNode){
                     list.add(edge.getFirst());
                     search.push(edge.getFirst());
                     visited[edge.getFirst()] = true;
                 }
             }
         }
     }
      
   }
    private void setDFS(boolean [] store){
        for(int i = 0; i <= store.length; i++){
            store[i] = false;
        }
    }
    private void setTo(int [] distance, int value){
        for(int i = 0; i < distance.length; i++){
            distance[i] = value;
        }
    }
    
}
import java.io.*;
import java.util.*;

public class test{

    public static void main(String[] args) {
        int [] dis;
        LinkedList<Integer> store = new LinkedList<Integer>();
        Graph graph;
        Scanner scan = new Scanner(System.in);
        int queries = scan.nextInt();
        for(int i = 1; i <= queries; i++){
            int n = scan.nextInt();
            int m = scan.nextInt();
            graph = new Graph(m);
            dis = new int [n];
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
            graph.bfsShortestDis(startNode, dis);
            for(int num : dis){
                if(num != 0){
                  System.out.print(num + " ");   
                }
            }
            System.out.print("\n");
            graph.clearGraph();
        }
        scan.close();
    }
}
