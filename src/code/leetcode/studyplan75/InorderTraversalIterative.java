package code.leetcode.studyplan75;

import code.facebook.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/binary-tree-inorder-traversal/submissions/
//TC - O(N)
//SC - O(N)
public class InorderTraversalIterative {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList();
        if(root==null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();

        while(!stack.isEmpty() || root!=null){

            while(root!=null){
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }

        return res;
    }
}
