package code.facebook;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Time complexity : O(n). The preorder traversal is done over the nn nodes of the given Binary Tree.
 *
 * Space complexity : O(n). The depth of the recursion tree can go upto nn in case of a skewed tree.
 */
public class StringFromBinaryTree {

    public static void main(String args[]){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        StringFromBinaryTree obj = new StringFromBinaryTree();

        System.out.println(obj.tree2str(root));

    }
    public String tree2str(TreeNode root) {
        if(root==null){
            return "";
        }
        if(root.left==null && root.right==null){
            return root.val+"";
        }
        else if(root.right==null){
            return root.val+"("+tree2str(root.left)+")";
        }
        else{
            return root.val+"("+tree2str(root.left)+")("+tree2str(root.right)+")";
        }
    }


}
