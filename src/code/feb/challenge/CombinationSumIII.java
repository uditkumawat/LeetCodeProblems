package code.feb.challenge;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum-iii/
public class CombinationSumIII {

    public static void main(String args[]){

        int k = 3;
        int n = 9;

        CombinationSumIII obj = new CombinationSumIII();

        List<List<Integer>> res = obj.combinationSum3(k,n);

        for(List<Integer> list:res){
            System.out.println(list);
        }

    }
    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> res = new ArrayList<>();

        util(res,new ArrayList<>(),k,n,1);

        return res;
    }

    public void util(List<List<Integer>> res,List<Integer> currList,int k,int target,int startIndex){

        if(target==0 && currList.size()==k){
            res.add(new ArrayList<>(currList));
            return;
        }
        else if(target<0 || currList.size()>k){
            return;
        }

        for(int i=startIndex;i<=9;i++){
            currList.add(i);
            util(res,currList,k,target-i,i+1);
            currList.remove(currList.size()-1);
        }
    }
}
