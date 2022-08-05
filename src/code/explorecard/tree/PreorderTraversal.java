package code.explorecard.tree;

import code.facebook.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/binary-tree-preorder-traversal/solution/
//TC - O(N)
//SC - O(N)
public class PreorderTraversal {

    public static void main(String args[]){

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        PreorderTraversal obj = new PreorderTraversal();

        List<Integer> res = obj.preorderTraversal(root);

        for(int num:res){
            System.out.print(num+" ");
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }

        while(true){

            while(root!=null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }

            if(!stack.isEmpty()){
                TreeNode node = stack.pop();
                root = node.right;
            }
            else{
                break;
            }
        }

        return res;
    }
}
