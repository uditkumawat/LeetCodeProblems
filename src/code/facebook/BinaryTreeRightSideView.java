package code.facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * Time complexity: \mathcal{O}(N)O(N) since one has to visit each node.
 *
 * Space complexity: \mathcal{O}(D)O(D) to keep the queues, where DD is a tree diameter. Let's use the last level to estimate the queue size. This level could contain up to N/2N/2 tree nodes in the case of complete binary tree.
 */
public class BinaryTreeRightSideView {

    public static void main(String args[]){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        BinaryTreeRightSideView obj = new BinaryTreeRightSideView();

        List<Integer> res = obj.rightSideView(root);

        System.out.print(res);

    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        List<Integer> res = new ArrayList<>();

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                TreeNode node = q.remove();
                if(i==size-1){
                    res.add(node.val);
                }

                if(node.left!=null){
                    q.add(node.left);
                }


                if(node.right!=null){
                    q.add(node.right);
                }
            }
        }

        return res;
    }
}
