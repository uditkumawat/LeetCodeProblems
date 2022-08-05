package code.may.challenge;

import code.facebook.TreeNode;

//https://leetcode.com/problems/deepest-leaves-sum/submissions/
public class DeepestLeavesSum {

    int sum;
    public int deepestLeavesSum(TreeNode root) {

        if(root==null){
            return 0;
        }
        sum = 0;
        int maxHeight = height(root);

        maxDepthLevelLeafSum(root,maxHeight,1);

        return sum;
    }

    public int height(TreeNode root){
        if(root==null){
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);

        return 1+Math.max(left,right);
    }

    public void maxDepthLevelLeafSum(TreeNode root,int maxHeight,int level){
        if(root==null){
            return;
        }


        if(root.left==null && root.right==null && level==maxHeight){
            sum = sum + root.val;
        }

        maxDepthLevelLeafSum(root.left,maxHeight,level+1);
        maxDepthLevelLeafSum(root.right,maxHeight,level+1);

    }
}
