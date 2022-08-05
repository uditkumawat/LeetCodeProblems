package code.blind75;

import code.facebook.TreeNode;

import java.util.Stack;

//https://leetcode.com/problems/kth-smallest-element-in-a-bst/solution/
/**
 * Time complexity: O(H + k)O(H+k), where HH is a tree height. This complexity is defined by the stack, which contains at least H + kH+k elements, since before starting to pop out one has to go down to a leaf. This results in O(\log N + k)O(logN+k) for the balanced tree and O(N + k)O(N+k) for completely unbalanced tree with all the nodes in the left subtree.
 * Space complexity: O(H)O(H) to keep the stack, where HH is a tree height. That makes O(N)O(N) in the worst case of the skewed tree, and O(\log N)O(logN) in the average case of the balanced tree.
 */
public class KthSmallestInBST {

    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();

        while(root!=null || !stack.isEmpty()){

            while(root!=null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            k--;
            if(k==0){
                return root.val;
            }

            root = root.right;

        }
        return 0;
    }
}
