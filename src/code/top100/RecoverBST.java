package code.top100;

//https://leetcode.com/problems/recover-binary-search-tree/discuss/32535/No-Fancy-Algorithm-just-Simple-and-Powerful-In-Order-Traversal
public class RecoverBST {

    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;

    public void recover(TreeNode root){
        if(root==null){
            return;
        }

        recover(root.left);
        if(prev!=null && prev.val>root.val){
            if(first==null){
                first = prev;
            }
            if(first!=null && prev.val>root.val){
                second = root;
            }
        }
        prev = root;
        recover(root.right);
    }

    public void swap(TreeNode first,TreeNode second){
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
