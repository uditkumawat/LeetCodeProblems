package code.cohesity;

import code.facebook.TreeNode;

//https://leetcode.com/problems/count-complete-tree-nodes/
//https://www.youtube.com/watch?v=IXOXGnTCEvM
//TC - O(logn)
//sc - O(logn)
public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {

        if(root==null){
            return 0;
        }

        TreeNode leftNode = root;
        TreeNode rightNode = root;
        int height = 0;

        while(leftNode!=null && rightNode!=null){
            height++;
            leftNode  = leftNode.left;
            rightNode  = rightNode.right;
        }

        return (leftNode==null && rightNode==null)?(int)Math.pow(2,height)-1:1+countNodes(root.left)+countNodes(root.right);
    }
}
