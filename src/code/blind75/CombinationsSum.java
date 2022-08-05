package code.blind75;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/solution/
public class CombinationsSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> res = new ArrayList<>();

        if(candidates==null || candidates.length==0){
            return res;
        }

        combinationSum(candidates,0,target,res,new ArrayList<>());

        return res;
    }

    public void combinationSum(int candidates[],int start,int sum,List<List<Integer>> res, List<Integer> temp){

        if(sum==0){
            res.add(new ArrayList<>(temp));
            return;
        }
        else if(sum<0){
            return;
        }

        for(int end=start;end<candidates.length;end++){
            temp.add(candidates[end]);
            combinationSum(candidates,end,sum-candidates[end],res,temp);
            temp.remove(temp.size()-1);
        }
    }
}
