package code.top100;

//TC - O(M*N)
public class LongestIncreasingPathInMatrix {

    static int dirs[][] = {{0,-1},{-1,0},{0,1},{1,0}};

    public static void main(String args[]){
        int matrix[][] = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(longestPath(matrix));
    }
    public static int longestPath(int matrix[][]){

        if(matrix==null || matrix.length==0){
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int longestPath = 0;
        int cache[][] = new int[rows][cols];

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                int path = dfs(matrix,row,col,rows,cols,cache);
                longestPath = Math.max(longestPath,path);
            }
        }

        return longestPath;
    }

    public static int dfs(int matrix[][],int row,int col,int rows,int cols,int cache[][]){
        if(cache[row][col]!=0){
            return cache[row][col];
        }
        int max = 0;
        for(int i=0;i<dirs.length;i++){

            int newRow = dirs[i][0]+row;
            int newCol = dirs[i][1]+col;

            if(newRow<rows && newRow>=0 && newCol<cols && newCol>=0 &&
            matrix[newRow][newCol]>matrix[row][col]){
                int path = dfs(matrix,newRow,newCol,rows,cols,cache);
                max = Math.max(max,path);
            }
        }

        cache[row][col] = max+1;

        return cache[row][col];

    }
}
