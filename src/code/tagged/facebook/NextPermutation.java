package code.tagged.facebook;

//TC - O(N)
//SC - O(1)
//https://leetcode.com/problems/next-permutation/solution/
//https://leetcode.com/problems/next-permutation/discuss/13994/Readable-code-without-confusing-ij-and-with-explanation
public class NextPermutation {

    public static void main(String args[]){

        int nums[] = {1,2,3,2,1};

        NextPermutation obj = new NextPermutation();

        obj.nextPermutation(nums);

        for(int num:nums){
            System.out.print(num+" ");
        }
    }
    public void nextPermutation(int[] nums) {

        if(nums==null || nums.length==0){
            return;
        }

        int i= nums.length-2;

        while(i>=0 && nums[i]>=nums[i+1]){
            i--;
        }

        //sorted in descending order, so no permuatation
        if(i==0){
            return;
        }

        int j = nums.length-1;

        while(nums[j]<=nums[i]){
            j--;
        }

        swap(nums,i,j);

        reverse(nums,i+1,nums.length-1);
    }

    private void swap(int nums[],int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private void reverse(int nums[],int start,int end){
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
}
