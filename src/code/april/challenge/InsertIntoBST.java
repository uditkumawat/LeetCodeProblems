package code.april.challenge;

import code.facebook.TreeNode;

//https://leetcode.com/problems/insert-into-a-binary-search-tree/
//O(H), where HH is a tree height. That results in \mathcal{O}(\log N)O(logN) in the average case, and \mathcal{O}(N)O(N) in the worst case.
public class InsertIntoBST {

    public TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode node = root;

        while(node!=null){
            if(val > node.val){
                if(node.right!=null){
                    node = node.right;
                }
                else{
                    node.right = new TreeNode(val);
                    return root;
                }
            }
            else{
                if(node.left!=null){
                    node = node.left;
                }
                else{
                    node.left = new TreeNode(val);
                    return root;
                }
            }
        }

        return new TreeNode(val);
    }
}
