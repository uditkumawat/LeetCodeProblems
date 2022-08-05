package code.leetcode.studyplan;

import code.facebook.TreeNode;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/
//TC - O(N)
//SC - O(N)
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {

        if(root==null){
            return 0;
        }

        return maxDepthUtil(root);
    }

    public int maxDepthUtil(TreeNode root){
        if(root==null){
            return 0;
        }

        int left = maxDepthUtil(root.left);
        int right = maxDepthUtil(root.right);

        return 1+Math.max(left,right);
    }
}
