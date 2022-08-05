package code.march.challenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloneNAryTree {

    static class Node{
         int val;
         List<Node> children;
         Node(int val){
             this.val = val;
             this.children = new ArrayList<Node>();
         }
    }

    public static void main(String args[]){
        Node root = new Node(1);
        root.children.add(new Node(2));
        root.children.add(new Node(3));
        root.children.add(new Node(4));

        CloneNAryTree obj = new CloneNAryTree();

        System.out.println("Level order traversal");
        obj.printLevelOrder(root);

        System.out.println("Cloning");
        obj.cloneTree(root);

        System.out.println("Level order traversal of cloned tree");
        obj.printLevelOrder(root);
    }

    public void printLevelOrder(Node root){
        if(root==null){
            return;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);

        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                Node temp = q.poll();
                System.out.print(temp.val+" ");
                for(Node child:temp.children){
                    q.add(child);
                }
            }
            System.out.println();
        }
    }

    public Node cloneTree(Node root) {
        if(root==null){
            return null;
        }

        return cloneUtil(root);
    }

    public Node cloneUtil(Node root){
        if(root==null){
            return null;
        }

        Node newNode = new Node(root.val);

        for(Node child:root.children){
            newNode.children.add(cloneUtil(child));
        }

        return newNode;
    }
}
