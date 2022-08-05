package code.explorecard.tree;

import java.util.*;

public class NaryLevelOrderTraversal {

    public static void main(String args[]){

        Node root = new Node(1);

        Node node1 = new Node(3);
        Node node2 = new Node(2);
        Node node3 = new Node(4);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);

        Node node4 = new Node(5);
        Node node5 = new Node(6);

        node1.children.add(node4);
        node1.children.add(node5);

        NaryLevelOrderTraversal obj = new NaryLevelOrderTraversal();
        List<List<Integer>> res = obj.levelorder(root);

        for(List<Integer> list:res){
            System.out.println(list);
        }
    }
    public List<List<Integer>> levelorder(Node root) {

        List<List<Integer>> res = new ArrayList<>();
        Queue<Node> q = new LinkedList();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList<>();

            for(int i=0;i<size;i++) {
                Node node = q.poll();

                temp.add(node.val);

                for(Node child:node.children){
                    q.add(child);
                }
            }

            res.add(temp);
        }
        return res;
    }
}
