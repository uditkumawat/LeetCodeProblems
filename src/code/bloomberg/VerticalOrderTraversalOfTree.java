package code.bloomberg;

import code.facebook.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/submissions/
public class VerticalOrderTraversalOfTree {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> list = new ArrayList();
        if(root==null){
            return list;
        }

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap();

        dfs(root,0,0,map);

        for(TreeMap<Integer,PriorityQueue<Integer>> value:map.values()){
            list.add(new ArrayList<Integer>());
            for(PriorityQueue<Integer> pq:value.values()){
                while(!pq.isEmpty()){
                    list.get(list.size()-1).add(pq.poll());
                }
            }
        }

        return list;
    }

    public void dfs(TreeNode root,int x,int y,TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map){
        if(root==null){
            return;
        }
        if(!map.containsKey(x)){
            map.put(x,new TreeMap<>());
        }
        if(!map.get(x).containsKey(y)){
            map.get(x).put(y,new PriorityQueue<>());
        }
        map.get(x).get(y).add(root.val);
        dfs(root.left,x-1,y+1,map);
        dfs(root.right,x+1,y+1,map);
    }
}
