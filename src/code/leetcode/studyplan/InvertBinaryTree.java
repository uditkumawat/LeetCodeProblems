package code.leetcode.studyplan;

import code.facebook.TreeNode;

//https://leetcode.com/problems/invert-binary-tree/submissions/
//TC - O(N)
//SC - O(N)
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {

        if(root==null){
            return null;
        }

        invertUtil(root);

        return root;
    }

    public void invertUtil(TreeNode root){
        if(root==null){
            return;
        }

        invertUtil(root.left);
        invertUtil(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
