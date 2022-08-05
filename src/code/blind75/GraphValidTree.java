package code.blind75;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/graph-valid-tree/
//TC - O(E+V)
//SC - O(E+V)
public class GraphValidTree {

    public boolean validTree(int n, int[][] edges) {

        Set<Integer> visited = new HashSet();

        List<List<Integer>> adjList = new ArrayList();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int edge[]:edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                if(!dfs(adjList,i,visited,-1)){
                    return false;
                }
            }
        }

        return visited.size()==n;
    }

    public boolean dfs(List<List<Integer>> adjList,int src,Set<Integer> visited,int parent){

        if(visited.contains(src)){
            return false;
        }

        visited.add(src);

        for(int neighbour:adjList.get(src)){
            if(neighbour==parent){
                continue;
            }

            if(visited.contains(neighbour)){
                return false;
            }
            else{
                if(!dfs(adjList,neighbour,visited,src)){
                    return false;
                }
            }
        }

        return true;
    }
}
