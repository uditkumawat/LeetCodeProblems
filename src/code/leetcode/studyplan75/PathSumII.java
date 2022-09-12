package code.leetcode.studyplan75;

import code.facebook.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> res = new ArrayList();

        if(root==null){
            return res;
        }

        pathSum(root,targetSum,res,new ArrayList<Integer>());

        return res;
    }

    public void pathSum(TreeNode root,int targetSum,List<List<Integer>> res,List<Integer> temp){

        if(root==null){
            return;
        }

        temp.add(root.val);
        if(isLeaf(root) && targetSum==root.val){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        else{
            if(root.left!=null){
                pathSum(root.left,targetSum-root.val,res,temp);
                temp.remove(temp.size()-1);
            }
            if(root.right!=null){
                pathSum(root.right,targetSum-root.val,res,temp);
                temp.remove(temp.size()-1);
            }
        }

    }

    private boolean isLeaf(TreeNode root){
        return root!=null && root.left==null && root.right==null;
    }
}
