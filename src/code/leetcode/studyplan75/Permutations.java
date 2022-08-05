package code.leetcode.studyplan75;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations/submissions/
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList();

        List<Integer> list = new ArrayList();

        for(int num:nums){
            list.add(num);
        }

        permute(list,0,res);

        return res;
    }

    public void permute(List<Integer> temp,int start,List<List<Integer>> res){

        if(start==temp.size()){
            res.add(new ArrayList(temp));
            return;
        }

        for(int end=start;end<temp.size();end++){
            swap(temp,start,end);
            permute(temp,start+1,res);
            swap(temp,start,end);
        }
    }

    public void swap(List<Integer> temp,int left,int right){
        int t = temp.get(left);
        temp.set(left,temp.get(right));
        temp.set(right,t);
    }
}
