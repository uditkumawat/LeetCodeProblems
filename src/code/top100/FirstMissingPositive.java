package code.top100;

public class FirstMissingPositive {

    public static void main(String args[]){
        int arr[]={3,4,-1,1};
        System.out.println(firstMissingPositive(arr));
    }
    public static int firstMissingPositive(int[] nums) {

        int n = nums.length;

        int i=0;
        while(i<nums.length){

            if(nums[i]==i+1 || nums[i]<=0 || nums[i]>nums.length){
                i++;
            }
            else if(nums[nums[i]-1]!=nums[i]){
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
            else{
                i++;
            }
        }

        i=0;
        while(i<nums.length && nums[i]==i+1){
            i++;
        }

        return i+1;
    }
}
