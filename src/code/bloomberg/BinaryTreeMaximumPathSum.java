package code.bloomberg;

import code.facebook.TreeNode;

//https://www.youtube.com/watch?v=6cA_NDtpyz8&list=PLtQWXpf5JNGLKwqnEtL54puLD7aRTkYyD&index=11
//TC - O(N)
//SC - O(H)
public class BinaryTreeMaximumPathSum {

    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        postorder(root);
        return max;
    }

    private int postorder(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = Math.max(postorder(root.left),0);
        int right = Math.max(postorder(root.right),0);

        max = Math.max(max,left+right+root.val);

        return Math.max(left,right)+root.val;
    }
}
