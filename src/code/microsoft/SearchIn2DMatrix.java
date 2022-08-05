package code.microsoft;

//https://leetcode.com/problems/search-a-2d-matrix/solution/
//TC - O(log(mn))
public class SearchIn2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix==null){
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows*cols-1;

        while(left<=right){

            int mid = left+(right-left)/2;
            int elem = matrix[mid / cols][mid % cols];
            if(elem==target){
                return true;
            }
            else if(elem>target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }


        return false;
    }
}
