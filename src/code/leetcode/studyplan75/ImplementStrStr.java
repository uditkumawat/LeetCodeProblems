package code.leetcode.studyplan75;

//https://leetcode.com/problems/implement-strstr/submissions/
//TC - O(l1*l2)
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {

        int l1 = haystack.length();
        int l2 = needle.length();

        int count = 0;

        for(int i=0;i<l1-l2+1;i++){

            count = 0;

            while(count<l2 && haystack.charAt(i+count)==needle.charAt(count)){
                count++;
            }

            if(count==l2){
                return i;
            }
        }

        return -1;
    }
}
