package code.leetcode.studyplan75;

import code.facebook.TreeNode;

import java.util.Stack;

//https://leetcode.com/problems/binary-search-tree-iterator/submissions/
//TC - O(N)
//SC - O(H)
public class BSTIterator {

    public TreeNode root;
    public Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.root = root;
        this.stack = new Stack<>();
    }

    public int next() {

        while(this.root!=null){
            stack.push(this.root);
            this.root = this.root.left;
        }
        TreeNode node = stack.pop();
        int val = node.val;

        this.root = node.right;
        return val;
    }

    public boolean hasNext() {
        return this.root!=null || !this.stack.isEmpty();
    }
}
