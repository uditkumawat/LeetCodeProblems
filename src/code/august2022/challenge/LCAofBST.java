package code.august2022.challenge;

import code.facebook.TreeNode;

//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/submissions/
//TC - O(N)
//SC - O(N) - for skewed tree
public class LCAofBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null){
            return null;
        }

        int pVal = p.val;
        int qVal = q.val;

        while(root!=null){
            int val = root.val;
            if(val>pVal && val>qVal){
                root = root.left;
            }
            else if(val<pVal && val<qVal){
                root = root.right;
            }
            else{
                return root;
            }
        }

        return null;
    }
}
