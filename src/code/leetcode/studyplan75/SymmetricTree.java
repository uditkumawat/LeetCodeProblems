package code.leetcode.studyplan75;

import code.facebook.TreeNode;

//https://leetcode.com/problems/symmetric-tree/submissions/
//TC - O(N)
//SC - O(N)
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {

        if(root==null){
            return true;
        }

        return isSymmetricUtil(root,root);
    }


    public boolean isSymmetricUtil(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }

        if(root1==null || root2==null){
            return false;
        }

        return root1.val==root2.val && isSymmetricUtil(root1.left,root2.right) &&
                isSymmetricUtil(root1.right,root2.left);
    }
}
