package code.top100;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://www.youtube.com/watch?v=LhXPvhrhcIk&list=PLDdcY4olLQk1-yJxgljSQ4ykbI2Bw1CqS&index=13
//TC - O(N)
//SC - O(N)
public class DiagnolTraverseOfTree {

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
          TreeNode root = new   TreeNode(1);
        root.left = new   TreeNode(2);
        root.right = new   TreeNode(3);
        root.left.left = new   TreeNode(4);
        root.left.right = new   TreeNode(5);
        root.right.left = new   TreeNode(6);
        root.right.right = new   TreeNode(7);

        diagnolTraverse(root);

    }
    
    public static void diagnolTraverse(TreeNode root){
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            while (temp != null) {
                if (temp.left != null) {
                    q.add(temp.left);
                }
                System.out.println(temp.val);
                temp = temp.right;
            }
        }
    }
}
