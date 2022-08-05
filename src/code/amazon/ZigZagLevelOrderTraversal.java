package code.amazon;

import code.facebook.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
public class ZigZagLevelOrderTraversal {

    public static void main(String args[]){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        ZigZagLevelOrderTraversal obj = new ZigZagLevelOrderTraversal();

        List<List<Integer>> res = obj.zigzagLevelOrder(root);

        for(List<Integer> list:res){
            System.out.println(list);
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        boolean isLeft = true;
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();
            while(size-->0){
                TreeNode node = q.poll();
                if(isLeft){
                    temp.add(node.val);
                }
                else{
                    temp.add(0,node.val);
                }
                if(node.left!=null){
                    q.add(node.left);
                }

                if(node.right!=null){
                    q.add(node.right);
                }
            }
            isLeft = !isLeft;
            res.add(temp);
        }

        return res;
    }
}
