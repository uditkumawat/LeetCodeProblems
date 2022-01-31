package code.facebook;

import java.util.ArrayList;
import java.util.List;

public class BalanceBinarySearchTree {

    public static void main(String args[]){

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        BalanceBinarySearchTree obj = new BalanceBinarySearchTree();

        List<Integer> sortedList = new ArrayList<>();
        obj.inorder(root,sortedList);

        root = obj.balanceIt(sortedList,0,sortedList.size()-1);

        obj.printTree(root);
    }

    public void printTree(TreeNode root){
        if(root==null){
            return;
        }
        printTree(root.left);
        System.out.println(root.val);
        printTree(root.right);
    }

    public TreeNode balanceIt(List<Integer> sortedList,int start,int end){
        if(start>end){
            return null;
        }
        int mid = start+(end-start)/2;
        TreeNode root = new TreeNode(sortedList.get(mid));
        root.left = balanceIt(sortedList,start,mid-1);
        root.right = balanceIt(sortedList,mid+1,end);
        return root;
    }

    public void inorder(TreeNode root, List<Integer> sortedList){
        if(root==null){
            return;
        }
        inorder(root.left,sortedList);
        sortedList.add(root.val);
        inorder(root.right,sortedList);
    }

}
