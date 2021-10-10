package code.top100;

import java.util.ArrayList;
import java.util.List;

//TC - O(N)
//SC - O(N)
public class PartitionLabels {

    public static void main(String args[]){

        String str = "ababcbacadefegdehijhklij";
        List<Integer> list = partitionLabels(str);

        for(int i:list){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static List<Integer> partitionLabels(String s) {

        int last[] = new int[26];
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            last[c-'a'] = i;
        }

        int anchor = 0;
        int j=0;
        List<Integer> output = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            j = Math.max(j,last[c-'a']);
            if(i==j){
                output.add(i-anchor+1);
                anchor = i+1;
            }
        }

        return output;
    }
}
