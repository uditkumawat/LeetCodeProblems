package code.top100;

import code.facebook.TreeNode;

import java.util.*;

//https://leetcode.com/problems/binary-tree-vertical-order-traversal/
//https://www.youtube.com/watch?v=HerofFaS3ZA
public class BinaryTreeVerticalOrderTraversal {

    class Point{

        int x;
        int y;
        int val;
        Point(int x,int y,int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        List<Point> pointList = new ArrayList<>();

        traverse(root,0,0,pointList);

        Collections.sort(pointList,(p1, p2)->{
            return (p1.x==p2.x)?((p1.y==p2.y)?p1.val-p2.val:p2.y-p1.y):p1.x-p2.x;
        });

        Map<Integer,List<Integer>> map = new TreeMap<>();

        for(Point p:pointList){
            List<Integer> verticalLine = map.getOrDefault(p.x,new ArrayList<>());
            verticalLine.add(p.val);

            map.put(p.x,verticalLine);
        }

        for(Map.Entry<Integer,List<Integer>> entry:map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

    public void traverse(TreeNode root,int x,int y,List<Point> pointList){
        if(root==null){
            return;
        }

        pointList.add(new Point(x,y,root.val));
        traverse(root.left,x-1,y-1,pointList);
        traverse(root.right,x+1,y-1,pointList);
    }
}
