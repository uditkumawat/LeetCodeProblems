package code.explorecard.tree;

import java.util.Stack;

//https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/
//https://www.youtube.com/watch?v=qk3JNkcdm0o&t=80s
public class SerializeDeserializeNaryTree {

    public static final String DELIMITER = ",";
    public static final String NULL = "NULL";

    public static void main(String args[]){

        Node root = new Node(1);

        Node obj1 = new Node(3);
        Node obj2 = new Node(2);
        Node obj3 = new Node(4);
        Node obj4 = new Node(5);
        Node obj5 = new Node(6);

        obj1.children.add(obj4);
        obj1.children.add(obj5);

        root.children.add(obj1);
        root.children.add(obj2);
        root.children.add(obj3);

        SerializeDeserializeNaryTree obj = new SerializeDeserializeNaryTree();
        String serialized = obj.serialize(root);

        root = obj.deserialize(serialized);

        obj.printPreorer(root);
    }

    public void printPreorer(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.val+" ");
        for(Node child:root.children){
            printPreorer(child);
        }
    }
    public String serialize(Node root){

        StringBuilder sb = new StringBuilder();

        serialize(root,sb);

        return sb.toString();
    }

    public void serialize(Node root,StringBuilder sb){
        if(root==null){
            return;
        }

        sb.append(root.val+DELIMITER);
        for(Node child:root.children){
            serialize(child,sb);
        }
        sb.append(NULL).append(DELIMITER);
    }

    public Node deserialize(String s){

        String tokens[] = s.split(DELIMITER);
        Stack<Node> stack = new Stack<>();
        for(String str:tokens){
            if(NULL.equals(str)){
                if(!stack.isEmpty() && stack.size()>1){
                    Node poppedNode = stack.pop();
                    stack.peek().children.add(poppedNode);
                }
            }
            else{
                Node node = new Node(Integer.parseInt(str));
                stack.push(node);
            }
        }

        return stack.pop();
    }
}
