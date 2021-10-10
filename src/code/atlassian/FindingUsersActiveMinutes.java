package code.atlassian;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//Time:O(n) and O(n+k) where n=logs.length

/**
 * You are given the logs for users' actions on LeetCode, and an integer k. The logs are represented by a 2D integer array logs where each logs[i] = [IDi, timei] indicates that the user with IDi performed an action at the minute timei.
 *
 * Multiple users can perform actions simultaneously, and a single user can perform multiple actions in the same minute.
 *
 * The user active minutes (UAM) for a given user is defined as the number of unique minutes in which the user performed an action on LeetCode. A minute can only be counted once, even if multiple actions occur during it.
 *
 * You are to calculate a 1-indexed array answer of size k such that, for each j (1 <= j <= k), answer[j] is the number of users whose UAM equals j.
 *
 * Return the array answer as described above.
 */
public class FindingUsersActiveMinutes {

    public static void main(String args[]){
        FindingUsersActiveMinutes obj = new FindingUsersActiveMinutes();
        int logs[][]={{0,5},{1,2},{0,2},{0,5},{1,3}};
        int k = 5;

        int res[] = obj.findingUsersActiveMinutes(logs,k);

        for(int num:res){
            System.out.print(num+" ");
        }
    }
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {

        int ans[] = new int[k];

        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int log[]:logs){
            int id = log[0];
            int time = log[1];
            if(!map.containsKey(id)){
                map.put(id,new HashSet<>());
            }
            map.get(id).add(time);
        }

        for(Map.Entry<Integer,Set<Integer>> entry:map.entrySet()){
            int uniqueActions = entry.getValue().size();
            ans[uniqueActions-1]++;
        }

        return ans;
    }
}
