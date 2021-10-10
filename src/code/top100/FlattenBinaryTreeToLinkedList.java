package code.top100;

import java.util.Stack;

//https://www.youtube.com/watch?v=vssbwPkarPQ
public class FlattenBinaryTreeToLinkedList {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){

        }
        TreeNode(int val){
            this.val = val;
        }
    }
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode currNode = stack.pop();

            if(currNode.right!=null){
                stack.push(currNode.right);
            }

            if(currNode.left!=null){
                stack.push(currNode.left);
            }

            if(!stack.isEmpty())
                currNode.right = stack.peek();

            currNode.left = null;
        }

        return;
    }
}
