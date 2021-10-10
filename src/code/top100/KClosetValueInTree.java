package code.top100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given the root of a binary search tree, a target value, and an integer k, return the k values in the BST that are closest to the target. You may return the answer in any order.
 *
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 */
public class KClosetValueInTree {

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

    public List<Integer> closestKValues(TreeNode root, double target, int k) {

        List<Integer> nums = new ArrayList<>();
        inorder(root,nums);

        Collections.sort(nums,(a, b)->{ return Math.abs(a-target)>Math.abs(b-target)?-1:1;});

        return nums.subList(0,k);
    }

    public void inorder(TreeNode root,List<Integer> nums){
        if(root==null){
            return;
        }
        inorder(root.left,nums);
        nums.add(root.val);
        inorder(root.right,nums);
    }
}
