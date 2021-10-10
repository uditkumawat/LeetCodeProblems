package code.top100;

import apple.laf.JRSUIUtils;

import java.util.Stack;

/**
 * Time complexity: \mathcal{O}(H + k)O(H+k), where HH is a tree height. This complexity is defined by the stack, which contains at least H + kH+k elements, since before starting to pop out one has to go down to a leaf. This results in \mathcal{O}(\log N + k)O(logN+k) for the balanced tree and \mathcal{O}(N + k)O(N+k) for completely unbalanced tree with all the nodes in the left subtree.
 * Space complexity: \mathcal{O}(H)O(H) to keep the stack, where HH is a tree height. That makes \mathcal{O}(N)O(N) in the worst case of the skewed tree, and \mathcal{O}(\log N)O(logN) in the average case of the balanced tree.
 */
public class KthSmallestElementInBST {

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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        int k=4;
        findKthSmallest(root,k);
    }

    public static void findKthSmallest(TreeNode root,int k){
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
            if(--k==0){
                System.out.println(curr.val);
            }
            curr = curr.right;
        }
    }
}
