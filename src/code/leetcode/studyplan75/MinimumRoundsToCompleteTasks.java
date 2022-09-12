package code.leetcode.studyplan75;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/submissions/
//TC - O(N)
//SC - O(N)
public class MinimumRoundsToCompleteTasks {

    public int minimumRounds(int[] tasks) {

        int rounds = 0;

        Map<Integer,Integer> map = new HashMap();
        for(int task:tasks){
            map.put(task,map.getOrDefault(task,0)+1);
        }

        for(int val:map.values()){

            if(val==1){
                return -1;
            }

            rounds+=val/3;

            if(val%3!=0){
                rounds++;
            }
        }

        return rounds;
    }
}
