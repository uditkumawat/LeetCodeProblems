package code.leetcodeTopInterviewQuestions;

import code.facebook.TreeNode;

import java.util.LinkedList;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/solution/
public class KthSmallestElementInBST {

    public int kthSmallest(TreeNode root, int k) {
        LinkedList<TreeNode> stack = new LinkedList<>();

        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }
}
