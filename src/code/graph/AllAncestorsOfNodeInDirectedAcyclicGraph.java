package code.graph;

import java.util.*;

//https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/
public class AllAncestorsOfNodeInDirectedAcyclicGraph {

    public static void main(String args[]){

        int n = 8;
        int edges[][] = {{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}};

        AllAncestorsOfNodeInDirectedAcyclicGraph obj = new AllAncestorsOfNodeInDirectedAcyclicGraph();

        List<List<Integer>> res = obj.getAncestors(n,edges);

        for(List<Integer> list:res){
            System.out.print(list);
        }
    }
    public List<List<Integer>> getAncestors(int n, int[][] edges) {

        List<List<Integer>> res = new ArrayList<>();

        Map<Integer,Set<Integer>> map = new HashMap();

        for(int edge[]:edges){
            int src = edge[0];
            int dest = edge[1];

            map.putIfAbsent(dest,new TreeSet<>());
            //reversing the direction of edges
            map.get(dest).add(src);
        }


        for(int i=0;i<n;i++){
            Set<Integer> temp = new TreeSet<>();
            boolean visited[] = new boolean[n];
            dfs(map,i,temp,visited);

            res.add(new ArrayList<>(temp));
        }

        return res;
    }

    public void dfs(Map<Integer,Set<Integer>> map,int node,Set<Integer> list,boolean visited[]){

        visited[node] = true;

        if(map.containsKey(node)){
            for(int neighbour:map.get(node)){
                if(!visited[neighbour]){
                    list.add(neighbour);
                    dfs(map,neighbour,list,visited);
                }
            }
        }
    }
}
