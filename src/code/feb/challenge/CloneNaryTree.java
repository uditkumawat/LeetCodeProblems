package code.feb.challenge;

import java.util.ArrayList;
import java.util.List;

public class CloneNaryTree {

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
    public Node cloneTree(Node root) {
        // Base case: empty node.
        if (root == null) {
            return root;
        }

        // First, copy the node itself.
        Node nodeCopy = new Node(root.val);

        // Then, recursively clone the sub-trees.
        for (Node child : root.neighbors) {
            nodeCopy.neighbors.add(this.cloneTree(child));
        }

        return nodeCopy;
    }
}
