package code.top100;

import java.util.ArrayList;
import java.util.List;

//TC - O(v+e)
public class CycleDetectionInUnDirectedGraph {

    public static void main(String args[]){

        int edges[][] ={{0,1},{1,2},{1,0}};
        int n = 3;

        System.out.println(cycleExist(edges,n));
    }

    public static boolean cycleExist(int edges[][],int n){

        boolean cycleExist = false;
        List<List<Integer>> adjList = new ArrayList(n);
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int source = edges[i][0];
            int destination = edges[i][1];
            adjList.get(source).add(destination);
        }

        //0 - not processed
        //1 - processing going on
        //2 - processed
        int visited[] = new int[n];

        for(int i=0;i<n;i++){
            if(visited[i]==0){
                if(dfs(adjList,visited,n,i)){
                    cycleExist = true;
                    break;
                }
            }
        }
        return cycleExist;
    }

    public static boolean dfs(List<List<Integer>> adjList,int visited[],int n,int currNode){

        if(visited[currNode]==1){
            return true;
        }

        visited[currNode] = 1;

        for(int neighbour:adjList.get(currNode)){
            if(visited[neighbour]!=2){
                if(dfs(adjList,visited,n,neighbour)){
                    return true;
                }
            }
        }

        visited[currNode] = 2;

        return false;
    }
}
