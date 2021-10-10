package code.top100;

import java.util.*;

/**
 * Let EE be the number of edges, and NN be the number of nodes.
 *
 * Time Complexity : O(N + E)O(N+E).
 *
 * Creating the adjacency list requires initialising a list of length NN, with a cost of O(N)O(N), and then iterating over and inserting EE edges, for a cost of O(E)O(E). This gives us O(E) + O(N) = O(N + E)O(E)+O(N)=O(N+E).
 *
 * Each node is added to the data structure once. This means that the outer loop will run NN times. For each of the NN nodes, its adjacent edges is iterated over once. In total, this means that all EE edges are iterated over once by the inner loop. This, therefore, gives a total time complexity of O(N + E)O(N+E).
 *
 * Because both parts are the same, we get a final time complexity of O(N + E)O(N+E).
 *
 * Space Complexity : O(N + E)O(N+E).
 *
 * The adjacency list is a list of length NN, with inner lists with lengths that add to a total of EE. This gives a total of O(N + E)O(N+E) space.
 *
 * In the worst case, the stack/ queue will have all NN nodes on it at the same time, giving a total of O(N)O(N) space.
 *
 * In total, this gives us O(E + N)O(E+N) space.
 */
public class GraphIsTree {

    public boolean validTree(int n, int[][] edges) {

        List<List<Integer>> adjList = new ArrayList<>(n);

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int edge[]:edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Map<Integer,Integer> parent = new HashMap<>();
        parent.put(0,-1);
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while(!stack.isEmpty()){
            int elem = stack.pop();

            for(int neighbour:adjList.get(elem)){

                if(parent.get(neighbour)==elem){
                    continue;
                }

                if(parent.containsKey(neighbour)){
                    return false;
                }

                stack.push(neighbour);
                parent.put(neighbour,elem);
            }
        }

        return parent.size()==n;
    }
}
