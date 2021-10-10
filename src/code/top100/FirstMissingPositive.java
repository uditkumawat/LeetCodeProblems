package code.top100;

//https://www.youtube.com/watch?v=9SnkdYXNIzM
//https://leetcode.com/problems/first-missing-positive/discuss/17214/Java-simple-solution-with-documentation
public class FirstMissingPositive {

    public static void main(String args[]){
        int arr[]={3,4,-1,1};
        System.out.println(firstMissingPositive(arr));
    }
    public static int firstMissingPositive(int[] nums) {

        if(nums==null || nums.length==0){
            return 1;
        }

        int n = nums.length;
        int containsOne = 0;

        for(int i=0;i<n;i++){
            if(nums[i]==1){
                containsOne = 1;
            }
            else if(nums[i]<=0 || nums[i]>n){
                nums[i] = 1;
            }
        }

        if(containsOne==0){
            return 1;
        }

        for(int i=0;i<n;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index] = -1 * nums[index];
            }
        }

        for(int i=0;i<n;i++){
            if(nums[i]>0){
                return i+1;
            }
        }

        return n+1;
    }
}
