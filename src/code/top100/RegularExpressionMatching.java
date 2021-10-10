package code.top100;

//https://leetcode.com/problems/regular-expression-matching/discuss/191830/Java-DP-solution-beats-100-with-explanation
//TC - O(s.length()*p.length())
//SC - O(s.length()*p.length())
public class RegularExpressionMatching {

    public static void main(String args[]){
        String str = "aa";
        String pattern = "a*";

        System.out.println(isMatch(str,pattern));
    }
    public static boolean isMatch(String s, String p) {

        int rows = s.length()+1;
        int cols = p.length()+1;
        boolean T[][] = new boolean[rows][cols];

        T[0][0] = true;

        for(int i=1;i<p.length();i++){
            if(p.charAt(i-1)=='*'){
                T[0][i] = T[0][i-2];
            }
        }

        for(int i=1;i<rows;i++){
            for(int j=1;j<cols;j++){

                if(p.charAt(j-1)=='.' || s.charAt(i-1)==p.charAt(j-1)){
                    T[i][j] = T[i-1][j-1];
                }
                else if(p.charAt(j-1)=='*'){
                    if(p.charAt(j-2)!=s.charAt(i-1) && p.charAt(j-2)!='.'){
                        T[i][j] = T[i][j-2];
                    }
                    else{
                        T[i][j] = T[i][j-1] || T[i-1][j] || T[i][j-2];
                    }
                }
            }
        }

        return T[rows-1][cols-1];
    }
}
