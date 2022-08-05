package code.june.challenge;

//https://leetcode.com/problems/merge-sorted-array/submissions/
//TC - O(m+n)
//SC - O(1)
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        if(nums1==null || nums1.length==0){
            return;
        }

        if(nums2==null || nums2.length==0){
            return;
        }

        int k = m+n-1;
        m--;
        n--;

        while(k>=0){

            if(n<0){
                break;
            }

            if(m>=0 && nums1[m]>nums2[n]){
                nums1[k] = nums1[m--];
            }
            else{
                nums1[k] = nums2[n--];
            }
            k--;
        }
    }
}
