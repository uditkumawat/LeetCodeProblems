package code.leetcode.studyplan75;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-palindrome/submissions/
//TC - O(N)
//SC - O(N)
public class LongestPalindrome {

    public int longestPalindrome(String s) {

        Map<Character,Integer> map = new HashMap<Character,Integer>();

        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
            else{
                map.put(s.charAt(i),1);
            }
        }

        int count=0;
        boolean flag=false;

        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            if(entry.getValue()%2==0){
                count += entry.getValue();
            }
            else{

                count+=(entry.getValue()/2)*2;
                if(flag==false){
                    flag=true;
                    count+=1;
                }
            }
        }

        return count;
    }
}
