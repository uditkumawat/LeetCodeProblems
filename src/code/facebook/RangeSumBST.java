package code.facebook;

public class RangeSumBST {

    int sum;

    public static void main(String args[]){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(18);

        RangeSumBST obj = new RangeSumBST();

        System.out.println(obj.rangeSumBST(root,6,10));

    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        if(root==null){
            return sum;
        }

        getSum(root,low,high);

        return sum;
    }

    public void getSum(TreeNode root,int low,int high){

        if(root==null){
            return;
        }

        if(root.val>=low && root.val<=high){
            sum = sum + root.val;
        }

        if(low<root.val){
            getSum(root.left,low,high);
        }

        if(root.val<high){
            getSum(root.right,low,high);
        }
    }
}
