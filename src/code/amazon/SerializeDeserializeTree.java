package code.amazon;

import code.facebook.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class SerializeDeserializeTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }

    private void serialize(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append("NULL").append(",");
            return;
        }
        sb.append(root.val).append(",");
        serialize(root.left,sb);
        serialize(root.right,sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.length()==0){
            return null;
        }
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(q);
    }

    public TreeNode deserialize(Queue<String> q){
        if(q.isEmpty()){
            return null;
        }
        String val = q.poll();
        if("NULL".equals(val)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = deserialize(q);
        root.right = deserialize(q);
        return root;
    }
}
