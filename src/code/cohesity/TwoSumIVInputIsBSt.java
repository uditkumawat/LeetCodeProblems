package code.cohesity;

import code.facebook.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/solution/
//TC - O(N)
//SC - O(N)
public class TwoSumIVInputIsBSt {

    public boolean findTarget(TreeNode root, int k) {

        if(root==null){
            return false;
        }
        List<Integer> list = new ArrayList<>();
        inorder(root,list);

        int left = 0;
        int right = list.size()-1;

        while(left<right){
            int sum = list.get(left)+list.get(right);
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

    private void inorder(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
}
