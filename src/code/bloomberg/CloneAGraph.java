package code.bloomberg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Time Complexity: O(N + M)O(N+M), where NN is a number of nodes (vertices) and MM is a number of edges.
 * Space Complexity: O(N)O(N). This space is occupied by the visited hash map and in addition to that, space would also be occupied by the recursion stack since we are adopting a recursive approach here. The space occupied by the recursion stack would be equal to O(H)O(H) where HH is the height of the graph. Overall, the space complexity would be O(N)O(N).
 */
public class CloneAGraph {

    class Node {
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

    private Map<Node,Node> visited = new HashMap();
    public Node cloneGraph(Node node) {
        if(node==null){
            return node;
        }

        if(visited.containsKey(node)){
            return visited.get(node);
        }

        Node clonedNode = new Node(node.val,new ArrayList());
        visited.put(node,clonedNode);

        for(Node neighbour:node.neighbors){
            clonedNode.neighbors.add(cloneGraph(neighbour));
        }

        return clonedNode;
    }
}
