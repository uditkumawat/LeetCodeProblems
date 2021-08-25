package code.top100;

public class FirstLastElementPositionInSortedArray {

    public static void main(String args[]){

        int nums[] = {5,7,7,8,8,10};
        int target =9;
        int indxs[] = searchRange(nums,target);
        System.out.println(indxs[0]+" "+indxs[1]);
    }
    public static int[] searchRange(int[] nums, int target) {

        int indexes[] = new int[2];
        int firstIndex = firstSearch(nums,0,nums.length-1,target);
        int lastIndex = lastSearch(nums,0,nums.length-1,target);

        indexes[0] = firstIndex;
        indexes[1] = lastIndex;

        return indexes;
    }

    public static int firstSearch(int nums[],int low,int high,int target){
        if(low>high){
            return -1;
        }

        int mid = low+(high-low)/2;
        if(nums[mid]==target){
            if(mid==low || nums[mid-1]<target){
                return mid;
            }
            return firstSearch(nums,low,mid-1,target);
        }
        else if(nums[mid]>target){
            return firstSearch(nums,low,mid-1,target);
        }
        else{
            return firstSearch(nums,mid+1,high,target);
        }
    }


    public static int lastSearch(int nums[],int low,int high,int target){
        if(low>high){
            return -1;
        }
        int mid = low+(high-low)/2;
        if(nums[mid]==target){
            if(mid==high || nums[mid+1]>target){
                return mid;
            }
            return lastSearch(nums,mid+1,high,target);
        }
        else if(nums[mid]>target){
            return lastSearch(nums,low,mid-1,target);
        }
        else{
            return lastSearch(nums,mid+1,high,target);
        }
    }
}
