package code.salesforce;

//https://leetcode.com/problems/arranging-coins/submissions/
//TC - O(nlogn)
//sc - O(1)
public class ArrangeCoins {

    public int arrangeCoins(int n) {

        long left = 0, right = n, mid = 0 , sum = 0;

        while(left<=right){
            mid = left + (right-left)/2;

            sum = mid*(mid+1)/2;

            if(sum==n){
                return (int)mid;
            }

            if(sum<n){
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }

        return (int)right;
    }
}
