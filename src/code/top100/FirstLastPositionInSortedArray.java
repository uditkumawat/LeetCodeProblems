package code.top100;

public class FirstLastPositionInSortedArray {

    public static void main(String args[]){
        int nums[] = {5,7,7,8,8,10};
        int target = 8;

        int indexes[] = searchRange(nums,target);
        System.out.println(indexes[0]+" "+indexes[1]);
    }
    public static int[] searchRange(int[] nums, int target) {

        int arr[] = new int[2];

        if(nums==null || nums.length==0){
            arr[0] = -1;
            arr[1] = -1;
            return arr;
        }

        arr[0] = findFirstIndex(nums,target);
        arr[1] = findLastIndex(nums,target);

        return arr;
    }

    public static int findFirstIndex(int nums[],int target){

        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = left+(right-left)/2;
            System.out.println(left+" "+right+" "+mid);
            if((mid==0 || nums[mid-1]<target) && nums[mid]==target){
                return mid;
            }else if(nums[mid]>=target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return -1;
    }


    public static int findLastIndex(int nums[],int target){

        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = left+(right-left)/2;
            if((mid==nums.length-1 || nums[mid+1]>target) && nums[mid]==target){
                return mid;
            }else if(nums[mid]>=target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return -1;
    }
}
