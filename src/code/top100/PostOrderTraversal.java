package code.top100;

import java.util.Stack;

public class PostOrderTraversal {

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


        postorder(root);

    }

    public static void postorder(TreeNode root){

        if(root==null){
            return;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        s1.push(root);

        while(!s1.isEmpty()){
            TreeNode node = s1.pop();
            if(node.left!=null){
                s1.push(node.left);
            }
            if(node.right!=null){
                s1.push(node.right);
            }

            s2.push(node);
        }

        while(!s2.isEmpty()){
            System.out.println(s2.pop().val);
        }
    }
}
