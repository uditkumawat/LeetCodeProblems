package code.graph;

import java.util.List;

//https://leetcode.com/problems/keys-and-rooms/submissions/
//TC - O(N+E) N isnumber of rooms and E total number of keys
//SC - O(N) - additional space complexity for DFS recrusive
public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        int n = rooms.size();

        boolean visited[] = new boolean[n];

        dfs(rooms,0,visited);

        for(int i=0;i<visited.length;i++){
            if(visited[i]==false){
                return false;
            }
        }

        return true;
    }

    public void dfs(List<List<Integer>> rooms,int node,boolean visited[]){

        visited[node] = true;

        for(int neighbour : rooms.get(node)){
            if(visited[neighbour]==false){
                dfs(rooms,neighbour,visited);
            }
        }

    }
}
