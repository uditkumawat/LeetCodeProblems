package code.graph;

//https://leetcode.com/problems/number-of-provinces/solution/
//TC_O(n2)
//SC-O(N)
public class NumberOfProvinces {

    public int findCircleNum(int[][] connected) {

        if(connected==null){
            return 0;
        }

        int n = connected.length;
        int rows = connected.length;
        int cols = connected[0].length;

        int count = 0;

        int visited[] = new int[n];

        for(int i=0;i<connected.length;i++){
            if(visited[i]==0){
                dfs(connected,visited,i);
                visited[i]=1;
                count++;
            }
        }

        return count;
    }

    public void dfs(int connected[][],int visited[],int i){
        for(int j=0;j<connected[i].length;j++){
            if(connected[i][j]==1 && visited[j]==0){
                visited[j] = 1;
                dfs(connected,visited,j);
            }
        }

    }
}
