package code.top100;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String args[]){

        int candidates[] = {2,3,6,7};
        int target = 7;

        List<List<Integer>> lists = combinationSum(candidates,target);

        for(List<Integer> list:lists){
            for(int i:list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> lists = new ArrayList<>();

        backTrack(candidates,target,lists,new ArrayList<>(),0);

        return lists;
    }

    public static void backTrack(int candidates[],int target,List<List<Integer>> lists,List<Integer> list,int index){

        if(target==0){
            lists.add(new ArrayList<>(list));
            return;
        } else if(target<0){
            return;
        }

        for(int i=index;i<candidates.length;i++){
            list.add(candidates[i]);
            backTrack(candidates,target-candidates[i],lists,list,i);  //not doing i+1 because each element can be used multiple times
            list.remove(list.size()-1);
        }
    }
}
