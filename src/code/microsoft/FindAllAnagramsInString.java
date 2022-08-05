package code.microsoft;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/submissions/
//Tc - O(N)
//SC - O(1)
public class FindAllAnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> list = new ArrayList<>();

        int pCount[] = new int[26];

        for(char c:p.toCharArray()){
            pCount[c-'a']++;
        }

        int left = 0;
        int right = 0;
        int sCount[] = new int[26];

        while(right<s.length()){

            char c = s.charAt(right);

            sCount[c-'a']++;

            while(right-left+1>p.length()){

                char lc = s.charAt(left);
                sCount[lc-'a']--;
                left++;
            }

            if(isAnagram(sCount,pCount)){
                list.add(left);
            }

            right++;
        }

        return list;
    }

    public boolean isAnagram(int sCount[],int pCount[]){

        for(int i=0;i<26;i++){
            if(sCount[i]!=pCount[i]){
                return false;
            }
        }
        return true;
    }
}
