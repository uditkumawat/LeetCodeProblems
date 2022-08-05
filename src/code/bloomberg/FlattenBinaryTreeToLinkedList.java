package code.bloomberg;

import code.facebook.TreeNode;

import java.util.Stack;

//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
//Tc - O(N)
//SC - O(1)
//https://www.youtube.com/watch?v=r83qV4vCm_4&t=199s
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {

        if(root==null){
            return;
        }

        preorder(root);

        return;
    }

    public TreeNode preorder(TreeNode root){
        if(root==null){
            return null;
        }

        TreeNode leftChild = preorder(root.left);
        TreeNode rightChild = preorder(root.right);

        TreeNode extremeRightChildOfLC = leftChild;

        while(extremeRightChildOfLC!=null && extremeRightChildOfLC.right!=null){
            extremeRightChildOfLC = extremeRightChildOfLC.right;
        }

        if(extremeRightChildOfLC!=null){
            extremeRightChildOfLC.right = rightChild;
            root.right = leftChild;
        }

        root.left = null;

        return root;
    }

    public void flattenUsingStack(TreeNode root) {

        if(root==null){
            return;
        }

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            TreeNode currNode = st.pop();
            if(currNode.right!=null){
                st.push(currNode.right);
            }

            if(currNode.left!=null){
                st.push(currNode.left);
            }

            currNode.right = st.isEmpty()==false?st.peek():null;

            currNode.left = null;
        }

        return;
    }
}
