package code.tagged.facebook;

//https://leetcode.com/problems/kth-largest-element-in-an-array/
//TC - O(N)
//SC - O(1)
public class KthLargestElementInArray {

    int nums[];

    public static void main(String args[]){

        int nums[] = {3,2,1,5,6,4};
        int k = 2;

        KthLargestElementInArray obj = new KthLargestElementInArray();

        System.out.println(obj.findKthLargest(nums,k));

    }
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int size = nums.length;

        return quickSelect(0,size-1,size-k);
    }

    public int quickSelect(int left,int right,int k_smallest){

        //if list contains only one element
        if(left==right){
            return this.nums[left];
        }

        int pivotIndex = right;

        pivotIndex = partition(left,right,pivotIndex);

        if(k_smallest==pivotIndex){
            return this.nums[k_smallest];
        }
        else if(pivotIndex<k_smallest){
            return quickSelect(pivotIndex+1,right,k_smallest);
        }
        else{
            return quickSelect(left,pivotIndex-1,k_smallest);
        }
    }

    private void swap(int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public int partition(int left,int right,int pivotIndex){

        int pivot = this.nums[pivotIndex];

        //move pivot to end
        swap(right,pivotIndex);

        int storeIndex = left;

        for(int i=left;i<=right;i++){

            if(this.nums[i]<pivot){
                swap(storeIndex,i);
                storeIndex++;
            }
        }

        swap(storeIndex,right);

        return storeIndex;
    }
}
