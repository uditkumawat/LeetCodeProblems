package code.leetcode.studyplan75;

import code.facebook.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/maximum-width-of-binary-tree/solution/
//TC - O(N)
//Sc - O(N)
public class MaximumWidthOfBinaryTree {

    public int widthOfBinaryTree(TreeNode root) {

        if(root==null){
            return 0;
        }

        Queue<Pair<TreeNode,Integer>> q = new LinkedList();
        q.add(new Pair<TreeNode,Integer>(root,0));
        int maxWidth = 0;
        while(!q.isEmpty()){

            int size = q.size();
            TreeNode node = null;
            int w = 0;
            int left = 0;
            int right = 0;
            for(int i=0;i<size;i++){

                Pair<TreeNode,Integer> pair = q.poll();
                node = pair.getKey();
                w = pair.getValue();
                if(i==0){
                    left = w;
                }
                if(i==size-1){
                    right = w;
                }


                if(node.left!=null){
                    q.add(new Pair<TreeNode,Integer>(node.left,2*w));
                }
                if(node.right!=null){
                    q.add(new Pair<TreeNode,Integer>(node.right,2*w+1));
                }
            }
            maxWidth = Math.max(maxWidth,right-left+1);
        }

        return maxWidth;
    }
}
