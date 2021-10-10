package code.top100;

//https://www.youtube.com/watch?v=OINnBJTRrMU&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=17
public class PeakElement {

    public static void main(String args[]){
        int nums[]={1,2,1,3,5,6,4};

        System.out.println(findPeakElement(nums));

    }
    public static int findPeakElement(int[] nums) {

        return helper(nums,0,nums.length-1);
    }

    public static int helper(int nums[],int low,int high){
        if(low==high){
            return low;
        }
        if(low+1==high){
            if(nums[low]>nums[high]){
                return high;
            }
            else{
                return low;
            }
        }

        int mid = low+(high-low)/2;
        if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]){
            return mid;
        }
        else if(nums[mid-1]>nums[mid] && nums[mid]>nums[mid+1]){
            return helper(nums,low,mid-1);
        }
        else{
            return helper(nums,mid+1,high);
        }
    }
}
