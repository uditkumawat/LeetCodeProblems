package code.facebook;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorOfAllNodes {

    static TreeNode resNode;
    public static void main(String args[]){

        resNode = null;
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int nodes[] = {1,5};

        LowestCommonAncestorOfAllNodes obj = new LowestCommonAncestorOfAllNodes();

        Set<Integer> nodesForLCA = new HashSet<>();
        for(int node:nodes){
            nodesForLCA.add(node);
        }

        obj.helper(root,nodesForLCA);

        System.out.println(resNode.val);
    }

    public static int  helper(TreeNode root, Set<Integer> nodes){
        if(root==null){
            return 0;
        }
        int leftCount = helper(root.left,nodes);
        int rightCount = helper(root.right,nodes);

        int countHere = leftCount+rightCount;
        if(nodes.contains(root.val)){
            countHere++;
        }

        if(countHere==nodes.size() && resNode==null){
            resNode = root;
        }

        return countHere;
    }
}
