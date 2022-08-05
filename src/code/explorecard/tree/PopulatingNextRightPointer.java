package code.explorecard.tree;

import java.util.LinkedList;
import java.util.Queue;

//https://www.youtube.com/watch?v=vG-PcRVt1LU
public class PopulatingNextRightPointer {

    class Node{
        int val;
        Node left;
       Node right;
        Node next;
        Node(int val){
            this.val = val;
        }
    }

    public Node connect(Node root) {

        if(root==null){
            return root;
        }

        Queue<Node> q = new LinkedList();
        q.add(root);

        while(!q.isEmpty()){

            int size = q.size();
            Node prevRight = null;

            for(int i=0;i<size;i++){

                Node node = q.poll();
                node.next = prevRight;
                prevRight = node;

                if(node.right!=null){
                    q.add(node.right);
                }

                if(node.left!=null){
                    q.add(node.left);
                }
            }
        }

        return root;
    }

}
