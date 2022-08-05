package code.bloomberg;


import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/submissions/
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulateNiextRightPointersInEachNodeII {

    public Node connect(Node root) {
        if(root==null){
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        Node prev = null;
        while(!q.isEmpty()){
            int size = q.size();
            prev = null;
            for(int i=0;i<size;i++){
                Node node = q.remove();
                node.next = prev;
                prev = node;
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
