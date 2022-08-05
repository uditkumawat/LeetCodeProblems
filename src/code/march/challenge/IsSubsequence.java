package code.march.challenge;

//TC - O(len of t string)
public class IsSubsequence {


    public static void main(String args[]){

        String s = "abc";
        String t = "ahbgdc";

        IsSubsequence obj = new IsSubsequence();

        System.out.println(obj.isSubsequence(s,t));
        System.out.println(obj.isSubsequence("axc",t));

    }
    public boolean isSubsequence(String s, String t) {

        if(s==null || s.length()==0){
            return true;
        }

        if(t==null || t.length()==0 || s.length()>t.length()){
            return false;
        }

        int sp = 0;
        int tp = 0;

        while(tp<t.length()){
            if(s.charAt(sp)==t.charAt(tp)){
                sp++;
            }
            tp++;
        }

        return sp==s.length() ? true:false;
    }
}
