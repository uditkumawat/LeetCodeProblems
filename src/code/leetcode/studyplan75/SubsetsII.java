package code.leetcode.studyplan75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//
//https://www.youtube.com/watch?v=Vn2v6ajA7U0
public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        subsets(nums,0,res,new ArrayList<>());
        return res;
    }

    public void subsets(int nums[],int index,List<List<Integer>> res,List<Integer> temp){

        if(index>=nums.length){
            res.add(new ArrayList<Integer>(temp));
            return;
        }

        temp.add(nums[index]);
        subsets(nums,index+1,res,temp);
        temp.remove(temp.size()-1);

        while(index+1<nums.length && nums[index]==nums[index+1]){
            index++;
        }
        subsets(nums,index+1,res,temp);
    }
}
