package code.leetcode.studyplan75;

import code.facebook.TreeNode;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/path-sum-iii/
//TC - O(n)
//SC - O(n) - heihgt of tree
public class PathSumIII {

    int count = 0;
    Map<Long,Integer> map = new HashMap();
    public int pathSum(TreeNode root, int targetSum) {

        if(root==null){
            return 0;
        }
        helper(root,targetSum,0);
        return count;
    }

    public void helper(TreeNode node,int targetSum,long currSum){
        if(node==null){
            return;
        }
        currSum = currSum + node.val;

        //targetSum found in path startgin from root
        if(currSum==targetSum){
            count++;
        }

        //targetSum found in path startign in between , not through root
        count = count + map.getOrDefault(currSum-targetSum,0);

        map.put(currSum,map.getOrDefault(currSum,0)+1);

        helper(node.left,targetSum,currSum);
        helper(node.right,targetSum,currSum);

        map.put(currSum,map.get(currSum)-1);

    }
}
