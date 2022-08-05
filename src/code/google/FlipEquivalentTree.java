package code.google;

import code.facebook.TreeNode;

//https://www.youtube.com/watch?v=QrHTec92270
public class FlipEquivalentTree {

    public boolean flipEquivalent(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }

        if(root1==null || root2==null || root1.val!=root2.val){
            return false;
        }

        boolean f = flipEquivalent(root1.left,root2.left) &&
                flipEquivalent(root1.right,root2.right);

        boolean s = flipEquivalent(root1.left,root2.right) &&
                flipEquivalent(root1.right,root2.left);

        return f || s;
    }
}
