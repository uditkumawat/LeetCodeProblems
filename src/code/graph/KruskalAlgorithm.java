package code.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class KruskalAlgorithm {

    class DisjointUnionFind{

        int n;
        int parent[];
        int rank[];
        DisjointUnionFind(int n){
            this.n = n;
            this.parent = new int[this.n];
            this.rank = new int[this.n];
            init();
        }

        public void init(){
            for(int i=0;i<n;i++){
                this.parent[i] = -1;
                this.rank[i] = 0;
            }
        }

        public int findParent(int node){
            if(parent[node]==-1){
                return node;
            }
            parent[node] = findParent(parent[node]);
            return parent[node];
        }

        public void union(int a,int b){
            int parentA = findParent(a);
            int parentB = findParent(b);

            if(rank[parentA]<rank[parentB]){
                parent[parentA] = parentB;
            }
            else if(rank[parentA]>rank[parentB]){
                parent[parentB] = parentA;
            }
            else{
                parent[parentB] = parentA;
                rank[parentA]++;
            }
        }
    }

    static class Edge{
        int weight;
        int start;
        int end;
        Edge(int start,int end,int weight){
            this.weight = weight;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String args[]){

        int n = 5;
        ArrayList<Edge> adj = new ArrayList<Edge>();

        adj.add(new Edge(0,1,2));
        adj.add(new Edge(0,3,6));
        adj.add(new Edge(1,3,8));
        adj.add(new Edge(1,2,3));
        adj.add(new Edge(1,4,5));
        adj.add(new Edge(2,4,7));

        KruskalAlgorithm obj = new KruskalAlgorithm();
        obj.kruskalAlgo(adj,n);
    }

    public void kruskalAlgo(ArrayList<Edge> adj,int n){

        PriorityQueue<Edge> pq = new PriorityQueue<>((Edge e1,Edge e2)->{
            return e1.weight-e2.weight;
        });

        for(Edge edge:adj){
            pq.add(edge);
        }

        DisjointUnionFind duf = new DisjointUnionFind(n);

        while(!pq.isEmpty()){
            Edge edge = pq.poll();

            int node1 = edge.start;
            int node2 = edge.end;

            System.out.println(node1+" "+node2);
            if(duf.findParent(node1)!=duf.findParent(node2)){
                System.out.println("Edge -> " + node1 + " " + node2+" "+edge.weight);
                duf.union(node1,node2);
            }
        }
    }
}
