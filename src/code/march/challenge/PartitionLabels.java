package code.march.challenge;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/partition-labels/
//TC - O(N)
//SC - O(1)
public class PartitionLabels {

    public static void main(String args[]){

        String s = "ababcbacadefegdehijhklij";

        PartitionLabels obj = new PartitionLabels();

        List<Integer> res = obj.partitionLabels(s);

        System.out.println(res);

    }
    public List<Integer> partitionLabels(String s) {

        List<Integer> res = new ArrayList<>();
        if(s==null || s.length()==0){
            return res;
        }

        int mapIndexes[] = new int[26];

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            mapIndexes[c-'a'] = i;
        }

        int left = 0;
        int right = 0;
        int anchor = 0;
        while(left<s.length()){
            right = Math.max(right,mapIndexes[s.charAt(left)-'a']);
            if(left==right){
                res.add(right-anchor+1);
                anchor = left+1;
            }
            left++;
        }

        return res;
    }
}
