package code.tagged.facebook;

import code.facebook.TreeNode;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
//TC - O(N)
//SC - O(N)
//https://www.youtube.com/watch?v=4laAl6_L144
public class LowestCommonAncestorOfBinaryTree {

    public static void main(String args[]){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        LowestCommonAncestorOfBinaryTree obj = new LowestCommonAncestorOfBinaryTree();

        System.out.println(obj.lowestCommonAncestor(root,root.left.left,root.left.right.left).val);

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null || root==p || root==q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left!=null && right!=null){
            return root;
        }

        if(left!=null){
            return left;
        }

        if(right!=null){
            return right;
        }

        return null;

    }
}
