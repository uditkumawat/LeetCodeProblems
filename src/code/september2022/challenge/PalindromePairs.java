package code.september2022.challenge;

import java.util.*;

//https://leetcode.com/problems/palindrome-pairs/submissions/
//https://www.youtube.com/watch?v=ewNE1UbjmJ8
public class PalindromePairs {

    public List<List<Integer>> palindromePairs(String[] words) {

        List<List<Integer>> res = new ArrayList();

        Map<String,Integer> map = new HashMap();

        for(int i=0;i<words.length;i++){
            map.put(words[i],i);
        }

        //Empty string case
        // "" "aaa"
        // "cdc" ""
        if(map.containsKey("")){
            int blankIdx = map.get("");
            for(int i=0;i<words.length;i++){
                if(blankIdx!=i && isPalindrome(words[i])){
                    res.add(Arrays.asList(blankIdx,i));
                    res.add(Arrays.asList(i,blankIdx));
                }
            }
        }

        //lengths are matching and if concatenate becomes palindrome
        //reflection case
        // "abcd" "dcba"
        for(int i=0;i<words.length;i++){
            String revWord = new StringBuilder(words[i]).reverse().toString();
            Integer revIndex = map.get(revWord);
            if(revIndex!=null && revIndex!=i){
                res.add(Arrays.asList(i,revIndex));
            }
        }

        for(int i=0;i<words.length;i++){

            String curr = words[i];

            for(int cut=1;cut<curr.length();cut++){

                String left = curr.substring(0,cut);
                String right = curr.substring(cut);

                if(isPalindrome(left)){

                    String reversedRight = new StringBuilder(right).reverse().toString();
                    if(map.containsKey(reversedRight)){
                        res.add(Arrays.asList(map.get(reversedRight),i));
                    }
                }


                if(isPalindrome(right)){

                    String reversedLeft = new StringBuilder(left).reverse().toString();
                    if(map.containsKey(reversedLeft)){
                        res.add(Arrays.asList(i,map.get(reversedLeft)));
                    }
                }
            }
        }

        return res;
    }

    public boolean isPalindrome(String word){

        int left = 0;
        int right = word.length()-1;

        while(left<right){
            if(word.charAt(left)!=word.charAt(right)){
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

}
