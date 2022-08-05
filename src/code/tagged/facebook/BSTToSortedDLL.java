package code.tagged.facebook;

import code.facebook.TreeNode;

//https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/solution/
//TC - O(N)
//SC - O(N) recursive stack
public class BSTToSortedDLL {

    TreeNode last = null;
    TreeNode first = null;

    public static void main(String args[]){

        BSTToSortedDLL obj = new BSTToSortedDLL();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);

        TreeNode head = obj.treeToDoublyList(root);

        while(head!=null){
            System.out.println(head.val);
            head = head.right;
        }
    }
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root==null){
            return null;
        }

        helper(root);
        last.right = null;
        first.left = null;

        return first;
    }

    public void helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.left);
        if(last!=null){
            last.right = root;
            root.left = last;
        }
        else{
            first = root;
        }
        last = root;
        helper(root.right);
    }
}
