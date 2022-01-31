package code.facebook;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {

    public static void main(String args[]){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BinaryTreeVerticalOrderTraversal obj = new BinaryTreeVerticalOrderTraversal();

        List<List<Integer>> res = obj.verticalOrder(root);

        for(List<Integer> list:res){
            System.out.println(list);
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {

        if(root==null){
            return new ArrayList<>();
        }

        return getList(root);
    }

    public List<List<Integer>> getList(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();

        Map<Integer,List<Integer>> map = new TreeMap<>();

        traverse(root,map,0);

        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
            res.add(entry.getValue());
        }

        return res;
    }

    public void traverse(TreeNode root,Map<Integer,List<Integer>> map,int depth){
        if(root==null){
            return;
        }
        if(!map.containsKey(depth)){
            map.put(depth,new ArrayList<>());
        }
        map.get(depth).add(root.val);
        traverse(root.left,map,depth-1);
        traverse(root.right,map,depth+1);
    }
}
