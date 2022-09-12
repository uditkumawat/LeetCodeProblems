package code.salesforce;

import code.facebook.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {

        List<TreeNode> res = new ArrayList();
        if(root==null){
            return res;
        }
        Set<Integer> set = new HashSet();

        for(int toDelete:to_delete){
            set.add(toDelete);
        }

        root = deleteUtil(root,set,res);
        if(root!=null){
            res.add(root);
        }
        return res;
    }

    public TreeNode deleteUtil(TreeNode root,Set<Integer> set,List<TreeNode> res){
        if(root==null){
            return null;
        }

        root.left = deleteUtil(root.left,set,res);
        root.right = deleteUtil(root.right,set,res);
        if(set.contains(root.val)){
            if(root.left!=null){
                res.add(root.left);
            }
            if(root.right!=null){
                res.add(root.right);
            }
            return null;
        }
        else{
            return root;
        }
    }
}
