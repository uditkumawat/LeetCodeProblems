package code.april.challenge;

import code.facebook.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertBSTToGreaterTree {

    int sum = 0;

    public static void main(String args[]){

        ConvertBSTToGreaterTree obj = new ConvertBSTToGreaterTree();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);

        System.out.println("Level order of original tree");
        obj.printLevelOrder(root);

        obj.convertBST(root);

        System.out.println("\nLevel order of Greater BST tree");
        obj.printLevelOrder(root);
    }

    public void printLevelOrder(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                System.out.print(node.val+" ");
                if(node.left!=null){
                    q.add(node.left);
                }

                if(node.right!=null){
                    q.add(node.right);
                }
            }
        }
    }
    public void printPreorder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.val);
        printPreorder(root.left);
        printPreorder(root.right);
    }

    public TreeNode convertBST(TreeNode root) {

        if(root==null){
            return root;
        }
        convertBST(root.right);
        sum = sum + root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
