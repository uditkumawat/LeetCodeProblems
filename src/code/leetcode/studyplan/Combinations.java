package code.leetcode.studyplan;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList();

        if(n==0 || k==0){
            return res;
        }

        combinations(1,n,k,new ArrayList<>(),res);

        return res;
    }

    public void combinations(int start,int n,int k,List<Integer> temp,List<List<Integer>> res){
        if(temp.size()==k){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int end = start;end<=n;end++){
            temp.add(end);
            combinations(end+1,n,k,temp,res);
            temp.remove(temp.size()-1);
        }
    }
}
