package code.april.challenge;

import code.facebook.TreeNode;

import java.util.Stack;

//https://leetcode.com/problems/binary-search-tree-iterator/solution/
//TC - O(N)
//SC -O(H)
public class BSTIterator {

    public static void main(String args[]){

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator obj = new BSTIterator(root);

        System.out.println(obj.next());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
        System.out.println(obj.next());
        System.out.println(obj.hasNext());
    }
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        updateStack(root);
    }

    public void updateStack(TreeNode root){
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        int num = -1;

        if(hasNext()){
            TreeNode node = stack.pop();
            num = node.val;

            updateStack(node.right);
        }

        return num;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
