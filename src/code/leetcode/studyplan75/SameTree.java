package code.leetcode.studyplan75;

import code.facebook.TreeNode;

//https://leetcode.com/problems/same-tree/solution/
//TC - O(N)
//SC - O(N)
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }

        if(p==null || q==null){
            return false;
        }

        return p.val==q.val && isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
    }
}
