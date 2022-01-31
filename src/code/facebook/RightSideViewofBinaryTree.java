package code.facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Time complexity: \mathcal{O}(N)O(N) since one has to visit each node.
 *
 * Space complexity: \mathcal{O}(D)O(D) to keep the queues, where DD is a tree diameter. Let's use the last level to estimate the queue size.
 */
public class RightSideViewofBinaryTree {

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
       // root.right = new TreeNode(3);
        root.left.left = new TreeNode(6);
       // root.left.right = new TreeNode(4);
      //  root.right.right = new TreeNode(5);

        RightSideViewofBinaryTree obj = new RightSideViewofBinaryTree();
        List<Integer> res = obj.rightSideView(root);
        for(int num:res){
            System.out.print(num+" ");
        }
    }
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode currentNode = queue.poll();
                if(i==size-1){
                    res.add(currentNode.val);
                }
                if(currentNode.left!=null){
                    queue.add(currentNode.left);
                }
                if(currentNode.right!=null){
                    queue.add(currentNode.right);
                }
            }
        }

        return res;
    }
}
