package code.facebook;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String args[]){

        TreeNode root = new  TreeNode(3);
        root.left = new  TreeNode(9);
        root.right = new  TreeNode(20);
        root.right.left = new  TreeNode(15);
        root.right.right = new  TreeNode(7);

        BinaryTreeInorderTraversal obj = new BinaryTreeInorderTraversal();

        List<Integer> list = obj.postOrderTraversal(root);

        for(int num:list){
            System.out.print(num+" ");
        }
    }
    
    public List<Integer> postOrderTraversal(TreeNode root){

        LinkedList<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null){
            return list;
        }

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.addFirst(node.val);
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }

        return list;
    }
}
