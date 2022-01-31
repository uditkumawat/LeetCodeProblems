package code.airbnb;

import java.util.*;

//https://www.youtube.com/watch?v=ewNE1UbjmJ8&t=437s
//TC - O(n*k^2)
public class PalindromePairs {

    public static void main(String args[]){

        PalindromePairs obj = new PalindromePairs();

        String words[] = {"abcd","dcba","lls","s","sssll"};
        //String words[] = {"a",""};
        List<List<Integer>> indices = obj.getPairs(words);

        for(List<Integer> list:indices){
            System.out.print("["+list.get(0)+","+list.get(1)+"],");
        }
    }

    public List<List<Integer>> getPairs(String words[]){

        List<List<Integer>> res = new ArrayList<>();

        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],i);
        }

        //1.Reflection is present
        for(int i=0;i<words.length;i++){
            String reversedString = reverseWord(words[i]);
            if(map.containsKey(reversedString) && i!=map.get(reversedString)){
                res.add(Arrays.asList(i,map.get(reversedString)));
            }
        }

        //2.Empty string is present
        if(map.containsKey("")){
            int blankIdx = map.get("");
            for(int i=0;i<words.length;i++){
                if(i!=blankIdx && isPalindrome(words[i])){
                    res.add(Arrays.asList(i,blankIdx));
                    res.add(Arrays.asList(blankIdx,i));
                }
            }
        }

        //3.Half of the string is matching
        for(int i=0;i<words.length;i++){
            String currWord = words[i];
            for(int cut=1;cut<currWord.length();cut++){
                String leftStr = currWord.substring(0,cut);
                String rightStr = currWord.substring(cut);

                if(isPalindrome(leftStr)){
                    String reversedString = reverseWord(rightStr);
                    if(map.containsKey(reversedString) && i!=map.get(reversedString)){
                        res.add(Arrays.asList(map.get(reversedString),i));
                    }
                }

                if(isPalindrome(rightStr)){
                    String reversedString = reverseWord(leftStr);
                    if(map.containsKey(reversedString) && i!=map.get(reversedString)){
                        res.add(Arrays.asList(i,map.get(reversedString)));
                    }
                }
            }
        }

        return res;
    }

    public String reverseWord(String word){
        return new StringBuilder(word).reverse().toString();
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
