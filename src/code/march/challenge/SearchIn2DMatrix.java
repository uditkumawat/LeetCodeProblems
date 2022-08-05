package code.march.challenge;

//https://leetcode.com/problems/search-a-2d-matrix/discuss/26220/Don't-treat-it-as-a-2D-matrix-just-treat-it-as-a-sorted-list
public class SearchIn2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix==null || matrix.length==0){
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int pivot = -1;
        int num = 0;

        int left = 0;
        int right = m*n-1;

        while(left<=right){

            pivot = left+(right-left)/2;

            num = matrix[pivot/n][pivot % n];

            if(target==num){
                return true;
            }
            else if(target<num){
                pivot--;
            }
            else{
                pivot++;
            }
        }

        return false;
    }
}
