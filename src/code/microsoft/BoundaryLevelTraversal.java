package code.microsoft;

import code.facebook.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/boundary-of-binary-tree/submissions/
//TC - O(N)
//SC - O(N)
public class BoundaryLevelTraversal {

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }

        res.add(root.val);

        leftBoundary(root.left,res);
        leaves(root.left,res);
        leaves(root.right,res);
        rightBoundary(root.right,res);

        return res;
    }

    public void leftBoundary(TreeNode root,List<Integer> res){
        if(root==null){
            return;
        }

        while(root!=null){

            if(!isLeaf(root)){
                res.add(root.val);
            }

            if(root.left!=null){
                root = root.left;
            }
            else{
                root = root.right;
            }
        }
    }

    public boolean isLeaf(TreeNode node){
        return node.left==null && node.right==null;
    }

    public void leaves(TreeNode root,List<Integer> res){
        if(root==null){
            return;
        }

        if(root!=null && root.left==null && root.right==null){
            res.add(root.val);
        }
        leaves(root.left,res);
        leaves(root.right,res);
    }


    public void rightBoundary(TreeNode root,List<Integer> res){
        if(root==null){
            return;
        }
        Stack<Integer> stack = new Stack<>();

        while(root!=null){

            if(!isLeaf(root)){
                stack.push(root.val);
            }

            if(root.right!=null){
                root = root.right;
            }
            else{
                root = root.left;
            }
        }

        while(!stack.isEmpty()){
            res.add(stack.pop());
        }

    }
}
