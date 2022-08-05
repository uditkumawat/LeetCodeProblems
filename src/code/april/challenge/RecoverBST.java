package code.april.challenge;

import code.facebook.TreeNode;

//https://leetcode.com/problems/recover-binary-search-tree/solution/
//TC - O(N)
//SC - O(N)
public class RecoverBST {

    TreeNode prev;
    TreeNode first;
    TreeNode second;

    public static void main(String args[]){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);

        RecoverBST obj = new RecoverBST();
        System.out.println("Inorder print before recovering");
        obj.printInorder(root);
        obj.recoverTree(root);
        System.out.println("\nInorder print after recovering");
        obj.printInorder(root);
    }
    public void recoverTree(TreeNode root) {
        if(root==null){
            return;
        }

        inorder(root);

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    public void printInorder(TreeNode root){
        if(root==null){
            return;
        }
        printInorder(root.left);
        System.out.print(root.val+" ");
        printInorder(root.right);
    }

    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(prev!=null && prev.val>root.val){
            if(first==null){
                first = prev;
                second = root;
            }
            else{
                return;
            }
        }
        prev = root;
        inorder(root.right);
    }
}
