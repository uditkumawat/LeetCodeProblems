package code.explorecard.tree;

import code.facebook.TreeNode;

//https://leetcode.com/problems/symmetric-tree/solution/
//TC -O(N)
//SC - O(N)
public class SymmetricTree {

    public static void main(String args[]){

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        SymmetricTree obj = new SymmetricTree();

        System.out.println(obj.isSymmetric(root));
    }

    public boolean isSymmetric(TreeNode root){
        if(root==null){
            return true;
        }

        return isSymmetricUtil(root.left,root.right);
    }

    private boolean isSymmetricUtil(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return false;
        }

        return root1.val==root2.val && isSymmetricUtil(root1.left,root2.right) && isSymmetricUtil(root1.right,root2.left);
    }

    /**
     * public boolean isSymmetric(TreeNode root) {
     *     Queue<TreeNode> q = new LinkedList<>();
     *     q.add(root);
     *     q.add(root);
     *     while (!q.isEmpty()) {
     *         TreeNode t1 = q.poll();
     *         TreeNode t2 = q.poll();
     *         if (t1 == null && t2 == null) continue;
     *         if (t1 == null || t2 == null) return false;
     *         if (t1.val != t2.val) return false;
     *         q.add(t1.left);
     *         q.add(t2.right);
     *         q.add(t1.right);
     *         q.add(t2.left);
     *     }
     *     return true;
     * }
     */

}
