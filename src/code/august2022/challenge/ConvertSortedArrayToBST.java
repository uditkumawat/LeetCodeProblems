package code.august2022.challenge;

import code.facebook.TreeNode;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
//TC - O(N) - we visited each element once
//SC - O(logn) - recursion, tree is height balanced
public class ConvertSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {

        if(nums==null || nums.length==0){
            return null;
        }

        return sortedArrayToBST(nums,0,nums.length-1);
    }

    public TreeNode sortedArrayToBST(int nums[],int left,int right){
        if(left>right){
            return null;
        }

        int mid = left+(right-left)/2;

        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBST(nums,left,mid-1);
        root.right = sortedArrayToBST(nums,mid+1,right);

        return root;
    }
}
