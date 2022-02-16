package code.feb.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsOfString {

    public static void main(String args[]){
        String s = "cbaebabacd";
        String p = "abc";

        FindAllAnagramsOfString obj = new FindAllAnagramsOfString();

        List<Integer> res = obj.findAnagrams(s,p);

        for(int num:res){
            System.out.print(num+" ");
        }
    }
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();

        int left = 0;
        int right = 0;
        int len = p.length();

        int counts[] = new int[26];
        int countp[] = new int[26];

        Arrays.fill(counts,0);
        Arrays.fill(countp,0);

        for(char c:p.toCharArray()){
            countp[c-'a']++;
        }

        while(right<s.length()){
            char c = s.charAt(right);

            counts[c-'a']++;

            while(right-left>=len){
                char oldChar = s.charAt(left);
                counts[oldChar-'a']--;
                left++;
            }

            int i = 0;
            for(;i<26;i++){
                if(countp[i]!=counts[i]){
                    break;
                }
            }

            if(i==26){
                res.add(left);
            }

            right++;
        }

        return res;
    }
}
