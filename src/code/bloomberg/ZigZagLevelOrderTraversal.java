package code.bloomberg;

import code.facebook.TreeNode;

import java.util.*;

//TC - O(N)
//SC - O(N)
public class ZigZagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList();
        if(root==null){
            return res;
        }

        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        boolean leftToRight = false;

        while(!q.isEmpty()){

            int size = q.size();
            List<Integer> temp = new ArrayList();

            for(int i=0;i<size;i++){

                TreeNode node = q.poll();
                if(leftToRight){
                    temp.add(0,node.val);
                }
                else{
                    temp.add(node.val);
                }

                if(node.left!=null){
                    q.add(node.left);
                }

                if(node.right!=null){
                    q.add(node.right);
                }
            }
            res.add(temp);
            leftToRight=!leftToRight;
        }

        return res;
    }
}
