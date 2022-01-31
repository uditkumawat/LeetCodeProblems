package code.facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//TC- O(N)
//SC - O(Diameter)
public class LargestValueInEachTreeRow {

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        LargestValueInEachTreeRow obj = new LargestValueInEachTreeRow();
        List<Integer> res = obj.largestValues(root);
        for(int num:res){
            System.out.print(num+" ");
        }
    }

    public List<Integer> largestValues(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            int maxValue = Integer.MIN_VALUE;

            for(int i=0;i<size;i++){
                TreeNode currentNode = q.poll();
                maxValue = Math.max(maxValue,currentNode.val);

                if(currentNode.left!=null){
                    q.add(currentNode.left);
                }


                if(currentNode.right!=null){
                    q.add(currentNode.right);
                }
            }

            res.add(maxValue);
        }

        return res;
    }
}
