package code.top100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Time complexity : O(n) One complete traversal for leaves and two traversals upto depth of binary tree for left and right boundary.
 *
 * Space complexity : O(n) resres and stackstack is used.
 */
public class BoundaryOfTree {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);


        List<Integer> res = boundaryOfBinaryTree(root);
        for(int i:res){
            System.out.print(i+" ");
        }
    }
    public static boolean isLeafNode(TreeNode root){
        return root!=null && root.left==null && root.right==null;
    }

    public static void addLeaves(TreeNode root, List<Integer> res){
        if(root==null){
            return;
        }
        if(root!=null && isLeafNode(root)){
            res.add(root.val);
        }
        addLeaves(root.left,res);
        addLeaves(root.right,res);
    }

    public static List<Integer> boundaryOfBinaryTree(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();
        if(root==null)
            return res;

        if(!isLeafNode(root)){
            res.add(root.val);
        }

        TreeNode t = root.left;
        while(t!=null){
            if(!isLeafNode(t)){
                res.add(t.val);
            }
            if(t.left!=null){
                t= t.left;
            }
            else{
                t=t.right;
            }
        }

        addLeaves(root,res);

        Stack<Integer> s = new Stack<>();
        t = root.right;
        while(t!=null){
            if(!isLeafNode(t)){
                s.push(t.val);
            }
            if(t.right!=null){
                t=t.right;
            }
            else{
                t=t.left;
            }
        }
        while(!s.isEmpty()){
            res.add(s.pop());
        }

        return res;
    }
}
