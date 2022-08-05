package code.may.challenge;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum-iii/
public class CombinationSumIII {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res = new ArrayList<>();

        if(k==0 || n==0){
            return res;
        }

        combinationUtil(k,n,res,new ArrayList<>(),1);

        return res;
    }

    public void combinationUtil(int k,int n,List<List<Integer>> res,List<Integer> temp,int start){

        if(n==0 && temp.size()==k){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int end=start;end<=9;end++){
            temp.add(end);
            combinationUtil(k,n-end,res,temp,end+1);
            temp.remove(temp.size()-1);
        }
    }
}
