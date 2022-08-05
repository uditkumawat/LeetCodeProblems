package code.leetcode.studyplan75;

import code.facebook.TreeNode;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/submissions/
//TC - O(logn)
public class LCAOfBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        int pValue = p.val;
        int qValue = q.val;

        TreeNode node = root;

        while(node!=null){
            if(pValue>node.val && qValue>node.val){
                node = node.right;
            }
            else if(pValue<node.val && qValue<node.val){
                node = node.left;
            }
            else{
                return node;
            }
        }

        return null;
    }
}
