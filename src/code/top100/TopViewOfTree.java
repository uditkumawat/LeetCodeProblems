package code.top100;

import sun.awt.image.ImageWatched;

import java.util.HashMap;
import java.util.Map;

public class TopViewOfTree {

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
       TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // inorderRecursive(root);
        Map<Integer,Integer> map = new HashMap<>();
        topView(root,map,0);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){

            System.out.println(entry.getValue());
        }
    }

    public static void topView(TreeNode root,Map<Integer,Integer> map,int height){

        if(root==null){
            return;
        }
        if(!map.containsKey(height)){
            map.put(height,root.val);
        }
        topView(root.left,map,height-1);
        topView(root.right,map,height+1);
    }
}
