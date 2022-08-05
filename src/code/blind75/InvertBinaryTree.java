package code.blind75;

import code.facebook.TreeNode;

//https://leetcode.com/problems/invert-binary-tree/submissions/
//TC- O(n)
//SC - O(h)
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}
