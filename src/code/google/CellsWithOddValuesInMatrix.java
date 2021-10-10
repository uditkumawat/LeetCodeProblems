package code.google;

/**
 * https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
 *
 * There is an m x n matrix that is initialized to all 0's. There is also a 2D array indices where each indices[i] = [ri, ci] represents a 0-indexed location to perform some increment operations on the matrix.
 *
 * For each location indices[i], do both of the following:
 *
 * Increment all the cells on row ri.
 * Increment all the cells on column ci.
 * Given m, n, and indices, return the number of odd-valued cells in the matrix after applying the increment to all locations in indices.
 *
 */

public class CellsWithOddValuesInMatrix {

    public static void main(String args[]){

        int m = 2;
        int n = 3;
        int indices[][] = {{0,1},{1,1}};
        CellsWithOddValuesInMatrix obj = new CellsWithOddValuesInMatrix();

        System.out.println(obj.oddCells(m,n,indices));
    }

    public int oddCells(int m, int n, int[][] indices) {

        int rows[] = new int[m];
        int cols[] = new int[n];

        for(int indice[]:indices){
            rows[indice[0]]++;
            cols[indice[1]]++;
        }

        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((rows[i]+cols[j])%2==1){
                    count++;
                }
            }
        }

        return count;
    }
}
