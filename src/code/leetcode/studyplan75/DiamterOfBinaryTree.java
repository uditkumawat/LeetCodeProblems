package code.leetcode.studyplan75;

import code.facebook.TreeNode;

//https://leetcode.com/problems/diameter-of-binary-tree/submissions/
//TC - O(N)
//SC - O(N)
public class DiamterOfBinaryTree {

    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {

        findDiameter(root);

        return diameter;
    }

    public int findDiameter(TreeNode root){
        if(root==null){
            return 0;
        }

        int left = findDiameter(root.left);
        int right = findDiameter(root.right);

        diameter = Math.max(diameter,left+right);

        return Math.max(left,right)+1;
    }
}
