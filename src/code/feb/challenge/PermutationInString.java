package code.feb.challenge;

import java.util.Arrays;

public class PermutationInString {

    public static void main(String args[]){

        String s1 = "abc";
        String s2 = "eidbacoo";

        PermutationInString obj = new PermutationInString();

        System.out.println(obj.checkInclusion(s1,s2));

    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }

        int counts1[] = new int[26];
        Arrays.fill(counts1,0);

        int len = s1.length();
        for(int i=0;i<s1.length();i++){
            char c = s1.charAt(i);
            counts1[c-'a']++;
        }


        int counts2[] = new int[26];
        Arrays.fill(counts2,0);

        int right = 0;
        int left = 0;

        for(;right<s2.length();right++){

            char c = s2.charAt(right);

            counts2[c-'a']++;

            if(right-left>=len){
                char oldChar = s2.charAt(left);
                counts2[oldChar-'a']--;
                left++;
            }

            if(compare(counts1,counts2)){
                return true;
            }
        }

        return false;
    }

    public boolean compare(int counts1[],int counts2[]){
        for(int i=0;i<26;i++){
            if(counts1[i]!=counts2[i]){
                return false;
            }
        }
        return true;
    }
}
