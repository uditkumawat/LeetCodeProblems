package code.microsoft;

/**
 * Time complexity : O(m)O(m). A total of mm nodes need to be traversed. Here, mm represents the minimum number of nodes from the two given trees.
 *
 * Space complexity : O(m)O(m). The depth of the recursion tree can go upto mm in the case of a skewed tree. In average case, depth will be O(logm)O(logm).
 */
public class MergeBinaryTrees {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String args[]){

        MergeBinaryTrees obj = new MergeBinaryTrees();

        TreeNode root1 = new TreeNode(6);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(9);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(1);

        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.right.right = new TreeNode(4);
        root2.right.left = new TreeNode(1);

        TreeNode res = obj.mergeTrees(root1,root2);

        obj.inorderTraversal(res);

    }

    public void inorderTraversal(TreeNode root){
        if(root==null){
            return;
        }
        inorderTraversal(root.left);
        System.out.println(root.val+" ");
        inorderTraversal(root.right);
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1==null){
            return root2;
        }
        if(root2==null){
            return root1;
        }

        root1.val+=root2.val;
        root1.left = mergeTrees(root1.left,root2.left);
        root1.right = mergeTrees(root1.right,root2.right);
        return root1;
    }
}
