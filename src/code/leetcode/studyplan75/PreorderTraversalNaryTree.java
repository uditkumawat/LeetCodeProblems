package code.leetcode.studyplan75;

import code.explorecard.tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://leetcode.com/problems/n-ary-tree-preorder-traversal/submissions/
//TC - O(N)
//SC - O(N)
public class PreorderTraversalNaryTree {

    public List<Integer> preorder(Node root) {

        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }


        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node node = stack.pop();

            list.add(node.val);

            for(int i=node.children.size()-1;i>=0;i--){
                stack.push(node.children.get(i));
            }
        }

        return list;
    }
}
