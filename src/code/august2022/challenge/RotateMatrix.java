package code.august2022.challenge;

//https://leetcode.com/problems/rotate-image/submissions/
//TC - O(M) - M is the number of cells in matrix

/**
 * We perform two steps; transposing the matrix, and then reversing each row. Transposing the matrix has a cost of \mathcal{O}(M)O(M) because we're moving the value of each cell once. Reversing each row also has a cost of \mathcal{O}(M)O(M), because again we're moving the value of each cell once.
 */
//SC - O(1)
public class RotateMatrix {

    public void rotate(int[][] matrix) {

        int n = matrix.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0;i<n;i++){
            reverse(matrix[i],0,n-1);
        }
    }

    public void reverse(int nums[],int left,int right){
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
