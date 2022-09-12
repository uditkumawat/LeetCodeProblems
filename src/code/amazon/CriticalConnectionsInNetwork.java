package code.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInNetwork {

    int nextId = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<Integer>[] graph = new ArrayList[n];

        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<Integer>();
        }

        for(List<Integer> con:connections){
            graph[con.get(0)].add(con.get(1));
            graph[con.get(1)].add(con.get(0));
        }

        List<List<Integer>> ans = new ArrayList();

        boolean visited[] = new boolean[n];

        int lowestId[] = new int[n];

        tarjanAlgorithm(graph,-1,0,visited,ans,lowestId);

        return ans;
    }

    public void tarjanAlgorithm(List<Integer>[] graph,int parentId,int nodeId,boolean visited[],List<List<Integer>> ans,int lowestId[]){

        visited[nodeId] = true;

        lowestId[nodeId] = nextId;
        nextId++;

        int currentNodeLowestId = lowestId[nodeId];

        for(int neighbour:graph[nodeId]){

            if(neighbour==parentId){
                continue;
            }

            if(!visited[neighbour]){
                tarjanAlgorithm(graph,nodeId,neighbour,visited,ans,lowestId);
            }

            lowestId[nodeId] = Math.min(lowestId[nodeId],lowestId[neighbour]);

            if(currentNodeLowestId<lowestId[neighbour]){
                ans.add(Arrays.asList(nodeId,neighbour));
            }
        }
    }
}
