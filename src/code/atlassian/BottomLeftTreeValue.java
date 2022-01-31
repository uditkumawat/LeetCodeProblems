package code.atlassian;

import java.util.LinkedList;
import java.util.Queue;

public class BottomLeftTreeValue {

    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String args[]){

        BottomLeftTreeValue obj = new BottomLeftTreeValue();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);

        int bottomLeftValue = obj.getBottomLeftValue(root);

        System.out.print(bottomLeftValue);
    }

    public int getBottomLeftValue(TreeNode root){

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        int res = 0;

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                TreeNode currentNode = q.poll();
                if(i==0){
                    res = currentNode.val;
                }

                if(currentNode.left!=null){
                    q.add(currentNode.left);
                }


                if(currentNode.right!=null){
                    q.add(currentNode.right);
                }
            }
        }

        return res;
    }

}
