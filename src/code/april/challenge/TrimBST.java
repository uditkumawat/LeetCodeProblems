package code.april.challenge;

import code.facebook.TreeNode;

//https://leetcode.com/problems/trim-a-binary-search-tree/
//TC - O(N)
//SC - O(N) - recursive stack
//postorder traversal
//https://leetcode.com/problems/trim-a-binary-search-tree/discuss/1046690/Java-new-beginner-friendly-postorder-solution-that-avoids-unnecessary-function-calls-6-lines
public class TrimBST {

    public static void main(String args[]){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);

        TrimBST obj = new TrimBST();
        obj.inorder(root);

        root = obj.trimBST(root,1,2);

        System.out.println("\nAfter trimmming");
        obj.inorder(root);

        root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);

        System.out.println("\nNew tree");
        obj.inorder(root);

        root = obj.trimBST(root,1,3);
        System.out.println("\nAfter trimmming");
        obj.inorder(root);
    }

    private void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    public TreeNode trimBST(TreeNode root, int low, int high) {

        if(root==null){
            return root;
        }

        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);

        if(root.val<low){
            return root.right;
        }
        else if(root.val>high){
            return root.left;
        }
        else{
            return root;
        }
    }
}
