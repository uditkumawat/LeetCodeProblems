package code.leetcode.doordash;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

//TC - O(N*M)
//SC - O(min(N,M))
public class DiagnolOrder {

    public static void main(String args[]){
        int arr[][] = {{1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20}};

        int nums[] = findDiagonalOrder(arr);

        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
    }
    public static int[] findDiagonalOrder(int[][] mat) {

        if(mat==null || mat.length==0){
            return new int[0];
        }

        List<Integer> intermediateList = new ArrayList<>();

        int N = mat.length;
        int M = mat[0].length;

        int res[] = new int[N*M];
        int k=0;

        // We have to go over all the elements in the first
        // row and the last column to cover all possible diagonals
        for(int d=0;d<N+M-1;d++){

            intermediateList.clear();

            int row = d<M ? 0:d-M+1;
            int col = d<M ? d:M-1;

            // We need to figure out the "head" of this diagonal
            // The elements in the first row and the last column
            // are the respective heads.
            while(row<N && col>-1){
                intermediateList.add(mat[row][col]);
                row++;
                col--;
            }

            //reverse the even numbered diagnol

            if(d%2==0){
                Collections.reverse(intermediateList);
            }

            for(int i=0;i<intermediateList.size();i++){
                res[k++] = intermediateList.get(i);
            }
        }

        return res;
    }
}
