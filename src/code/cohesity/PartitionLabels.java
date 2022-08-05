package code.cohesity;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/partition-labels/solution/
//TC - O(N)
//SC - O(1)
public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {

        int indexes[] = new int[26];
        for(int i=0;i<s.length();i++){
            indexes[s.charAt(i)-'a'] = i;
        }

        int anchor = 0;
        int j = 0;
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            j = Math.max(j,indexes[s.charAt(i)-'a']);
            if(i==j){
                res.add(i-anchor+1);
                anchor = i+1;
            }
        }

        return res;
    }
}
