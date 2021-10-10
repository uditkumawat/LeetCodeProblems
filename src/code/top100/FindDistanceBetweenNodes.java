package code.top100;

public class FindDistanceBetweenNodes {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = LCA(root, p, q);
        return dist(lca, p, 0) + dist(lca, q, 0);
    }

    private int dist(TreeNode root, int target, int travel) {
        if(root == null) {
            return -1;
        }

        if(root.val == target) {
            return travel;
        }

        int travelLeft = dist(root.left, target, travel + 1);
        if(travelLeft == -1) {
            return dist(root.right, target, travel + 1);
        }

        return travelLeft;
    }

    private TreeNode LCA(TreeNode root, int p, int q) {
        if(root == null) {
            return null;
        }

        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);

        if(root.val == p || root.val == q || (left != null && right != null)) {
            return root;
        }

        return left != null ? left : right;
    }
}
