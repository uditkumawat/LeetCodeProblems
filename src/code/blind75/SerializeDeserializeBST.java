package code.blind75;

import code.facebook.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/serialize-and-deserialize-bst/
//TC- O(n)
//SC - O(n)
public class SerializeDeserializeBST {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }

    private void serialize(TreeNode root,StringBuilder sb){
        if(root==null){
            return;
        }
        sb.append(root.val).append(",");
        serialize(root.left,sb);
        serialize(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length()==0){
            return null;
        }
        Queue<String> q = new LinkedList(Arrays.asList(data.split(",")));
        return deserialize(q,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private TreeNode deserialize(Queue<String> q,int lower,int upper){
        if(q.isEmpty()){
            return null;
        }
        String peek = q.peek();
        System.out.println(peek);
        int val = Integer.parseInt(peek);
        if(val<lower || val>upper){
            return null;
        }
        q.remove();
        TreeNode root = new TreeNode(val);
        root.left = deserialize(q,lower,val);
        root.right = deserialize(q,val,upper);
        return root;
    }
}
