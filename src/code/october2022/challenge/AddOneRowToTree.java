package code.october2022.challenge;

import code.facebook.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/add-one-row-to-tree/submissions/815365423/
//TC - O(N)
//SC - O(N)
public class AddOneRowToTree {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if(root==null){
            return null;
        }

        if(depth==1){
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        int level = 1;

        while(!q.isEmpty()){
            int size = q.size();

            while(size-->0){

                TreeNode node = q.remove();
                if(level==depth-1){
                    TreeNode temp = node.left;
                    TreeNode newNodeLeft = new TreeNode(val);
                    node.left = newNodeLeft;
                    newNodeLeft.left = temp;

                    temp = node.right;
                    TreeNode newNodeRight = new TreeNode(val);
                    node.right = newNodeRight;
                    newNodeRight.right = temp;
                }

                if(node.left!=null){
                    q.add(node.left);
                }

                if(node.right!=null){
                    q.add(node.right);
                }
            }

            level++;
        }

        return root;
    }
}
