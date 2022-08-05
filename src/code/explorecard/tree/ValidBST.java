package code.explorecard.tree;

import code.facebook.TreeNode;

//TC-O(N)
//SC-O(N)

public class ValidBST {

    public boolean isValidBST(TreeNode root) {

        return isValidUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    public boolean isValidUtil(TreeNode root,int minValue,int maxValue){
        if(root==null){
            return true;
        }

        if(minValue<root.val && root.val<maxValue){
            return isValidUtil(root.left,minValue,root.val) && isValidUtil(root.right,root.val,maxValue);
        }
        else{
            return false;
        }
    }
}
