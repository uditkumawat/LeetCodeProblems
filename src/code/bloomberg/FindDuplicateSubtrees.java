package code.bloomberg;

import code.facebook.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/find-duplicate-subtrees/
//TC-O(n^2)
//SC - O(n)
//https://leetcode.com/problems/find-duplicate-subtrees/discuss/1370456/Java-oror-Easy-Approach-with-Explanation-oror-HashMap-oror-Postorder
public class FindDuplicateSubtrees {

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        List<TreeNode> res = new ArrayList();
        Map<String,Integer> map = new HashMap();

        mapper(root,map,res);

        return res;
    }

    public String mapper(TreeNode root,Map<String,Integer> map,List<TreeNode> res){

        if(root==null){
            return "N";
        }

        String left = mapper(root.left,map,res);
        String right = mapper(root.right,map,res);

        String newString = root.val+" "+left+" "+right;

        map.put(newString,map.getOrDefault(newString,0)+1);

        if(map.get(newString)==2){
            res.add(root);
        }
        return newString;
    }
}
