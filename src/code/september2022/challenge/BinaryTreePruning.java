package code.september2022.challenge;

import code.facebook.TreeNode;

public class BinaryTreePruning {

    public TreeNode pruneTree(TreeNode root) {

        if(root==null){
            return null;
        }

        int val = dfs(root);

        return val==0?null:root;
    }

    public int dfs(TreeNode root){
        if(root==null){
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        if(left==0){
            root.left = null;
        }
        if(right==0){
            root.right = null;
        }

        return root.val+left+right;
    }
}
