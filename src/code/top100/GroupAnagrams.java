package code.top100;

import java.util.*;

/**
 * Time Complexity: O(NK)O(NK), where NN is the length of strs, and KK is the maximum length of a string in strs. Counting each string is linear in the size of the string, and we count every string.
 *
 * Space Complexity: O(NK)O(NK), the total information content stored in ans.
 */
public class GroupAnagrams {

        public static List<List<String>> groupAnagrams(String[] strs) {

            if(strs.length==0){
                return new ArrayList<>();
            }

            Map<String,List<String>> map = new HashMap<>();
            int count[] = new int[26];

            for(String s:strs){

                Arrays.fill(count,0);

                for(char c:s.toCharArray()){
                    count[c-'a']++;
                }

                StringBuilder sb = new StringBuilder("");
                for(int i=0;i<26;i++){
                    sb.append("#");
                    sb.append(count[i]);
                }

                String st = sb.toString();

                if(!map.containsKey(st)){
                    map.put(st,new ArrayList<>());
                }
                map.get(st).add(s);
            }

            return new ArrayList<>(map.values());
        }
}
