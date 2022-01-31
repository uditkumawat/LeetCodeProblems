package code.facebook;

import apple.laf.JRSUIUtils;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInorderPostOrderTraversal {

    public static void main(String args[]){

        int inorder[] = {9,3,15,20,7};
        int postorder[] = {9,15,7,20,3};

        BinaryTreeFromInorderPostOrderTraversal obj = new BinaryTreeFromInorderPostOrderTraversal();

        TreeNode root = obj.buildTree(inorder,postorder);

        obj.preorder(root);
    }

    public void preorder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val);
        preorder(root.left);
        preorder(root.right);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if(inorder==null || inorder.length==0 || postorder==null || postorder.length==0){
            return null;
        }

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return formTree(inorder,postorder,map,postorder.length-1,0,inorder.length-1);
    }

    public TreeNode formTree(int inorder[],int postorder[],Map<Integer,Integer> map,int index,int left,int right){

        if(left>right){
            return null;
        }

        int currentNodeValue = postorder[index];
        int currentNodeIndex = map.get(currentNodeValue);

        TreeNode root = new TreeNode(currentNodeValue);

        root.right = formTree(inorder,postorder,map,index--,currentNodeIndex+1,right);

        root.left = formTree(inorder,postorder,map,index--,left,currentNodeIndex-1);

        return root;
    }
}
