package code.explorecard.tree;

import code.facebook.TreeNode;

public class CountUniValueSubTrees {

    int res;
    public int countUnivalSubtrees(TreeNode root) {
        res = 0;
        countUtil(root);
        return res;
    }

    public boolean countUtil(TreeNode root){
        if(root==null){
            return true;
        }

        boolean left = countUtil(root.left);
        boolean right = countUtil(root.right);
        if(left && right){
            if((root.left!=null && root.val==root.left.val) && (root.right!=null && root.val==root.right.val))
                res++;
            return true;
        }
        return false;
    }
}
