package code.tagged.facebook;

//https://leetcode.com/problems/merge-sorted-array/solution/
//TC - O(m+n)
//SC - O(1)
public class MergeSortedArray {

    public static void main(String args[]){

        MergeSortedArray obj = new MergeSortedArray();
        int nums1[] = {1,0,0,0,0};
        int m =1;
        int nums2[] = {1,2,9,4};
        int n = 4;
        obj.merge(nums1,m,nums2,n);

        for(int num:nums1){
            System.out.print(num+" ");
        }
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m-1;
        int j = n-1;
        int k = nums1.length-1;

        while(i>=0 && j>=0){

            if(nums1[i]>nums2[j]){
                nums1[k--] = nums1[i--];
            }
            else{
                nums1[k--] = nums2[j--];
            }
        }


        while(j>=0) {

            nums1[k--] = nums2[j--];
        }
    }
}
