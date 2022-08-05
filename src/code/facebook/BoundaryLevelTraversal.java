package code.facebook;

import code.tagged.facebook.BoundaryOfBinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
public class BoundaryLevelTraversal {

    public static void main(String args[]){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(10);

        BoundaryLevelTraversal obj = new BoundaryLevelTraversal();

        List<Integer> res = obj.boundaryOfBinaryTree(root);

        for(int num:res){
            System.out.print(num+" ");
        }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }

        res.add(root.val);
        leftBoundary(root.left,res);
        leaves(root,res);
        rightBoundary(root.right,res);

        return res;
    }

    private void leftBoundary(TreeNode root,List<Integer> res){

        if(root==null){
            return;
        }

        if(root.left!=null){
            res.add(root.val);
            leftBoundary(root.left,res);
        }
        else if(root.right!=null){
            res.add(root.val);
            leftBoundary(root.right,res);
        }

    }

    private void leaves(TreeNode root,List<Integer> res){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            res.add(root.val);
            return;
        }
        leaves(root.left,res);
        leaves(root.right,res);
    }

    private void rightBoundary(TreeNode root,List<Integer> res){

        if(root==null){
            return;
        }

        if(root.right!=null){
            rightBoundary(root.right,res);
            res.add(root.val);

        }
        else if(root.left!=null){
            rightBoundary(root.left,res);
            res.add(root.val);
        }
    }
}
