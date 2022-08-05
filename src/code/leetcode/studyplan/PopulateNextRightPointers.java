package code.leetcode.studyplan;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/submissions/
//TC - O(N)
//SC - O(N)
//https://www.youtube.com/watch?v=3MRPQFUpoA0
public class PopulateNextRightPointers {

    class Node{

        Node right;
        Node left;
        Node next;
        int val;
    }

    public Node connect(Node root) {
        if(root==null){
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        Node prev = null;

        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();

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

            prev = null;
        }

        return root;
    }
}
