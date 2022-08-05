package code.blind75;

import code.facebook.TreeNode;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/solution/
//TC - O(N)
//SC - O(N)
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }
}
