package code.top100;

/**
 * Time complexity: \mathcal{O}(N)O(N), where N is number of nodes, since we visit each node not more than 2 times.
 *
 * Space complexity: \mathcal{O}(H)O(H), where HH is a tree height, to keep the recursion stack. In the average case of balanced tree, the tree height H = \log NH=logN, in the worst case of skewed tree, H = NH=N.
 */
public class BinaryTreeMaxixumSumPath {

    static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }

    static int ans = Integer.MIN_VALUE;

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        System.out.print(maxPathSum(root));
    }
    public static int maxPathSum(TreeNode root) {

        maxGain(root);
        return ans;
    }

    public static int maxGain(TreeNode root){
        if(root==null){
            return 0;
        }

        int leftMaxPathSum = Math.max(maxGain(root.left),0);
        int rightMaxPathSum = Math.max(maxGain(root.right),0);

        int tempSum = Math.max(Math.max(leftMaxPathSum,rightMaxPathSum)+root.val,root.val);
        ans = Math.max(ans,leftMaxPathSum+rightMaxPathSum+root.val);

        return tempSum;
    }
}
