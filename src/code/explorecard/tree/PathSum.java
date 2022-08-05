package code.explorecard.tree;

import code.facebook.TreeNode;

public class PathSum {

    public static void main(String args[]){

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        PathSum obj = new PathSum();
        int targetSum = 19;
        System.out.println(obj.isPathSumExist(root,targetSum));
    }

    public boolean isPathSumExist(TreeNode root,int targetSum){

        if(root==null){
            return targetSum==0;
        }

        return isPathSumExist(root.left,targetSum-root.val) || isPathSumExist(root.right,targetSum-root.val);
    }


}
