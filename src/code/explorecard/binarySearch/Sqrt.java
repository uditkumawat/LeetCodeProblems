package code.explorecard.binarySearch;

//https://leetcode.com/problems/sqrtx/solution/
//TC - O(logn)
//SC - O(1)
public class Sqrt {

    public static void main(String args[]){

        Sqrt obj = new Sqrt();

        System.out.println(obj.mySqrt(4));
        System.out.println(obj.mySqrt(8));

    }
    public int mySqrt(int x) {

        if(x<2){
            return x;
        }

        int left = 2;
        int right = x/2;

        while(left<=right){

            int mid = left+(right-left)/2;

            if(mid == x/mid){
                return mid;
            }
            else if(mid>x/mid){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        //Why right and not left? Because the loop is stopped when left > right, and at this moment right * right <= x < left * left.
        //Because, you want when you exit the while loop, you must have left > right, you want to return the smaller integer, which is right.
        return right;
    }
}
