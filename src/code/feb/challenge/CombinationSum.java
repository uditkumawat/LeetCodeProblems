package code.feb.challenge;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/
//backtracking problem
public class CombinationSum {

    public static void main(String args[]){

        int candidates[] = {2,3,5};
        int target = 8;

        CombinationSum obj = new CombinationSum();

        List<List<Integer>> res = obj.combinationSum(candidates,target);

        for(List<Integer> list:res){
            System.out.println(list);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        if(target==0){
            return res;
        }

        combinationSumUtil(candidates,target,res,new ArrayList<>(),0);

        return res;
    }

    public void combinationSumUtil(int candidates[],int target,List<List<Integer>> res,List<Integer> currList,int startIndex){

        if(target==0){
            res.add(new ArrayList<>(currList));
            return;
        }

        if(startIndex>=candidates.length || target<0){
            return;
        }

        for(int i=startIndex;i<candidates.length;i++){
            currList.add(candidates[i]);
            combinationSumUtil(candidates,target-candidates[i],res,currList,i);
            currList.remove(currList.size()-1);
        }
    }
}
