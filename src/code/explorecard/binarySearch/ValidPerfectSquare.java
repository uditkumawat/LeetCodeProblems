package code.explorecard.binarySearch;

//https://leetcode.com/problems/valid-perfect-square/
//TC - O(logn)
public class ValidPerfectSquare {

    public static void main(String args[]){

        ValidPerfectSquare obj = new ValidPerfectSquare();

        System.out.println(obj.isPerfectSquare(14));
        System.out.println(obj.isPerfectSquare(16));

    }
    public boolean isPerfectSquare(int num) {

        int left = 1;
        int right = num/2;

        while(left<=right){
            int mid = left+(right-left)/2;
            int guess = mid*mid;
            if(guess==num){
                return true;
            }
            else if(guess>num){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        return false;
    }
}
