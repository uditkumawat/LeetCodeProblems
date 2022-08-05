package code.cohesity;

import code.facebook.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/check-completeness-of-a-binary-tree/submissions/
//TC - O(N)
//SC - O(N)
public class CheckCompletenessOfBinaryTree {

    public boolean isCompleteTree(TreeNode root) {
        if(root==null){
            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            TreeNode node = q.remove();

            if(!q.isEmpty() && node==null && q.peek()!=null){
                return false;
            }

            if(node!=null){
                q.add(node.left);
                q.add(node.right);
            }
        }

        return true;
    }
}
