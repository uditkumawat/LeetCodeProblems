package code.september2022.challenge;

import code.facebook.TreeNode;

//https://leetcode.com/problems/count-good-nodes-in-binary-tree/
//TC - O(N)
//SC - O(N) - recursion
public class CountGoodNodesInBinaryTree {

    int count = 0;

    public int goodNodes(TreeNode root) {

        if(root==null){
            return 0;
        }

        countGoodNodes(root,root.val);

        return count;
    }

    public void countGoodNodes(TreeNode root,int maxValue){

        if(root==null){
            return;
        }

        if(root.val>=maxValue){
            count++;
        }
        maxValue = Math.max(maxValue,root.val);
        countGoodNodes(root.left,maxValue);
        countGoodNodes(root.right,maxValue);

    }
}
