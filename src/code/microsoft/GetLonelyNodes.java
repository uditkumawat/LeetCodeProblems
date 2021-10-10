package code.microsoft;

import java.util.ArrayList;
import java.util.List;

/**
 * In a binary tree, a lonely node is a node that is the only child of its parent node. The root of the tree is not lonely because it does not have a parent node.
 *
 * Given the root of a binary tree, return an array containing the values of all lonely nodes in the tree. Return the list in any order.
 */
public class GetLonelyNodes {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String args[]){
        GetLonelyNodes obj = new GetLonelyNodes();
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(2);

        List<Integer> res = obj.getLonelyNodes(root);

        for(int out:res){
            System.out.print(out+" ");
        }
    }
    public List<Integer> getLonelyNodes(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        getLonelyNodes(root,res);
        return res;
    }

    public void getLonelyNodes(TreeNode root,List<Integer> res){
        if(root==null){
            return;
        }
        if(root.left==null && root.right!=null){
            res.add(root.right.val);
        }
        if(root.left!=null && root.right==null){
            res.add(root.left.val);
        }
        getLonelyNodes(root.left,res);
        getLonelyNodes(root.right,res);
    }
}
