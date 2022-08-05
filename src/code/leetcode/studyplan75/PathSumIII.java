package code.leetcode.studyplan75;

import code.facebook.TreeNode;

//https://leetcode.com/problems/path-sum-iii/
//TC - O(n^2)
//SC - O(logn) - heihgt of tree
public class PathSumIII {

    private int ans = 0;
    public int pathSum(TreeNode root, int targetSum) {

        if(root==null){
            return 0;
        }
        helper(root,targetSum);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return ans;
    }

    public void helper(TreeNode node,int targetSum){
        if(node==null){
            return;
        }
        if(node.val==targetSum){
            ans++;
        }
        targetSum = targetSum - node.val;
        helper(node.left,targetSum);
        helper(node.right,targetSum);
    }
}
