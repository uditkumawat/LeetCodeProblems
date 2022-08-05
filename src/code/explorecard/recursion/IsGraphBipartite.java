package code.explorecard.recursion;

import java.util.Arrays;

//https://leetcode.com/problems/is-graph-bipartite/solution/
//https://www.youtube.com/watch?v=LBgVHZb07dc
/**
 * Time Complexity: O(N + E)O(N+E), where NN is the number of nodes in the graph, and EE is the number of edges. We explore each node once when we transform it from uncolored to colored, traversing all its edges in the process.
 *
 * Space Complexity: O(N)O(N), the space used to store the color.
 */
public class IsGraphBipartite {

    public static void main(String args[]){

        int graph[][] = {{1,3},{0,2},{1,3},{0,2}};

        IsGraphBipartite obj = new IsGraphBipartite();

        System.out.println(obj.isBipartite(graph));
    }
    public boolean isBipartite(int[][] graph) {

        int len = graph.length;

        int colors[] = new int[len];

        Arrays.fill(colors,-1);

        for(int i=0;i<len;i++){
            if(colors[i]==-1){
                if(!dfs(i,graph,colors,0)){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean dfs(int index,int graph[][],int colors[],int color){

        colors[index] = color;

        for(int neighbour:graph[index]){
            if(colors[neighbour]==-1){
                if(!dfs(neighbour,graph,colors,1-color)){
                    return false;
                }
            }
            else if(colors[neighbour]==colors[index]){
                return false;
            }
        }

        return true;
    }
}
