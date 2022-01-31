package code.facebook;

public class BSTToDLL {

    TreeNode prev = null;
    TreeNode first = null;

    public static void main(String args[]){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        BSTToDLL obj = new BSTToDLL();
        root = obj.treeToDoublyList(root);

        while(root!=null){
            System.out.print(root.val);
            root = root.right;
        }

    }
    public TreeNode treeToDoublyList(TreeNode root) {
        if(root==null){
            return null;
        }

        helper(root);

        return root;
    }

    public void helper(TreeNode node){
        if(node==null){
            return;
        }
        helper(node.left);
        if(prev==null){
            first = node;
        }
        else{
            prev.right = node;
            node.left = prev;
        }
        prev = node;
        helper(node.right);
    }
}
