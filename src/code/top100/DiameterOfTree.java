package code.top100;

public class DiameterOfTree {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String args[]){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        diameterOfBinaryTree(root);
        System.out.println(max);

    }
    static int max = 0;
    public static int diameterOfBinaryTree(TreeNode root) {

        util(root);
        return max;
    }

    public static int util(TreeNode root){

        if(root==null){
            return 0;
        }

        int left = util(root.left);
        int right = util(root.right);

        int temp = Math.max(left,right)+1;
        int ans = Math.max(temp,left+right+1);
        max = Math.max(max,ans);

        return temp;
    }
}
