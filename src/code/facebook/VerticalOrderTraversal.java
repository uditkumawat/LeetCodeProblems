package code.facebook;

import java.util.*;

//https://leetcode.com/problems/binary-tree-vertical-order-traversal/
//TC - O(N)
public class VerticalOrderTraversal {


    public static void main(String args[]){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);
        root.left.right.left = new TreeNode(5);
        root.right.left = new TreeNode(1);
        root.right.left.right = new TreeNode(2);
        root.right.right = new TreeNode(7);

        BinaryTreeVerticalOrderTraversal obj = new BinaryTreeVerticalOrderTraversal();

        List<List<Integer>> res = obj.verticalOrder(root);

        for(List<Integer> list:res){
            System.out.println(list);
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }

        Map<Integer,List<Integer>> map = new TreeMap<>();
        dfs(root,map,0);

        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

    public void dfs(TreeNode root,Map<Integer,List<Integer>> map,int d){
        if(root==null){
            return;
        }

        List<Integer> list = map.getOrDefault(d,new ArrayList<>());
        list.add(root.val);
        map.put(d,list);

        dfs(root,map,d-1);
        dfs(root,map,d+1);
    }
}
