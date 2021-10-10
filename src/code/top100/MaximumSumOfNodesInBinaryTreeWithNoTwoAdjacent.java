package code.top100;

import java.util.Map;

public class MaximumSumOfNodesInBinaryTreeWithNoTwoAdjacent {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }

    static Map<TreeNode,Integer> map;

    public static int getMax(TreeNode root){
        if(root==null){
            return 0;
        }

        if(map.containsKey(root)){
            return map.get(root);
        }

        //if we are including current node
        int including = root.val;
        if(root.left!=null){
            including+=getMax(root.left.left);
            including+=getMax(root.left.right);
        }
        if(root.right!=null){
            including+=getMax(root.right.left);
            including+=getMax(root.right.right);
        }

        //excluding current node
        int excluding = getMax(root.left)+getMax(root.right);

        map.put(root,Math.max(including,excluding));

        return map.get(root);
    }
}
