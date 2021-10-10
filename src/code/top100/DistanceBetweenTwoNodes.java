package code.top100;

public class DistanceBetweenTwoNodes {

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        System.out.println(distance(root,4,5));
        System.out.println(distance(root,4,6));
        System.out.println(distance(root,3,4));
        System.out.println(distance(root,8,5));
    }

    public static int distance(TreeNode root,int n1,int n2){
        if(root==null){
            return -1;
        }

        TreeNode lca = findLCA(root,n1,n2);

        if(lca==null){
            return -1;
        }

        int d1 = findDistanceFromLCAToTarget(lca,n1,0);
        int d2 = findDistanceFromLCAToTarget(lca,n2,0);
        return d1+d2;
    }

    public static TreeNode findLCA(TreeNode root,int n1,int n2){
        if(root==null || root.val == n1 || root.val ==n2){
            return root;
        }

        TreeNode left = findLCA(root.left,n1,n2);
        TreeNode right = findLCA(root.right,n1,n2);

        if(left!=null && right!=null){
            return root;
        }
        else{
            return left!=null?left:right;
        }
    }

    public static int findDistanceFromLCAToTarget(TreeNode root,int n1,int distance){
        if(root==null){
            return -1;
        }

        if(root.val==n1){
            return distance;
        }

        int d1 = findDistanceFromLCAToTarget(root.left,n1,distance+1);

        if( d1!=-1){
            return d1;
        }

        int d2 = findDistanceFromLCAToTarget(root.right,n1,distance+1);

        return d2;
    }
}
