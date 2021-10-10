package code.top100;

import java.util.ArrayDeque;

public class SerializeDeserializeBST {

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

    public StringBuilder postorder(TreeNode root,StringBuilder sb){
        if(root==null){
            return sb;
        }
        postorder(root.left,sb);
        postorder(root.right,sb);
        sb.append(root.val);
        sb.append(",");
        return sb;
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = postorder(root,new StringBuilder());
        if(sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty()){
            return null;
        }
        ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
        for(String s:data.split(",")){
            dq.add(Integer.valueOf(s));
        }
        return helper(Integer.MIN_VALUE,Integer.MAX_VALUE,dq);
    }

    public TreeNode helper(int low,int high,ArrayDeque<Integer> dq){
        if(dq.isEmpty()){
            return null;
        }
        int val = dq.getLast();
        if(val<low || val>high){
            return null;
        }
        dq.removeLast();
        TreeNode node = new TreeNode(val);
        node.right = helper(val,high,dq);
        node.left = helper(low,val,dq);
        return node;
    }
}
