package code.blind75;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/solution/

/**
 * Here EE = Number of edges, VV = Number of vertices.
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
public class NumberOfConnectedComponentInUndirectedGraph {

    public int countComponents(int n, int[][] edges) {

        int count = 0;

        List<List<Integer>> adjList = new ArrayList();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<Integer>());
        }

        for(int edge[]:edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }


        boolean visited[] = new boolean[n];

        for(int i=0;i<n;i++){
            if(visited[i]==false){
                dfs(adjList,i,visited);
                count++;
            }
        }

        return count;
    }

    public void dfs(List<List<Integer>> adjList,int src,boolean visited[]){

        visited[src] = true;

        for(int neighbour:adjList.get(src)){
            if(visited[neighbour]==false){
                dfs(adjList,neighbour,visited);
            }
        }
    }
}
