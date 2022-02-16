package code.design;

import code.facebook.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/discuss/74264/Short-and-straight-forward-BFS-Java-code-with-a-queue
//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class SerializeDeserializeBinaryTree {

    public static final String DELIMITER = ",";
    public static final String NULL = "#";

    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);


        SerializeDeserializeBinaryTree obj = new SerializeDeserializeBinaryTree();
        System.out.println("Ist Level order traversal");
        obj.levelOrderTraversal(root);

        String data = obj.serialize(root);

        root = obj.deserialize(data);

        System.out.println("IInd Level order traversal");
        obj.levelOrderTraversal(root);

    }

    public void levelOrderTraversal(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            System.out.print(node.val+" ");
            if(node.left!=null){
                q.add(node.left);
            }
            if(node.right!=null){
                q.add(node.right);
            }
        }
    }

    //level order traversal
    public String serialize(TreeNode root) {

        if(root==null){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node==null){
                sb.append(NULL);
                sb.append(DELIMITER);
                continue;
            }
            else{
                sb.append(node.val);
                sb.append(DELIMITER);
                q.add(node.left);
                q.add(node.right);
            }
        }

        return sb.toString();
    }

    public TreeNode deserialize(String data){

        TreeNode root = null;
        if(data==null || data.length()==0){
            return null;
        }
        String values[] = data.split(DELIMITER);
        Queue<TreeNode> q = new LinkedList<>();
        root = new TreeNode(Integer.parseInt(values[0]));
        q.add(root);

        for(int i=1;i<values.length;i++){
            TreeNode node = q.poll();
            if(!values[i].equals(NULL)){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                node.left = left;
                q.add(left);
            }

            if(!values[++i].equals(NULL)){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                node.right = right;
                q.add(right);
            }
        }
        return root;
    }
}
