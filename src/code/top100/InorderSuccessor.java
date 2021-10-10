package code.top100;

//TC - O(n)

public class InorderSuccessor {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val=val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        TreeNode succ = inorderSuccessor(root,root.left.left);
        System.out.println(succ.val);
    }

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        TreeNode succ = null;
        TreeNode curr = root;
        while(curr!=null){
            if(p.val>= curr.val){
                curr = curr.right;
            }
            else{
                succ = curr;
                curr = curr.left;
            }
        }
        return succ;
    }
}
