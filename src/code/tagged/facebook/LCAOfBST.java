package code.tagged.facebook;

import code.facebook.TreeNode;

/**
 * Time Complexity: O(N)O(N), where NN is the number of nodes in the BST. In the worst case we might be visiting all the nodes of the BST.
 *
 * Space Complexity: O(N)O(N). This is because the maximum amount of space utilized by the recursion stack would be NN since the height of a skewed BST could be NN.
 */
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/solution/
public class LCAOfBST {

    public TreeNode lowestCommonAncestorRecursive(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return root;
        }

        if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestorRecursive(root.right,p,q);
        }
        else if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestorRecursive(root.left,p,q);
        }
        else{
            return root;
        }
    }

    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {

        // Value of p
        int pVal = p.val;

        // Value of q;
        int qVal = q.val;

        // Start from the root node of the tree
        TreeNode node = root;

        // Traverse the tree
        while (node != null) {

            // Value of ancestor/parent node.
            int parentVal = node.val;

            if (pVal > parentVal && qVal > parentVal) {
                // If both p and q are greater than parent
                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {
                // If both p and q are lesser than parent
                node = node.left;
            } else {
                // We have found the split point, i.e. the LCA node.
                return node;
            }
        }
        return null;
    }
}
