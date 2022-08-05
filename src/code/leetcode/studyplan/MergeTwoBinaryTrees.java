package code.leetcode.studyplan;

import code.facebook.TreeNode;

//https://leetcode.com/problems/merge-two-binary-trees/submissions/
//TC -O(m+n)
//SC - O(m+n)
public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null && root2==null){
            return null;
        }

        if(root1==null && root2!=null){
            return root2;
        }


        if(root1!=null && root2==null){
            return root1;
        }

        TreeNode newNode = new TreeNode(root1.val+root2.val);
        newNode.left = mergeTrees(root1.left,root2.left);
        newNode.right = mergeTrees(root1.right,root2.right);

        return newNode;
    }
}
