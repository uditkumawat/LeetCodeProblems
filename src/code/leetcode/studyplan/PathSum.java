package code.leetcode.studyplan;

import code.facebook.TreeNode;

//https://leetcode.com/problems/path-sum/
//TC-O(N)
//sc-o(N)
public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root==null){
            return false;
        }

        targetSum-=root.val;
        if(root.left==null && root.right==null){
            return targetSum==0;
        }

        return hasPathSum(root.left,targetSum) || hasPathSum(root.right,targetSum);
    }
}
