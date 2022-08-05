package code.feb.challenge;

import code.facebook.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/maximum-width-of-binary-tree/
//https://www.youtube.com/watch?v=KH3hEFw-CXQ
public class MaximumWidthOfBinaryTree {

    public static void main(String args[]){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        MaximumWidthOfBinaryTree obj = new MaximumWidthOfBinaryTree();

        System.out.println(obj.widthOfBinaryTree(root));

    }
    public int widthOfBinaryTree(TreeNode root) {

        if(root==null){
            return 0;
        }

        Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        q.add(new Pair(root,0));

        int maxWidth = 0;

        while(!q.isEmpty()){
            int size = q.size();

            Pair<TreeNode,Integer> head = q.peek();
            Pair<TreeNode,Integer> elem = null;

            while(size-->0){

                elem = q.poll();
                TreeNode node = elem.getKey();
                int weight = elem.getValue();

                if(node.left!=null){
                    q.add(new Pair<>(node.left,2*weight));
                }
                if(node.right!=null){
                    q.add(new Pair<>(node.right,2*weight+1));
                }
            }

            maxWidth = Math.max(maxWidth,elem.getValue()-head.getValue()+1);
        }

        return maxWidth;
    }
}
