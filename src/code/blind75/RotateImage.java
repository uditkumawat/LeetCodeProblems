package code.blind75;

//https://leetcode.com/problems/rotate-image/submissions/
//TC - O(n^2)
//SC - O(1)
public class RotateImage {

    public void rotate(int[][] matrix) {

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<i;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0;i<matrix.length;i++){
            reverse(matrix[i],0,matrix[i].length-1);
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
