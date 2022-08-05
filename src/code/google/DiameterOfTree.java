package code.google;

import code.facebook.TreeNode;

public class DiameterOfTree {

    public int diameter = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {

        if(root==null){
            return 0;
        }

        findDiameter(root);

        return diameter;
    }

    public int findDiameter(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftHeight = findDiameter(root.left);
        int rightHeight = findDiameter(root.right);

        diameter = Math.max(diameter,leftHeight+rightHeight+1);

        return 1+Math.max(leftHeight,rightHeight);
    }
}
