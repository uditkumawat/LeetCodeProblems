package code.leetcode.studyplan;

//https://www.youtube.com/watch?v=EwggFsMTxu8
//TC - O(logn)
//SC - O(1)
public class FirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {

        int ans[] = new int[2];

        if(nums==null || nums.length==0){
            return new int[]{-1,-1};
        }

        int firstIndex = getFirstPosition(nums,target);

        if(firstIndex==-1){
            return new int[]{-1,-1};
        }

        int secondIndex = getLastPosition(nums,target);

        ans[0] = firstIndex;
        ans[1] = secondIndex;

        return ans;
    }

    public int getFirstPosition(int nums[],int target){
        if(nums==null || nums.length==0){
            return -1;
        }

        int left = 0;
        int right = nums.length-1;
        int firstIndex = -1;

        while(left<=right){
            int mid = left+(right-left)/2;

            if(nums[mid]>=target){
                if(nums[mid]==target){
                    firstIndex = mid;
                }
                right = mid-1;
            }
            else{
                left = mid+1;
            }

        }

        return firstIndex;
    }

    public int getLastPosition(int nums[],int target){
        if(nums==null || nums.length==0){
            return -1;
        }

        int left = 0;
        int right = nums.length-1;
        int lastIndex = -1;

        while(left<=right){
            int mid = left+(right-left)/2;

            if(nums[mid]<=target){
                if(nums[mid]==target){
                    lastIndex = mid;
                }
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }

        return lastIndex;
    }
}
