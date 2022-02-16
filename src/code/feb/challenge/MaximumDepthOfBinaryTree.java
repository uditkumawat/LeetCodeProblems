package code.feb.challenge;

import code.facebook.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//https://www.youtube.com/watch?v=iR1ALIdIu1M
//https://leetcode.com/problems/maximum-depth-of-binary-tree/
//TC - O(V+E)
public class MaximumDepthOfBinaryTree {

    public static void main(String args[]){

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaximumDepthOfBinaryTree obj = new MaximumDepthOfBinaryTree();

        System.out.println(obj.getMaxDepthBFS(root));

        root = new TreeNode(1);
        root.right = new TreeNode(2);

        System.out.println(obj.getMaxDepth(root));

    }
    public int maxDepth(TreeNode root) {

        if(root==null){
            return 0;
        }

        return getMaxDepth(root);
    }

    public int getMaxDepth(TreeNode root){
        if(root==null){
            return 0;
        }

        int left = getMaxDepth(root.left);
        int right = getMaxDepth(root.right);

        return Math.max(left,right)+1;
    }

    public int getMaxDepthBFS(TreeNode root){
        if(root==null){
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();
            level++;
            while(size-->0){
                TreeNode temp = q.poll();
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
        }

        return level;
    }
}
