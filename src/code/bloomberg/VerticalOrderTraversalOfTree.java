package code.bloomberg;

import code.facebook.TreeNode;

import java.util.*;

//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/submissions/
public class VerticalOrderTraversalOfTree {

    class Entry{
        int row;
        int col;
        int val;
        Entry(int row,int col,int val){
            this.row = row;
            this.col = col;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> list = new ArrayList();
        if(root==null){
            return list;
        }

        List<Entry> temp = new ArrayList();
        dfs(root,0,0,temp);

        Collections.sort(temp,(Entry e1, Entry e2)->{

            if(e1.col==e2.col){
                if(e1.row==e2.row){
                    return e1.val-e2.val;
                }
                else{
                    return e1.row-e2.row;
                }
            }
            else{
                return e1.col-e2.col;
            }
        });

        TreeMap<Integer,List<Integer>> map = new TreeMap();
        for(Entry entry:temp){
            if(!map.containsKey(entry.col)){
                map.put(entry.col,new ArrayList());
            }
            map.get(entry.col).add(entry.val);
        }

        //System.out.println(map);
        for(List<Integer> l:map.values()){
            list.add(l);
        }

        return list;
    }

    public void dfs(TreeNode root,int row,int col,List<Entry> list){
        if(root==null){
            return;
        }
        list.add(new Entry(row,col,root.val));
        dfs(root.left,row+1,col-1,list);
        dfs(root.right,row+1,col+1,list);
    }
}
