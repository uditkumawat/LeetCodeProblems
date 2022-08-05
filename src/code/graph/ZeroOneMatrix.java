package code.graph;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/01-matrix/solution
//TC - O(m*n)
public class ZeroOneMatrix {

    public static void main(String args[]){

        int matrix[][] = {{0,0,0},{0,1,0},{1,1,1}};

        ZeroOneMatrix obj = new ZeroOneMatrix();

        matrix = obj.updateMatrix(matrix);

        obj.printMatrix(matrix);
    }

    public void printMatrix(int matrix[][]){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public int[][] updateMatrix(int[][] mat) {

        if(mat==null){
            return new int[0][0];
        }

        int rows = mat.length;
        int cols = mat[0].length;

        int res[][] = new int[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                res[i][j] = Integer.MAX_VALUE;
            }
        }

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){

                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                    res[i][j] = 0;   // distance to 0 from 0 is considered 0
                }
            }
        }

        int directions[][] = {{ -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 }};

        while(!q.isEmpty()){

                int cell[] = q.remove();
                int row = cell[0];
                int col = cell[1];

                for(int j=0;j<directions.length;j++) {
                    int newRow = row + directions[j][0];
                    int newCol = col + directions[j][1];

                    if (newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols) {
                        if (res[newRow][newCol] > res[row][col] + 1) {
                            res[newRow][newCol] = res[row][col] + 1;
                            q.add(new int[]{newRow, newCol});
                        }
                    }
                }
        }

        return res;
    }
}
