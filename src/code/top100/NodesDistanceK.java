package code.top100;

import java.util.*;

public class NodesDistanceK {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);
        root.left.left.right = new TreeNode(7);

        List<Integer> list = distanceK(root,root.left.left,2);
        for(int i:list){
            System.out.print(i+" ");
        }
    }
    static Map<TreeNode,TreeNode> parentMapping = new HashMap();
    static Set<TreeNode> visited = new HashSet();

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k){

        List<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        mapToParent(root,null);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.add(target);
        int currLevel = 0;

        while(!q.isEmpty() && currLevel<=k){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(currLevel==k){
                    res.add(curr.val);
                }
                if(curr.left!=null && !visited.contains(curr.left)){
                    visited.add(curr.left);
                    q.add(curr.left);
                }
                if(curr.right!=null && !visited.contains(curr.right)){
                    visited.add(curr.right);
                    q.add(curr.right);
                }
                if(parentMapping.get(curr)!=null && !visited.contains(parentMapping.get(curr))){
                    visited.add(parentMapping.get(curr));
                    q.add(parentMapping.get(curr));
                }
            }
            currLevel++;
        }

        return res;
    }

    public static void mapToParent(TreeNode node,TreeNode parent){
        if(node==null){
            return;
        }
        parentMapping.put(node,parent);
        mapToParent(node.left,node);
        mapToParent(node.right,node);
    }
}
