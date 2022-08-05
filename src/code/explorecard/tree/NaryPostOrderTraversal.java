package code.explorecard.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/n-ary-tree-postorder-traversal/solution/
public class NaryPostOrderTraversal {

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

        NaryPostOrderTraversal obj = new NaryPostOrderTraversal();
        List<Integer> res = obj.postorder(root);

        for(int num:res){
            System.out.print(num+" ");
        }
    }
    public List<Integer> postorder(Node root) {

        List<Integer> res = new ArrayList<>();
        Stack<Node> stack = new Stack();

       // postorder(root,res);
        if(root==null){
            return res;
        }

        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            res.add(0,node.val);

            for(Node child:node.children){
                stack.push(child);
            }
        }
        return res;
    }

    public void postorder(Node root,List<Integer> res){
        if(root==null){
            return;
        }
        for(int i=0;i<root.children.size();i++){
            postorder(root.children.get(i),res);
        }
        res.add(root.val);
    }
}
