package code.blind75;

//https://leetcode.com/problems/valid-anagram/solution
//TC - O(N)
//SC - O(N)
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {

        if(s==null && t==null){
            return true;
        }

        if((s==null || t==null) || (s.length()!=t.length())){
            return false;
        }

        int count[] = new int[26];

        for(int i=0;i<s.length();i++){

            char cs = s.charAt(i);
            char ct = t.charAt(i);

            count[cs-'a']++;
            count[ct-'a']--;
        }

        for(int i=0;i<count.length;i++){
            if(count[i]!=0){
                return false;
            }
        }

        return true;
    }
}
