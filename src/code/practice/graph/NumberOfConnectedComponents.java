package code.practice.graph;

import java.util.HashSet;
import java.util.Set;

public class NumberOfConnectedComponents {

    static  int parent[];
    public static void main(String args[]){

        int edges[][] = {{0,1},{1,2},{3,4}};
        int n=4;

        System.out.println(countComponents(n,edges));
    }

    public static int countComponents(int n,int edges[][]){

        //initially all pointing to themselves initially
        parent = new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i] = i;
        }

        for(int i=0;i<edges.length;i++){
            union(edges[i][0],edges[i][1]);
        }

        Set<Integer> components = new HashSet<>();
        for(int i=0;i<=n;i++){
            components.add(find(i));
        }

        return components.size();
    }

    public static int find(int node){

        while(node!=parent[node]){
            node = parent[node];
        }

        return node;
    }

    public static void union(int a,int b){

        //if parent is same, then return as both are in same set or same parent
        if(find(a)==find(b)){
            return;
        }
        parent[a] = b;
    }
}
