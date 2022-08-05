package code.april.challenge;

import code.facebook.TreeNode;

//https://leetcode.com/problems/increasing-order-search-tree/solution/
/**
 * Time Complexity: O(N)O(N), where NN is the number of nodes in the given tree.
 *
 * Space Complexity: O(H)O(H) in additional space complexity, where HH is the height of the given tree, and the size of the implicit call stack in our in-order traversal.
 */
public class IncreasingOrderSearchTree {

    TreeNode prev;
    TreeNode head;

    public static void main(String args[]){

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        IncreasingOrderSearchTree obj = new IncreasingOrderSearchTree();

        root = obj.increasingBST(root);

        while(root!=null){
            System.out.print(root.val+" ");
            root = root.right;
        }

    }
    public TreeNode increasingBST(TreeNode root) {

        if(root==null){
            return root;
        }

        inorder(root);

        return head;
    }

    public void inorder(TreeNode root){

        if(root==null){
            return;
        }

        inorder(root.left);
        if(head==null){
            head = root;
        }
        if(prev!=null){
            prev.right = root;
            root.left = null;
        }
        prev = root;
        inorder(root.right);
    }
}
