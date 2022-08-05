package code.april.challenge;

import code.facebook.TreeNode;

public class KthSmallestElementInBST {

    private int num;
    private int k;
    public static void main(String args[]){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(4);

        KthSmallestElementInBST obj = new KthSmallestElementInBST();
        obj.k = 1;
        obj.kthSmallest(root);


        System.out.print(obj.num);
    }
    public int kthSmallest(TreeNode root) {

        num = 0;
        if(root==null){
            return 0;
        }

        inorder(root);

        return num;
    }

    public void inorder(TreeNode root){

        if(root==null){
            return;
        }

        inorder(root.left);
        k--;
        if(k==0){
            num = root.val;
        }
        inorder(root.right);
    }
}
