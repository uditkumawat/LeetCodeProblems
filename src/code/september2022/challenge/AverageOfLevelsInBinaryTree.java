package code.september2022.challenge;

import code.facebook.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/average-of-levels-in-binary-tree/solution/
//TC - O(N) - number of nodes in tree
//SC - O(m) - maximum number of nodes at any level
public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> res = new ArrayList();

        if(root==null){
            return res;
        }

        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while(!q.isEmpty()){

            int size = q.size();
            long sum = 0;

            for(int i=0;i<size;i++){
                TreeNode node = q.remove();
                sum = sum + node.val;
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }

            res.add(sum*1.0/size);
        }

        return res;
    }
}
