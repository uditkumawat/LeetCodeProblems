package code.september2022.challenge;

import code.facebook.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/path-sum-ii/submissions/
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> res = new ArrayList();

        if(root==null){
            return res;
        }

        pathSum(root,targetSum,res,new ArrayList<Integer>());

        return res;
    }

    public void pathSum(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> temp){

        if(root==null){
            return;
        }

        temp.add(root.val);
        if(isLeaf(root) && targetSum==root.val){
            res.add(new ArrayList(temp));
        }
        pathSum(root.left,targetSum-root.val,res,temp);
        pathSum(root.right,targetSum-root.val,res,temp);
        temp.remove(temp.size()-1);

    }

    private boolean isLeaf(TreeNode root){
        return root!=null && root.left==null && root.right==null;
    }
}
