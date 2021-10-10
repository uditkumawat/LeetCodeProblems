package code.top100;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingSubsequenceLogn {

    public static void main(String args[]){
        int arr[]={10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(arr));
    }

    public static int lengthOfLIS(int[] nums) {

        ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);

        for(int i=1;i<nums.length;i++){
            int num = nums[i];
            if(num>sub.get(sub.size()-1)){
                sub.add(num);
            }
            else{
                int j = binarySearch(sub,num);
                sub.set(j,num);
            }
        }

        return sub.size();
    }

    public static int binarySearch(List<Integer> sub, int num){
        int left = 0;
        int right = sub.size()-1;
        int mid = 0;
        int res = 0;
        while(left<right){
            mid = left+(right-left)/2;
            if(sub.get(mid)==num){
                return mid;
            }else if(sub.get(mid)>num){
                right = mid-1;
            }
            else{
                res = mid;
                left = mid+1;
            }
        }
        return res;
    }
}
