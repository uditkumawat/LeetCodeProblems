package code.leetcode.studyplan;

import code.facebook.TreeNode;

///https://leetcode.com/problems/validate-binary-search-tree/solution/
//TC-O(N)
//SC-O(N)
//followed bst property
public class ValidateBST {

    TreeNode prev;
    public boolean isValidBST(TreeNode root) {

        prev = null;
        if(root==null){
            return true;
        }

        return isValidBSTUtil(root);
    }

    public boolean isValidBSTUtil(TreeNode root){
        if(root==null){
            return true;
        }

        if(!isValidBSTUtil(root.left)){
            return false;
        }
        if(prev!=null && prev.val>=root.val){
            return false;
        }
        prev = root;

        if(!isValidBSTUtil(root.right)){
            return false;
        }

        return true;

    }
}
