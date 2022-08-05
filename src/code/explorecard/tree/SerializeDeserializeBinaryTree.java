package code.explorecard.tree;

import code.facebook.TreeNode;

import java.util.List;

//https://leetcode.com/problems/serialize-and-deserialize-binary-tree/solution/

/**
 * Time complexity : in both serialization and deserialization functions, we visit each node exactly once, thus the time complexity is O(N)O(N), where NN is the number of nodes, i.e. the size of tree.
 *
 * Space complexity : in both serialization and deserialization functions, we keep the entire tree, either at the beginning or at the end, therefore, the space complexity is O(N)O(N).
 */
public class SerializeDeserializeBinaryTree {

    public static final String NULL = "NULL";

    public static final String DELIMITER = ",";
    public int index;

    public static void main(String args[]){

        SerializeDeserializeBinaryTree obj = new SerializeDeserializeBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        StringBuilder serializedString = new StringBuilder();
        obj.serialize(root,serializedString);

        System.out.println(serializedString.toString());
        obj.index = 0 ;
        TreeNode newRoot = obj.deserialize(serializedString.toString());

        obj.preorder(newRoot);
    }

    public void preorder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.val);
        preorder(root.left);
        preorder(root.right);
    }

    public void serialize(TreeNode root,StringBuilder sb){
        if(root==null){
            sb.append(NULL).append(DELIMITER);
            return;
        }
        sb.append(root.val).append(DELIMITER);
        serialize(root.left,sb);
        serialize(root.right,sb);
    }

    public TreeNode deserialize(String s){

        if(s==null){
            return null;
        }
        String tokens[] = s.split(DELIMITER);

        return deserializeUtil(tokens);
    }

    public TreeNode deserializeUtil(String tokens[]){
        if(NULL.equals(tokens[index])){
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(tokens[index++]));
        root.left = deserializeUtil(tokens);
        root.right = deserializeUtil(tokens);

        return root;
    }
}
