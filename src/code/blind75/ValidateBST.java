package code.blind75;

import code.facebook.TreeNode;

//https://leetcode.com/problems/validate-binary-search-tree/solution/
//TC - O(N)
//SC - O(N)
public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        return isValidBST(root,null,null);
    }

    public boolean isValidBST(TreeNode root,Integer lower,Integer upper){
        if(root==null){
            return true;
        }

        if((lower!=null && root.val<=lower) || (upper!=null && root.val>=upper)){
            return false;
        }

        return isValidBST(root.left,lower,root.val) && isValidBST(root.right,root.val,upper);
    }
}
