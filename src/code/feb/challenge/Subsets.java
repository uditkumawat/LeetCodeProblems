package code.feb.challenge;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String args[]){

        int nums[] = {1,2,3};
        Subsets obj = new Subsets();
        List<List<Integer>> ans = obj.subsets(nums);

        for(List<Integer> list:ans){
            System.out.println(list);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        helper(nums,ans,new ArrayList<>(),0);

        return ans;
    }

    public void helper(int nums[],List<List<Integer>> ans,List<Integer> currList,int index){
        ans.add(new ArrayList<>(currList));
        if(index>=nums.length){
            return;
        }
        for(int i=index;i<nums.length;i++){
            currList.add(nums[i]);

            helper(nums,ans,currList,i+1);
            currList.remove(currList.size()-1);
        }
    }
}
