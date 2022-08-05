package code.feb.challenge;

import java.util.*;

//https://www.youtube.com/watch?v=f2EfGComRKM
//TC - O(N+M)  , N is number of nodes and M number of edges
public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public static void main(String args[]){

        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        first.neighbors.add(second);
        first.neighbors.add(fourth);

        second.neighbors.add(first);
        second.neighbors.add(third);

        third.neighbors.add(second);
        third.neighbors.add(fourth);

        fourth.neighbors.add(first);
        fourth.neighbors.add(third);

        CloneGraph obj = new CloneGraph();

        Node root = obj.clone(first);

        obj.printGraph(root);

    }

    public void printGraph(Node root){
        Set<Integer> visited = new HashSet<>();
        dfsPrint(root,visited);
    }

    private void dfsPrint(Node node,Set<Integer> visited){
        if(visited.contains(node.val)){
            return;
        }

        System.out.print(node.val+" ");
        for(Node neighbor:node.neighbors){
            System.out.print(neighbor.val+" ");
        }
        System.out.println();
        visited.add(node.val);

        for(Node neighbor:node.neighbors){
            if(!visited.contains(neighbor.val)){
                dfsPrint(neighbor,visited);
            }
        }
    }

    public Node clone(Node node){
        if(node==null){
            return node;
        }

        Map<Node,Node> visited = new HashMap<>();

        Node newNode = dfs(node,visited);

        return newNode;
    }

    public Node dfs(Node node,Map<Node,Node> visited){
        if(node==null){
            return null ;
        }

        if(visited.containsKey(node)){
            return visited.get(node);
        }

        Node clonedNode = new Node(node.val);
        visited.put(node,clonedNode);

        for(Node neighbor:node.neighbors){
            clonedNode.neighbors.add(dfs(neighbor,visited));
        }

        return clonedNode;
    }

}
