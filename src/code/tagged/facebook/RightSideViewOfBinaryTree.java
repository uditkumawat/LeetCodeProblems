package code.tagged.facebook;

import code.facebook.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/binary-tree-right-side-view/
//TC - O(N)
//SC - O(D) - maximum diameter of tree
public class RightSideViewOfBinaryTree {

    public static void main(String args[]){

        RightSideViewOfBinaryTree obj = new RightSideViewOfBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        List<Integer> res = obj.rightSideView(root);

        for(int num:res){
            System.out.println(num);
        }

    }
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList();

        if(root==null){
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){

                TreeNode temp = q.poll();
                if(i==size-1){
                    res.add(temp.val);
                }

                if(temp.left!=null){
                    q.add(temp.left);
                }

                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
        }

        return res;
    }
}
