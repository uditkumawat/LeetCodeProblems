package code.top100;

import java.util.List;
import java.util.Map;

//tc - O(n)
public class CloneGraph {

    static class Node{
        int val;
        List<Node> neighbours;
    }

    public static void main(String args[]){


    }

    public Node cloneGraph(Node root, Map<Integer,Node> map){
        if(root==null){
            return null;
        }

        if(map.containsKey(root.val)){
            return map.get(root.val);
        }
        else{
            Node copy = new Node();
            copy.val = root.val;

            map.put(root.val,copy);

            for(Node node:root.neighbours){
                copy.neighbours.add(cloneGraph(node,map));
            }

            return copy;

        }


    }
}
