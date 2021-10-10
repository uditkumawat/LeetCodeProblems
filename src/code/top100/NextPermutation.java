package code.top100;

public class NextPermutation {

    public static void main(String args[]){
        int nums[] = {1,2,3,5,4,1};
        for(int num:nums){
            System.out.print(num+" ");
        }
        System.out.println();
        nextPermutation(nums);
        for(int num:nums){
            System.out.print(num+" ");
        }
    }
    public static void nextPermutation(int[] nums) {

        if(nums==null || nums.length==0 || nums.length==1){
            return;
        }

        int index = nums.length-1;

        while(index>0){
            if(nums[index-1]<nums[index]){
                break;
            }
            index--;
        }

        if(index==0){
            reverse(nums,0,nums.length-1);
            return;
        }

        int val = nums[index-1];
        int j = nums.length-1;
        while(j>=index){
            if(nums[j]>val){
                break;
            }
            j--;
        }
        swap(nums,j,index-1);
        reverse(nums,index, nums.length-1);
        return;
    }

    public static void swap(int nums[],int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void reverse(int nums[],int left,int right){
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
