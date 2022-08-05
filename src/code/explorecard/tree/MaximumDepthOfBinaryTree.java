package code.explorecard.tree;

import code.facebook.TreeNode;

//https://leetcode.com/problems/maximum-depth-of-binary-tree/solution/
//TC - O(N)
//SC - O(N) - recursive stack
public class MaximumDepthOfBinaryTree {

    public static void main(String args[]){

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        MaximumDepthOfBinaryTree obj = new MaximumDepthOfBinaryTree();

        System.out.println(obj.maximumDepth(root));
    }

    public int maximumDepth(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftDepth = maximumDepth(root.left);
        int rightDepth = maximumDepth(root.right);

        return Math.max(leftDepth,rightDepth)+1;
    }
}
