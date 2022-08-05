package code.april.challenge;

import code.facebook.TreeNode;

//TC - O(logn) - average case for complete tree, O(N) - skew tree
//SC - O(logn) - recursion stack - average case, O(N) - worst case
public class SearchInBST {

    public static void main(String args[]){

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        SearchInBST obj = new SearchInBST();

        TreeNode res = obj.searchBST(root,2);

        obj.printNodeVal(res);

        res = obj.searchBST(root,5);

        obj.printNodeVal(res);
    }

    private void printNodeVal(TreeNode node){
        if(node!=null){
            System.out.println(node.val);
        }
        else{
            System.out.println("Node not found");
        }
    }
    public TreeNode searchBST(TreeNode root, int val) {

        if(root==null || root.val==val){
            return root;
        }
        else if(val>root.val){
            return searchBST(root.right,val);
        }
        else{
            return searchBST(root.left,val);
        }
    }
}
