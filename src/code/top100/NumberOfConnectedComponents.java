package code.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * EE = Number of edges, VV = Number of vertices.
 *
 * Time complexity: {O}(E + V)O(E+V).
 *
 * Building the adjacency list will take {O}(E)O(E) operations, as we iterate over the list of edges once, and insert each edge into two lists.
 *
 * During the DFS traversal, each vertex will only be visited once. This is because we mark each vertex as visited as soon as we see it, and then we only visit vertices that are not marked as visited. In addition, when we iterate over the edge list of each vertex, we look at each edge once. This has a total cost of {O}(E + V)O(E+V).
 *
 * Space complexity: {O}(E + V)O(E+V).
 *
 * Building the adjacency list will take {O}(E)O(E) space. To keep track of visited vertices, an array of size {O}(V)O(V) is required. Also, the run-time stack for DFS will use {O}(V)O(V) space.
 */
public class NumberOfConnectedComponents {

    public static void main(String args[]){
        int n = 5;
        int edges[][] = {{0,1},{1,2},{3,4}};
        System.out.println(countComponents(n,edges));
    }
    public static int countComponents(int n, int[][] edges) {
        if(n==0){
            return 0;
        }

        int visited[] = new int[n];

        int components = 0;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0;i<edges.length;i++){
            int source = edges[i][0];
            int dest = edges[i][1];
            List<Integer> list= new ArrayList<>();
            if(map.containsKey(source)){
                list = map.get(source);
            }
            list.add(dest);
            map.put(source,list);
        }

        for(int i=0;i<n;i++){
            if(visited[i]==0){
                components++;
                dfs(map,visited,i);
            }
        }

        return components;
    }

    public static void dfs(Map<Integer,List<Integer>> map,int visited[],int currNode){

        visited[currNode] = 1;

        if(map.containsKey(currNode)){
            List<Integer> neighbours = map.get(currNode);
            for(int neighbour:neighbours){
                if(visited[neighbour]==0){
                    dfs(map,visited,neighbour);
                }
            }
        }
    }
}
