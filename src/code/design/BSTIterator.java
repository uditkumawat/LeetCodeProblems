package code.design;

import code.facebook.TreeNode;

import java.util.Stack;

public class BSTIterator {

    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        buildLeftMost(root);
    }

    public void buildLeftMost(TreeNode root){
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        if(node.right!=null){
            buildLeftMost(node.right);
        }
        return node.val;
    }

    public boolean hasNext() {
        return stack.isEmpty();
    }
}
