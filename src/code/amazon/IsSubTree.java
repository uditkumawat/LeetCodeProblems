package code.amazon;

import code.facebook.TreeNode;

public class IsSubTree {

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
