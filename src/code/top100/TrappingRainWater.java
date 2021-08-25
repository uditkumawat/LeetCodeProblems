package code.top100;

//TC - O(N)
//SC - O(N)
public class TrappingRainWater {

    public static void main(String args[]){
        int arr[] = {4,2,0,3,2,5};

        System.out.println(trap(arr));
    }
    public static int trap(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int n = nums.length;

        int leftMax[] = new int[n];
        int rightMax[] = new int[n];

        leftMax[0] = nums[0];
        rightMax[n-1] = nums[n-1];

        for(int i=1;i<n;i++){
            leftMax[i] = Math.max(leftMax[i-1],nums[i]);
        }

        for(int i=n-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1],nums[i]);
        }

        int ans = 0;

        for(int i=1;i<n-1;i++){
            ans = ans + Math.min(leftMax[i],rightMax[i])-nums[i];
        }

        return ans;

    }
}
