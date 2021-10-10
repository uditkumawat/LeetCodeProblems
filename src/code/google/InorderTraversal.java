package code.google;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//TC - O(n)
//SC - O(n)
public class InorderTraversal {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        InorderTraversal obj = new InorderTraversal();

        List<Integer> list = obj.inorderTraversal(root);

        for(int num:list){
            System.out.print(num+" ");
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list;
    }

    public void inorder(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr!=null || !stack.isEmpty()){

            while(curr!=null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;

        }
    }
}
