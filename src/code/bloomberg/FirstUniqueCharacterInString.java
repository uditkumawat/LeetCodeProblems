package code.bloomberg;

//https://leetcode.com/problems/first-unique-character-in-a-string/submissions/
//TC - O(N)
//SC - O(1)
public class FirstUniqueCharacterInString {

    public int firstUniqChar(String s) {

        int count[] = new int[26];

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            count[c-'a']++;
        }

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(count[c-'a']==1){
                return i;
            }
        }

        return -1;
    }
}
