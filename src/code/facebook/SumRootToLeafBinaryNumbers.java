package code.facebook;

public class SumRootToLeafBinaryNumbers {

    int res = 0;

    public static void main(String args[]){
        SumRootToLeafBinaryNumbers obj = new SumRootToLeafBinaryNumbers();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        System.out.println(obj.sumRootToLeaf(root));
    }
    public int sumRootToLeaf(TreeNode root) {
        if(root==null){
            return 0;
        }

        computeSum(root,0);

        return res;
    }

    public void computeSum(TreeNode root,int val){
        if(root==null){
            return;
        }
        val = val<<1 | root.val;
        if(root.left==null && root.right==null){
            res = res+val;
            return;
        }
        computeSum(root.left,val);
        computeSum(root.right,val);
    }
}
