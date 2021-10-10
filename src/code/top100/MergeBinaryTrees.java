package code.top100;

/**
 * Time complexity : O(m)O(m). A total of mm nodes need to be traversed. Here, mm represents the minimum number of nodes from the two given trees.
 *
 * Space complexity : O(m)O(m). The depth of the recursion tree can go upto mm in the case of a skewed tree. In average case, depth will be O(logm)O(logm)
 */
public class MergeBinaryTrees {

    /*
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }
        root1.val = root1.val+root2.val;
        root1.left = mergeTrees(root1.left,root2.left);
        root1.right = mergeTrees(root1.right,root2.right);
        return root1;
    }*/
}
