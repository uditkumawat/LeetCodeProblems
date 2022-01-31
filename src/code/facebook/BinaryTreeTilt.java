package code.facebook;

public class BinaryTreeTilt {

    public static void main(String args[]){
        BinaryTreeTilt obj = new BinaryTreeTilt();

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(7);

        obj.findTilt(root);

        obj.preorder(root);
    }

    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }

    public void preorder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }
    public int findTilt(TreeNode root) {

        if(root==null){
            return 0;
        }

        return findTiltUtil(root);
    }

    public int findTiltUtil(TreeNode root){
        if(root==null){
            return 0;
        }
        else{
            int left = findTiltUtil(root.left);
            int right = findTiltUtil(root.right);
            int currentValue = root.val;
            root.val = Math.abs(left-right);

            return currentValue+left+right;
        }
    }
}
