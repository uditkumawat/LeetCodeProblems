package code.top100;

public class LongestUnivaluePath {

    static int maxLength=0;
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String args[]){
        TreeNode node = new TreeNode(5);
        node.left =  new TreeNode(4);
        node.left.left =  new TreeNode(1);
        node.left.right =  new TreeNode(1);
        node.right = new TreeNode(5);
        node.right.right = new TreeNode(5);
        System.out.println(longestUnivaluePath(node));

    }
    public static int longestUnivaluePath(TreeNode root) {

        dfs(root,null,0);
        return maxLength-1;
    }

    public static void dfs(TreeNode node,TreeNode parent,int length){
        if(node==null){
            return;
        }
        length = (parent!=null && node.val==parent.val)?length+1:1;
        maxLength = Math.max(maxLength,length);
        dfs(node.left,node,length);
        dfs(node.right,node,length);
    }
}
