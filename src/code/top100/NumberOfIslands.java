package code.top100;

//TC - O(M*N)
//SC - O(M*N) because of DFS  .... worst case O(M \times N)O(M×N) in case that the grid map is filled with lands where DFS goes by M \times NM×N deep.
public class NumberOfIslands {

    public static void main(String args[]){

        String grid[][] = {
                {"1","1","0","0","0"},
                {"1","1","0","0","0"},
                {"0","0","1","0","0"},
                {"0","0","0","1","1"}
        };

        System.out.println(numIslands(grid));
    }

        public static int numIslands(String[][] grid) {

            if(grid == null || grid.length == 0){
                return 0;
            }

            int trows = grid.length;
            int tcols = grid[0].length;

            int count = 0;
            for(int i=0;i<trows;i++){
                for(int j=0;j<tcols;j++){
                    if(grid[i][j]=="1"){
                        count++;
                        dfs(grid,i,j);
                    }
                }
            }

            return count;
        }

        public static void dfs(String grid[][],int row,int col){

            if(row<0 || row>=grid.length || col<0 || col>=grid[0].length || grid[row][col]!="1"){
                return;
            }

            grid[row][col] = "0";

            dfs(grid,row,col-1);

            dfs(grid,row-1,col);

            dfs(grid,row,col+1);

            dfs(grid,row+1,col);

        }
}
