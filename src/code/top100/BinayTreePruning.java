package code.top100;

//TC - O(N)
//SC - O(N) worst case for dfs it is skewed tree
public class BinayTreePruning {

    static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
    }

    public TreeNode pruneTree(TreeNode root) {

        return containsOne(root) ? root:null;
    }

    public boolean containsOne(TreeNode node){
        if(node==null){
            return false;
        }

        boolean leftContainsOne = containsOne(node.left);
        boolean rightContainsOne = containsOne(node.left);

        if(!leftContainsOne){
            node.left = null;
        }


        if(!rightContainsOne){
            node.right = null;
        }

        return node.val==1 || leftContainsOne || rightContainsOne;
    }
}
