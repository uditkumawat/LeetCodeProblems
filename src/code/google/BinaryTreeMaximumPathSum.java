package code.google;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/solution/
public class BinaryTreeMaximumPathSum {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public int maxPathSum(TreeNode root) {
        if(root==null){
            return 0;
        }
        int max[] = new int[1];
        BinaryTreeMaximumPathSum obj = new BinaryTreeMaximumPathSum();
        obj.maxPathUtil(root,max);
        return max[0];
    }

    public int maxPathUtil(TreeNode root,int max[]){

        if(root==null){
            return 0;
        }

        int leftSum = Math.max(0,maxPathUtil(root.left,max));
        int rightSum = Math.max(0,maxPathUtil(root.right,max));

        max[0] = Math.max(max[0],leftSum+rightSum+root.val);

        return root.val+Math.max(leftSum,rightSum);

    }
}
