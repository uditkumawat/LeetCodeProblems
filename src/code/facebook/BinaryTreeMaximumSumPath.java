package code.facebook;

//TC - O(N)
//SC - O(H)
public class BinaryTreeMaximumSumPath {

    private int max = Integer.MIN_VALUE;

    public static void main(String args[]){

        TreeNode root = new TreeNode(1);
        BinaryTreeMaximumSumPath obj = new BinaryTreeMaximumSumPath();
        System.out.println(obj.maxPathSum(root));
    }
    public int maxPathSum(TreeNode root) {
        postOrder(root);
        return max;
    }

    private int postOrder(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftMaxValue = Math.max(postOrder(root.left),0);
        int rightMaxValue = Math.max(postOrder(root.right),0);
        max = Math.max(max,leftMaxValue+rightMaxValue+root.val);
        return Math.max(leftMaxValue,rightMaxValue)+root.val;

    }
}
