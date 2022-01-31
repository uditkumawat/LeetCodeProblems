package code.facebook;

/**
 * Time Complexity: O(N)O(N), where NN is the number of nodes in the binary tree. In the worst case we might be visiting all the nodes of the binary tree.
 *
 * Space Complexity: O(N)O(N). This is because the maximum amount of space utilized by the recursion stack would be NN since the height of a skewed binary tree could be NN.
 */
public class LCA {

    TreeNode ansNode;

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        LCA obj = new LCA();

        TreeNode node = obj.lowestCommonAncestor(root,root.left.left,root.left.right);

        System.out.println(node.val);

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ansNode = null;

        helper(root,p,q);

        return ansNode;
    }

    public boolean helper(TreeNode root,TreeNode p,TreeNode q){
        if(root==null){
            return false;
        }

        int left = helper(root.left,p,q)?1:0;
        int right = helper(root.right,p,q)?1:0;

        int mid = (root==p || root==q)?1:0;

        if(mid+left+right>=2){
            ansNode = root;
        }

        return (mid+left+right>0);
    }
}
