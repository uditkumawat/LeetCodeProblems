package code.microsoft;

//https://leetcode.com/problems/permutation-in-string/
//TC - O(s2.length())
//SC - O(26)
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {

        int count1[] = new int[26];
        int count2[] = new int[26];

        int left = 0;
        int right = 0;
        int len = s1.length();

        for(char c:s1.toCharArray()){
            count1[c-'a']++;
        }

        while(right<s2.length()){

            char c = s2.charAt(right);
            count2[c-'a']++;

            System.out.println("right "+right);

            while(right-left+1>len){

                System.out.println("right "+right+" left "+left);
                char cLeft = s2.charAt(left);
                count2[cLeft-'a']--;
                left++;
            }

            if(isPermutation(count1,count2)){
                return true;
            }

            right++;
        }

        return false;
    }

    private boolean isPermutation(int count1[],int count2[]){

        for(int i=0;i<26;i++){
            if(count1[i]!=count2[i]){
                return false;
            }
        }

        return true;
    }
}
