package code.explorecard.tree;

import code.facebook.TreeNode;

//https://leetcode.com/problems/inorder-successor-in-bst/solution/
//TC - O(N)
//sC - O(1)
public class InorderSuccessorBST {

    TreeNode successor;

    public static void main(String args[]){

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        InorderSuccessorBST obj = new InorderSuccessorBST();

        System.out.println(obj.inorderSuccessor(root,root.right).val);
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        successor = null;


        return findSuccessor(root,p);
    }

    public TreeNode findSuccessor(TreeNode root,TreeNode p){


        while(root!=null){
            if(p.val<root.val){
                successor = root;
                root = root.left;
            }
            else{
                root = root.right;
            }
        }

        return successor;
    }
}
