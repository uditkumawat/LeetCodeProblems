package code.leetcode.studyplan;

import code.facebook.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/solution/
//TC - O(N)
//SC - O(N)
public class TwoSumIfInputIsBST {

    public boolean findTarget(TreeNode root, int k) {

        if(root==null){
            return false;
        }

        List<Integer> res = new ArrayList<>();
        inorder(root,res);

        int left = 0;
        int right = res.size()-1;

        while(left<right){
            int sum = res.get(left)+res.get(right);
            if(sum==k){
                return true;
            }
            else if(sum>k){
                right--;
            }
            else{
                left++;
            }
        }

        return false;
    }

    public void inorder(TreeNode root,List<Integer> res){
        if(root==null){
            return;
        }
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }
}
