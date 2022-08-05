package code.leetcode.studyplan75;

//https://leetcode.com/problems/is-subsequence/
//TC - O(len(s)+len(t))
//SC - O(1)
//https://www.youtube.com/watch?v=QmGQImp6vtM
//https://www.youtube.com/watch?v=PwQnydsKk_I
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {

        if(s==null && t==null || s.length()==0 && t.length()==0 || s.length()==0){
            return true;
        }
        int i = 0;
        int j = 0;

        while(i<t.length() ){
            if(j<s.length() && t.charAt(i)==s.charAt(j)){
                j++;
            }

            if(j==s.length()){
                return true;
            }
            i++;
        }

        return false;
    }
}
