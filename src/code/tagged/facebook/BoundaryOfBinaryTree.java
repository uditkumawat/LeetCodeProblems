package code.tagged.facebook;

import code.facebook.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryOfBinaryTree {

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

        BoundaryOfBinaryTree obj = new BoundaryOfBinaryTree();

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

        TreeNode curr = root;

        while(curr!=null){

            while(curr.left!=null){
                res.add(curr.val);
                curr = curr.left;
            }

            if(curr.right!=null){
                curr = curr.right;
            }
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

        TreeNode curr = root;
        Stack<Integer> stack = new Stack<>();
        while(curr!=null){

            while(curr.right!=null){
                stack.push(curr.val);
                curr = curr.right;
            }

            if(curr.left!=null){
                curr = curr.left;
            }
        }

        while(!stack.isEmpty()){
            res.add(stack.pop());
        }
    }
}
