package code.top100;

public class FriendCircles {

    public static void main(String args[]){

        int isConnected[][] = {{1,0,0},{0,1,0},{0,0,1}};

        System.out.println(findCircleNum(isConnected));
    }
    public static int findCircleNum(int[][] isConnected) {

        if(isConnected==null || isConnected.length==0){
            return 0;
        }

        int rows = isConnected.length;
        int cols = isConnected[0].length;

        boolean visited[][] = new boolean[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                visited[i][j] = false;
            }
        }

        int count = 0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(isConnected[i][j]==1 && visited[i][j]==false){
                    count++;
                    dfs(isConnected,i,j,rows,cols,visited);
                }
            }
        }

        return count;
    }

    public static void dfs(int isConnected[][],int row,int col,int rows,int cols,boolean visited[][]){
        if(row<0 || col<0 || row>=rows || col>=cols || visited[row][col]==true || isConnected[row][col]==0){
            return;
        }

        visited[row][col] = true;

        dfs(isConnected,row,col-1,rows,cols,visited);
        dfs(isConnected,row-1,col,rows,cols,visited);
        dfs(isConnected,row,col+1,rows,cols,visited);
        dfs(isConnected,row+1,col,rows,cols,visited);

    }
}
