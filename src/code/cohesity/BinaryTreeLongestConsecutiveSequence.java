package code.cohesity;

import code.facebook.TreeNode;

//https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
//TC - O(N)
//SC - O(N)
public class BinaryTreeLongestConsecutiveSequence {

    int maxLen;
    public int longestConsecutive(TreeNode root) {

        maxLen = 0;
        int currentLen = 1;

        longestConsecutive(root,currentLen,null);

        return maxLen;
    }

    public void longestConsecutive(TreeNode root,int currentLen,TreeNode prev){
        if(root==null){
            return;
        }

        if(prev!=null && (root.val-prev.val==1)){
            currentLen++;
            maxLen = Math.max(maxLen,currentLen);
        }
        else{
            currentLen = 1;
        }
        longestConsecutive(root.left,currentLen,root);
        longestConsecutive(root.right,currentLen,root);

    }
}
