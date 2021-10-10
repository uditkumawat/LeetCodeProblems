package code.atlassian;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, collect a tree's nodes as if you were doing this:
 *
 * Collect all the leaf nodes.
 * Remove all the leaf nodes.
 * Repeat until the tree is empty.
 */
public class FindLeavesOfBinaryTree {

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

        FindLeavesOfBinaryTree obj = new FindLeavesOfBinaryTree();

        List<List<Integer>> res = obj.findLeaves(root);
        for(List<Integer> r:res){
            for(int num:r){
                System.out.print(num+" ");
            }
            System.out.println();
        }

    }

    /*

    //O(N)

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        height(root, res);
        return res;
    }
    private int height(TreeNode node, List<List<Integer>> res){
        if(null==node)  return -1;
        int level = 1 + Math.max(height(node.left, res), height(node.right, res));
        if(res.size()<level+1)  res.add(new ArrayList<>());
        res.get(level).add(node.val);
        return level;
    }
     */

    //O(n^2)
    public List<List<Integer>> findLeaves(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }

        while(root!=null){
            List<Integer> temp = new ArrayList<>();
            root = removeLeafNodes(root,temp);
            res.add(temp);
        }

        return res;
    }

    public TreeNode removeLeafNodes(TreeNode root,List<Integer> list){
        if(root==null){
            return null;
        }
        if(root!=null && root.left==null && root.right==null){
            list.add(root.val);
            return null;
        }

        root.left = removeLeafNodes(root.left,list);
        root.right = removeLeafNodes(root.right,list);

        return root;
    }
}
