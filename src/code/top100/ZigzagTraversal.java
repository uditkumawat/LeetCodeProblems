package code.top100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//TC - O(n)
//SC - O(n)
public class ZigzagTraversal {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val=val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(8);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        // inorderRecursive(root);
        List<List<Integer>> list = zigzagLevelOrder(root);

        for(List<Integer> l:list){
            System.out.println(l);
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean reversed = false;

        while(!q.isEmpty()){

            int size = q.size();

            List<Integer> arr = new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode node = q.poll();

                if(reversed){
                    arr.add(0,node.val);
                }
                else{
                    arr.add(node.val);
                }

                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }

            list.add(arr);
            reversed = !reversed;
        }

        return list;
    }
}
