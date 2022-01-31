package code.facebook;

import java.util.Stack;

//https://www.youtube.com/watch?v=vssbwPkarPQ
//TC - O(N)
//SC - O(max width of tree)
public class FlattenBinaryTreeToLinkedList {

    TreeNode prev;
    public static void main(String args[]){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        FlattenBinaryTreeToLinkedList obj = new FlattenBinaryTreeToLinkedList();
        System.out.println("Printing preorder");
        obj.preorder(root);


        obj.flatten(root);

        System.out.println("After Flatenning");
        obj.printList(root);
    }

    private void flattenToList(TreeNode root){
        if(root==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
            if (!stack.isEmpty()) {
                currentNode.right = stack.peek();
            }
        }
    }

    public void flatten(TreeNode root){
        if(root==null){
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    private void preorder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    private void printList(TreeNode root){
        if(root==null){
            return;
        }
        while(root!=null){
            System.out.print(root.val);
            root = root.right;
        }
    }
}
