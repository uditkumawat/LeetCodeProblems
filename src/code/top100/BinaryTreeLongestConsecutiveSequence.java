package code.top100;

import apple.laf.JRSUIUtils;

public class BinaryTreeLongestConsecutiveSequence {

    private static int maxLength = 0;
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String args[]){
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(4);

        longestConsecutive(node);

        System.out.print(maxLength);


    }
    public static int longestConsecutive(TreeNode root) {
        dfs(root,null,0);
        return maxLength;
    }

    public static  void dfs(TreeNode node,TreeNode parent,int length){
        if(node==null){
            return;
        }
        length = (parent!=null && node.val==parent.val+1)?length+1:1;
        maxLength = Math.max(maxLength,length);
        dfs(node.left,node,length);
        dfs(node.right,node,length);
    }
}
