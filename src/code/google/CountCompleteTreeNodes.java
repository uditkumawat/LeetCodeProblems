package code.google;

import code.facebook.TreeNode;

//https://leetcode.com/problems/count-complete-tree-nodes/
public class CountCompleteTreeNodes {

    public static void main(String args[]){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        CountCompleteTreeNodes obj = new CountCompleteTreeNodes();

        System.out.println(obj.count(root));

    }

    public int count(TreeNode root){
        if(root==null){
            return 0;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;
        int level = 1;

        while(left!=null && right!=null){
            level++;
            left = left.left;
            right = right.right;
        }

        return left==null && right==null ? (int)Math.pow(2,level)-1:
                1+count(root.left)+count(root.right);
    }
}
