package code.top100;

import java.util.List;

public class MergeTwoSortedArrays {

    public static void main(String args[]){

        int nums1[] = {1,3,4,0,0,0};
        int nums2[] = {2,5,6};
        merge(nums1,3,nums2,3);
        for(int n:nums1){
            System.out.print(n+" ");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;

        int p = m+n-1;

        while(p2>=0){
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
    }
}
