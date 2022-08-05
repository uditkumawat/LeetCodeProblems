package code.explorecard.tree;

import code.facebook.TreeNode;

import java.util.ArrayList;

//https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree/solution/

/**
 * Time Complexity: \mathcal{O}(N)O(N) where NN is the number of nodes in the N-ary tree. We traverse each node in the tree once and only once.
 *
 * Space Complexity: \mathcal{O}(L)O(L) where LL is the maximum number of nodes that reside at the same level. Since LL is proportional to NN in the worst case, we could further generalize the time complexity to \mathcal{O}(N)O(N).
 *
 * We use a queue data structure to do BFS traversal, i.e. visiting the nodes level by level.
 *
 * At any given moment, the queue contains nodes that are at most spread into two levels. As a result, assuming the maximum number of nodes at one level is LL, the size of the queue would be less than 2L2L at any time.
 *
 * Therefore, the space complexity of both encode() and decode() functions is \mathcal{O}(L)O(L).
 */
public class EncodeDecodeNaryTree {

    public TreeNode encode(Node root) {

        if(root==null){
            return null;
        }

        TreeNode node = new TreeNode(root.val);

        //first child to left
        if(root.children.size()>0){
            Node firstChild = root.children.get(0);
            node.left = encode(firstChild);
        }

        TreeNode sibling = node.left;

        //other remaning childrens to right of first child
        for(int i=1;i<root.children.size();i++){
            sibling.right = encode(root.children.get(i));
            sibling = sibling.right;
        }

        return node;
    }



    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if(root==null){
            return null;
        }

        Node node = new Node(root.val,new ArrayList<>());

        TreeNode sibling = root.left;
        while(sibling!=null){
            node.children.add(decode(sibling));
            sibling = sibling.right;
        }

        return node;
    }
}
