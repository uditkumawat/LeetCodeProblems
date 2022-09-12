package code.bloomberg;

import code.facebook.TreeNode;

//https://leetcode.com/submissions/detail/768081064/
//TC - O(N)
//SC - O(N)
public class CousinsOfBinaryTree {

    TreeNode xparent = null;
    TreeNode yparent = null;
    int xdepth = 0;
    int ydepth = 0;

    public boolean isCousins(TreeNode root, int x, int y) {

        getParentAndDepth(root,x,y,0,null);

        return xdepth==ydepth && xparent.val!=yparent.val;
    }

    public void getParentAndDepth(TreeNode root,int x,int y,int depth,TreeNode parent){
        if(root==null){
            return;
        }

        if(root.val==x){
            xparent = parent;
            xdepth = depth;
        }

        if(root.val==y){
            yparent = parent;
            ydepth = depth;
        }

        getParentAndDepth(root.left,x,y,depth+1,root);
        getParentAndDepth(root.right,x,y,depth+1,root);


    }
}
