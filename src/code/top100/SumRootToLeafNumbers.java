package code.top100;

public class SumRootToLeafNumbers {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static int finalSum = 0;

    public static void main(String args[]){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        dfs(root,0);

        System.out.println(finalSum);
    }

    public static void dfs(TreeNode root,int value){
        if(root==null){
            return;
        }
        value = value*10;
        value = value+root.val;
        if(root.left==null && root.right==null){
            finalSum+=value;
            return;
        }
        dfs(root.left,value);
        dfs(root.right,value);
    }
}
