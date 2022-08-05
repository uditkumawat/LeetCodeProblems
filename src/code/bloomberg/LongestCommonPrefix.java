package code.bloomberg;

//https://leetcode.com/problems/longest-common-prefix/solution/

/**
 * Time complexity : O(S)O(S) , where S is the sum of all characters in all strings.
 *
 * In the worst case all nn strings are the same. The algorithm compares the string S1S1 with the other strings [S_2 \ldots S_n][S
 * 2
 * ​
 *  …S
 * n
 * ​
 *  ] There are SS character comparisons, where SS is the sum of all characters in the input array.
 *
 * Space complexity : O(1)O(1). We only used constant extra space.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if(strs==null || strs.length==0){
            return "";
        }

        String prefix = strs[0];

        for(int i=1;i<strs.length;i++){
            //System.out.println("out "+strs[i]+" "+prefix);
            while(strs[i].indexOf(prefix)!=0){
                // System.out.println("in "+strs[i]+" "+prefix);
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()){
                    return "";
                }
            }
        }

        return prefix;
    }
}
