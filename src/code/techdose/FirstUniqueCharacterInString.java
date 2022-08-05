package code.techdose;

//https://leetcode.com/problems/first-unique-character-in-a-string/
//TC - O(N)
//SC - O(26)
public class FirstUniqueCharacterInString {

    public static void main(String args[]){

        String s = "loveleetcode";

        FirstUniqueCharacterInString obj = new FirstUniqueCharacterInString();

        System.out.println(obj.firstUniqChar(s));

    }
    public int firstUniqChar(String s) {

        int count[] = new int[26];

        for(char c:s.toCharArray()){
            count[c-'a']++;
        }

        for(int i=0;i<s.length();i++){
            if(count[s.charAt(i)-'a']==1){
                return i;
            }
        }

        return -1;
    }
}
