package code.top100;

import apple.laf.JRSUIUtils;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SerializeDeserializeTree {

    private static final String NULL = "XX";
    private static final String delimiter = ",";

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String data = serialize(root);
        System.out.println(data);
        TreeNode head = deserialize(data);
        preorder(head);
    }

    public static void preorder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }

    public static void serialize(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append(NULL).append(delimiter);
            return;
        }
        sb.append(root.val).append(delimiter);
        serialize(root.left,sb);
        serialize(root.right,sb);
    }
    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        Deque<String> dq = new LinkedList<>();
        dq.addAll(Arrays.asList(data.split(delimiter)));
        TreeNode root = deserialize(dq);
        return root;
    }

    public static TreeNode deserialize(Deque<String> dq){
        String val = dq.remove();
        if(val.equals(NULL)){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = deserialize(dq);
        node.right = deserialize(dq);
        return node;
    }
}
