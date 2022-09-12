package code.september2022.challenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//https://leetcode.com/problems/n-ary-tree-level-order-traversal/submissions/
//TC - O(N)
//SC - O(N)
public class NaryTreeLevelOrderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList();
        if(root==null){
            return res;
        }

        Queue<Node> q = new LinkedList();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> list = new ArrayList();
            while(size-->0){
                Node node = q.remove();
                list.add(node.val);

                if(node.children!=null){
                    for(Node neighbour:node.children){
                        q.add(neighbour);
                    }
                }
            }
            res.add(list);
        }

        return res;
    }
}
