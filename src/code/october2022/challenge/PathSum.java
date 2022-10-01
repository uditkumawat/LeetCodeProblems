package code.october2022.challenge;

import code.facebook.TreeNode;

//https://leetcode.com/problems/path-sum/solutions/
//TC - O(N)
//SC - O(N)
public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root==null){
            return false;
        }

        if(isLeaf(root) && targetSum==root.val){
            return true;
        }

        if(isLeaf(root) && targetSum!=root.val){
            return false;
        }

        return hasPathSum(root.left,targetSum-root.val) ||
                hasPathSum(root.right,targetSum-root.val);
    }

    public boolean isLeaf(TreeNode root){
        return root!=null && root.left==null && root.right==null;
    }
}
