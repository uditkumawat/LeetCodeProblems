package code.microsoft;

import code.facebook.ShuffleString;

import java.util.ArrayList;
import java.util.List;

public class FindCenterInGraph {

    public static void main(String args[]){
        FindCenterInGraph obj = new FindCenterInGraph();

        int edges[][] = {{1,2},{5,1},{1,3},{1,4}};

        System.out.println(obj.findCenter(edges));
    }

    public int findCenter(int[][] edges) {

        if(edges==null || edges.length==0){
            return 0;
        }

        int n = edges.length;

        List<List<Integer>> adjList = new ArrayList<>(n+2);

        for(int i=0;i<n+2;i++){
            adjList.add(new ArrayList<>());
        }

        for(int edge[]:edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        for(int i=0;i<adjList.size();i++){
            if(adjList.get(i).size()==n){
                return i;
            }
        }

        return -1;
    }
}
