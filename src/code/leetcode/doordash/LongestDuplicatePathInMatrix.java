package code.leetcode.doordash;

public class LongestDuplicatePathInMatrix {

    private static int dirs[][] = {{1,0},{0,1},{-1,0},{0,-1}};
    public static void main(String args[]){

        int matrix[][] = {{1,1,2,1},{5,5,5,5},{5,5,5,1}};

        System.out.println(getMaxLength(matrix));
    }

    public static int getMaxLength(int matrix[][]){
        int rows = matrix.length;
        int cols = matrix[0].length;

        int maxLength = 0;

        boolean visited[][] = new boolean[rows][cols];
        int dp[][] = new int[rows][cols];

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                maxLength = Math.max(maxLength, dfs(matrix, row, col, rows, cols, matrix[row][col], visited));
                System.out.println(row+" "+col+" "+maxLength);
            }
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }


        return maxLength;
    }

    public static int dfs(int matrix[][],int row,int col,int rows,int cols,int targetNumber,boolean visited[][]){
        if(row<0 || row>=rows || col<0 || col>=cols || matrix[row][col]!=targetNumber || visited[row][col]){
            return 0;
        }

        int max = 0;
        visited[row][col] = true;

        for(int i=0;i<dirs.length;i++){
            int newRow = row+dirs[i][0];
            int newCol = col+dirs[i][1];
            max = Math.max(max,dfs(matrix,newRow,newCol,rows,cols,targetNumber,visited));
        }

        visited[row][col] = false;
        //System.out.println("Max for row and col "+row+" "+col+" "+(max+1));
        return ++max;
    }
}
