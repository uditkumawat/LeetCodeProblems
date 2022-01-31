package code.facebook;

public class WallsAndGates {

    public static void main(String args[]){

        int emptyRoom = Integer.MAX_VALUE-1;
        int wall = -1;
        int gate = 0;
        int rooms[][] = {{emptyRoom,wall,gate,emptyRoom},
                {emptyRoom,emptyRoom,emptyRoom,wall},
                {emptyRoom,wall,emptyRoom,wall},
                {gate,wall,emptyRoom,emptyRoom}
        };

        WallsAndGates obj = new WallsAndGates();
        obj.wallsAndGates(rooms);

        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[i].length;j++){
                System.out.print(rooms[i][j]+" ");
            }
            System.out.println();
        }

    }
    public void wallsAndGates(int[][] rooms) {

        if(rooms==null || rooms.length==0){
            return;
        }

        int rows = rooms.length;
        int cols = rooms[0].length;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(rooms[i][j]==0){
                    dfs(rooms,rows,cols,i,j,0);
                }
            }
        }
    }

    private void dfs(int rooms[][],int rows,int cols,int row,int col,int count){

        if(row>=rows || col>=cols || row<0 || col<0 || rooms[row][col]<count){
            return;
        }

        rooms[row][col] = count;

        dfs(rooms,rows,cols,row+1,col,count+1);
        dfs(rooms,rows,cols,row,col+1,count+1);
        dfs(rooms,rows,cols,row-1,col,count+1);
        dfs(rooms,rows,cols,row,col-1,count+1);
    }
}
