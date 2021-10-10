package code.top100;

import java.util.List;

public class SortedArrayToBST {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String args[]){

        int nums[] = {-10,-3,0,5,9};

        TreeNode root = sortedArrayToBST(nums);

        inorder(root);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {

        TreeNode root = convert(nums,0,nums.length-1);

        return root;
    }

    public static TreeNode convert(int nums[],int low,int high){
        if(low>high){
            return null;
        }
        int mid = low+(high-low)/2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = convert(nums,low,mid-1);
        root.right = convert(nums,mid+1,high);
        return root;
    }

    public static void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
}
