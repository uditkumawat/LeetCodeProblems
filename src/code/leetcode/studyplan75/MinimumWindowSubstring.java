package code.leetcode.studyplan75;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-window-substring/submissions/
//TC - O(N+M)  // s -length N   t length M
//sc - O(M) // map
//https://www.youtube.com/watch?v=U1q16AFcjKs&t=551s
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {

        if(s==null || t==null || s.length()==0 || t.length()==0){
            return "";
        }

        Map<Character,Integer> tmap = new HashMap();
        for(char c:t.toCharArray()){
            tmap.put(c,tmap.getOrDefault(c,0)+1);
        }

        //count of unique characters from tmap
        int counter = tmap.size();
        int left = 0;
        int right = s.length()-1;
        int min = s.length();
        boolean found = false;
        int i=0,j=0;

        while(j<s.length()){
            char endChar = s.charAt(j);
            j++;
            if(tmap.containsKey(endChar)){
                tmap.put(endChar,tmap.get(endChar)-1);
                if(tmap.get(endChar)==0){
                    counter--;
                }
            }

            if(counter!=0){
                continue;
            }

            while(counter==0){
                char leftChar = s.charAt(i);
                i++;
                if(tmap.containsKey(leftChar)){
                    tmap.put(leftChar,tmap.get(leftChar)+1);
                    if(tmap.get(leftChar)>0){
                        counter++;
                    }
                }
            }

            if((j-i)<min){
                left = i;
                right = j;
                min = j-i;
                found = true;
            }

        }

        return !found?"":s.substring(left-1,right);
    }
}
