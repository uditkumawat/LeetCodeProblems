package code.leetcode.studyplan75;

import code.facebook.TreeNode;

//https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
/**
 * Time complexity: O(N) since we visit each node exactly once.
 *
 * Space complexity: O(N) to keep the output, and O(logN) for the recursion stack.
 */
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
