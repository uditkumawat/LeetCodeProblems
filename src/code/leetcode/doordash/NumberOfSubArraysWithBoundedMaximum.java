package code.leetcode.doordash;

//https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/discuss/1278743/C%2B%2BJavaPython-Easy-to-understand-solution-Clean-and-Concise-O(N)
//TC - O(n)
//SC-O(1)
public class NumberOfSubArraysWithBoundedMaximum {

    public static void main(String args[]){
        int arr[]= {2,1,4,3};
        int l = 2;
        int r = 3;
        System.out.println(count(arr,l,r));
    }

    public static int count(int arr[],int l,int r){

        return count(arr,r)-count(arr,l-1);
    }

    public static int count(int nums[],int bound){

        int ans = 0;
        for(int i=0;i<nums.length;){

            if(nums[i]>bound){
                i++;
                continue;
            }

            int count=0;
            while(i<nums.length && nums[i]<=bound){
                count++;
                i++;
            }

            ans+=(count*(count+1))/2;
        }

        return ans;
    }
}
