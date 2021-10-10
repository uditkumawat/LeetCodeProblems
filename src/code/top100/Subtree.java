package code.top100;

public class Subtree {

    class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }

    public static void main(String args[]){

    }

    public boolean check(Node root1,Node root2){
        if(root1==null){
            return root2==null;
        }
        if(isSame(root1,root2)){
            return true;
        }

        return check(root1.left,root2) || check(root1.right,root2);
    }

    boolean isSame(Node root1,Node root2){
        if(root1==null && root2==null){
            return true;
        }
        if(root1==null || root2==null){
            return true;
        }
        if(root1.val!=root2.val){
            return false;
        }
        return isSame(root1.left,root2.left) && isSame(root2.right,root2.right);
    }
}
