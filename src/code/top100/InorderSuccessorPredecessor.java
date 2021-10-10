package code.top100;

//https://www.youtube.com/watch?v=lQIXz5NJYLs&list=PLDdcY4olLQk0NJOWhs4PB3DWpjnuUESbk&index=5
public class InorderSuccessorPredecessor {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static TreeNode prev = null;
    static TreeNode succ = null;

    public static void main(String args[]) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(5);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(6);

        find(root, root.left);

        System.out.println(prev.val);
        System.out.println(succ.val);

    }

    public static void find(TreeNode root, TreeNode target) {
        if (root == null) {
            return;
        }

        System.out.println(root.val+" "+target.val);
        if (root.val == target.val) {
            if (root.left != null) {
                TreeNode temp = root.left;
                while (temp!=null && temp.right != null) {
                    temp = temp.right;
                }
                prev = temp;
            }

            if (root.right != null) {
                TreeNode temp = root.right;
                while (temp!=null && temp.left!= null) {
                    temp = temp.left;
                }
                succ = temp;
            }
        } else if (root.val > target.val) {
            succ = root;
            find(root.left, target);
        } else {
            prev = root;
            find(root.right, target);
        }
    }
}
