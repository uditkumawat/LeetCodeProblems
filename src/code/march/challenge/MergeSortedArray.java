package code.march.challenge;

//https://leetcode.com/problems/merge-sorted-array/
//TC- O(m+n)
//SC- O(1)
public class MergeSortedArray {

    public static void main(String args[]){

        int nums1[] = {1,2,3,0,0,0};
        int nums2[] = {2,5,6};

        MergeSortedArray obj = new MergeSortedArray();

        obj.merge(nums1,3,nums2,nums2.length);

        for(int num:nums1){
            System.out.print(num+" ");
        }

    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p = nums1.length-1;
        int p1 = m-1;
        int p2 = n-1;

        while(p1>=0 && p2>=0){

            if(nums1[p1]>nums2[p2]){
                nums1[p] = nums1[p1];
                p1--;
            }
            else{
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        while(p1>=0){
            nums1[p] = nums1[p1];
            p1--;
            p--;
        }

        while(p2>=0){
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }

    }
}
