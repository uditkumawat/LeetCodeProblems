package code.practice.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ValidTree {

    public boolean validTree(int n, int[][] edges) {

        List<List<Integer>> adjList = new ArrayList<>(n+1);
        Set<Integer> seen = new HashSet<>();

        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int edge[]:edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        return dfs(0,-1,seen,adjList) && seen.size()==n;

    }

    public boolean dfs(int node,int parent,Set<Integer> seen,List<List<Integer>> adjList){

        if(seen.contains(node)){
            return false;
        }

        seen.add(node);

        for(int neighbour:adjList.get(node)){
            if(parent!=neighbour){
                if(!dfs(neighbour,node,seen,adjList)){
                    return false;
                }
            }
        }

        return true;
    }
}
