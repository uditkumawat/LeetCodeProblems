package code.bloomberg;

import code.facebook.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/boundary-of-binary-tree/solution/
public class BoundaryOfBinaryTree {

    public boolean isLeaf(TreeNode t){
        return t.left==null && t.right==null;
    }

    public void addLeaves(TreeNode root, List<Integer> res){
        if(root==null){
            return;
        }
        if(isLeaf(root)){
            res.add(root.val);
        }
        else{
            if(root.left!=null){
                addLeaves(root.left,res);
            }
            if(root.right!=null){
                addLeaves(root.right,res);
            }
        }
    }
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        List<Integer> res = new ArrayList<Integer>();
        if(root==null){
            return res;
        }

        if(!isLeaf(root)){
            res.add(root.val);
        }

        TreeNode t = root.left;

        while(t!=null){
            if(!isLeaf(t)){
                res.add(t.val);
            }

            if(t.left!=null){
                t = t.left;
            }
            else{
                t = t.right;
            }
        }

        addLeaves(root,res);

        t = root.right;

        Stack<Integer> st = new Stack<Integer>();

        while(t!=null){
            if(!isLeaf(t)){
                st.push(t.val);
            }

            if(t.right!=null){
                t = t.right;
            }
            else {
                t = t.left;
            }
        }

        while(!st.isEmpty()){
            res.add(st.pop());
        }

        return res;
    }
}
