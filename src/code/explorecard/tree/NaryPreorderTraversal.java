package code.explorecard.tree;

import java.util.ArrayList;
import java.util.List;

public class NaryPreorderTraversal {

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

        NaryPreorderTraversal obj = new NaryPreorderTraversal();
        List<Integer> res = obj.preorder(root);

        for(int num:res){
            System.out.print(num+" ");
        }
    }
    public List<Integer> preorder(Node root) {

        List<Integer> res = new ArrayList<>();

        preorder(root,res);

        return res;
    }

    public void preorder(Node root,List<Integer> res){
        if(root==null){
            return;
        }
        res.add(root.val);
        for(int i=0;i<root.children.size();i++){
            preorder(root.children.get(i),res);
        }
    }
}
