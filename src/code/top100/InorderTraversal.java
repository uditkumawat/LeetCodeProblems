package code.top100;

import apple.laf.JRSUIUtils;

import java.util.Stack;

//TC - O(n)
//SC - O(n)
public class InorderTraversal {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val=val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

       // inorderRecursive(root);
        inorderTraversal(root);
    }

    public static void inorderRecursive(TreeNode root){
        if(root==null){
            return;
        }
        inorderRecursive(root.left);
        System.out.println(root.val);
        inorderRecursive(root.right);
    }

    public static void inorderTraversal(TreeNode root){
        if(root==null){
            return;
        }

        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        while(curr!=null || !stack.isEmpty()){
            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.println(curr.val);
            curr = curr.right;
        }
    }
}
