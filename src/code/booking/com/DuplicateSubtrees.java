package code.booking.com;

import code.facebook.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.geeksforgeeks.org/find-duplicate-subtrees/
//TC - O(N^2) string copying takes N extra time
//https://leetcode.com/problems/find-duplicate-subtrees/
public class DuplicateSubtrees {

    public static void main(String args[]){

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(4);

        DuplicateSubtrees obj = new DuplicateSubtrees();

        List<TreeNode> res = obj.findDuplicate(root);

        for(TreeNode node:res){
            System.out.println(node.val);
        }

    }

    public List<TreeNode> findDuplicate(TreeNode root){

        List<TreeNode> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap();

        inorder(root,res,map);

        return res;
    }

    public String inorder(TreeNode root,List<TreeNode> res,Map<String,Integer> map){

        if(root==null){
            return "";
        }

        String str = "(";
        str+=inorder(root.left,res,map);
        str+=Integer.toString(root.val);
        str+=inorder(root.right,res,map);
        str+=')';

        if(map.containsKey(str) && map.get(str)==1){
            res.add(root);
        }

        map.put(str,map.getOrDefault(str,0)+1);

        return str;
    }
}
