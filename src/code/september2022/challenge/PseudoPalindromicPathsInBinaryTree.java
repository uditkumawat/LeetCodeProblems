package code.september2022.challenge;

import code.facebook.TreeNode;

//https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/submissions/
//TC - O(N) - since one has to visit each node, check if at most one digit has an odd frequency.
//SC - O(H) - to keep the recursion stack, where H is a tree height.
public class PseudoPalindromicPathsInBinaryTree {

    int count = 0;

    public int pseudoPalindromicPaths (TreeNode root) {

        preorder(root,0);
        return count;
    }

    public void preorder(TreeNode root,int path){
        if(root==null){
            return;
        }

        // compute occurences of each digit
        // in the corresponding register
        path = path ^ (1 << root.val);  // XOR with bit on that root.val position
        if(root.left==null && root.right==null){
            // check if at most one digit has an odd frequency
            if((path & (path-1)) == 0){
                count++;
            }
        }

        preorder(root.left,path);
        preorder(root.right,path);
    }
}
