package code.microsoft;

import code.facebook.TreeNode;

/**
 * Time Complexity: O(N)O(N) since we might end up encountering a skewed tree and in that case, we will just be discarding one node at a time. For a balanced binary-search tree, however, the time complexity will be O(\text{log}N)O(logN) which is what we usually find in practice.
 *
 * Space Complexity: O(1)O(1) since we don't use recursion or any other data structures for getting our successor.
 */
public class InorderSuccessorBST {

    TreeNode succ = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root==null){
            return null;
        }

        search(root,p);

        return succ;
    }

    public void search(TreeNode root,TreeNode p){
        if(root==null){
            return;
        }

        while(root!=null){

            if(root.val>p.val){
                succ = root;
                root = root.left;
            }
            else if(root.val<p.val){
                root = root.right;
            }
            else{
                break;
            }
        }

    }
}
