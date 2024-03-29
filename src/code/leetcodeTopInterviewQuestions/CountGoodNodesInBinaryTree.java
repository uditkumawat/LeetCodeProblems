package code.leetcodeTopInterviewQuestions;

import code.facebook.TreeNode;

//https://leetcode.com/problems/count-good-nodes-in-binary-tree/solution/
//TC - O(N)
//SC - O(1)
public class CountGoodNodesInBinaryTree {

    private int numGoodNodes = 0;

    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return numGoodNodes;
    }

    private void dfs(TreeNode node, int maxSoFar) {
        if (maxSoFar <= node.val) {
            numGoodNodes++;
        }

        if (node.right != null) {
            dfs(node.right, Math.max(node.val, maxSoFar));
        }

        if (node.left != null) {
            dfs(node.left, Math.max(node.val, maxSoFar));
        }
    }
}
