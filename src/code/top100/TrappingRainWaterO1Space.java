package code.top100;

//TC - O(N)
//SC - O(1)
public class TrappingRainWaterO1Space {

    public static void main(String args[]){
        int arr[] = {4,2,0,3,2,5};

        System.out.println(trap(arr));
    }
    public static int trap(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }

        int n = nums.length;

        int maxLeft = nums[0];
        int maxRight = nums[n-1];

        int ans = 0;
        int left = 1;
        int right = n-2;

        while(left<=right){
            if(maxLeft<maxRight){
                if(nums[left]>maxLeft){
                    maxLeft = nums[left];
                }
                else{
                    ans+=maxLeft-nums[left];
                }
                left++;
            }
            else{
                if(nums[right]>maxRight){
                    maxRight = nums[right];
                }
                else{
                    ans+=maxRight-nums[right];
                }
                right--;
            }
        }

        return ans;
    }
}
