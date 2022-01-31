package code.facebook;

//TC - O(N)
//SC - O(N)
public class ValidateBST {

    public static void main(String args[]){
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        ValidateBST obj = new  ValidateBST();
        System.out.println(obj.isValidBST(root));

    }
    public boolean isValidBST(TreeNode root) {
        return validate(root,null,null);
    }

    private boolean validate(TreeNode root,Integer min,Integer max){
        if(root==null){
            return true;
        }
        if((min!=null && root.val<=min) || (max!=null && root.val>=max)){
            return false;
        }
        return validate(root.left,min,root.val) && validate(root.right,root.val,max);
    }
}
