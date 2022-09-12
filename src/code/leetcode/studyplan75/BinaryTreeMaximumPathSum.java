package code.leetcode.studyplan75;

import code.facebook.TreeNode;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/submissions/

/**
 * Time complexity: \mathcal{O}(N)O(N), where N is number of nodes, since we visit each node not more than 2 times.
 *
 * Space complexity: \mathcal{O}(H)O(H), where HH is a tree height, to keep the recursion stack. In the average case of balanced tree, the tree height H = \log NH=logN, in the worst case of skewed tree, H = NH=N
 */
public class BinaryTreeMaximumPathSum {

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }

        helper(root);

        return max;
    }

    public int helper(TreeNode root){
        if(root==null){
            return 0;
        }
        // 0 is taken into consideration, becuase from left or right, we could get negative number also
        // and negative number will make the sum lesser
        int leftMax = Math.max(0,helper(root.left));
        int rightMax = Math.max(0,helper(root.right));

        max = Math.max(max,root.val+leftMax+rightMax);

        return root.val+Math.max(leftMax,rightMax);
    }
}
