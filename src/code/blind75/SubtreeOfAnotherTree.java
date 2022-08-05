package code.blind75;

import code.facebook.TreeNode;

//https://leetcode.com/problems/subtree-of-another-tree/

/**
 * Time: O(M * N), where M is the number of nodes in binary tree root, N is the number of nodes in binary tree subRoot
 * Space: O(H), where H is the height of binary tree root
 */
public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null){
            return true;
        }
        if(root==null || subRoot==null){
            return false;
        }

        if(isSameTree(root,subRoot)){
            return true;
        }

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    public boolean isSameTree(TreeNode root,TreeNode subRoot){
        if(root==null && subRoot==null){
            return true;
        }
        if(root==null || subRoot==null){
            return false;
        }

        return root.val == subRoot.val && isSameTree(root.left,subRoot.left) && isSameTree(root.right,subRoot.right);
    }
}
