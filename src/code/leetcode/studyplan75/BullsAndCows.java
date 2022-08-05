package code.leetcode.studyplan75;

//https://leetcode.com/problems/bulls-and-cows/
//TC - O(N)
//SC - O(1)
//https://www.youtube.com/watch?v=sEGa8F2pMS8
public class BullsAndCows {

    public String getHint(String secret, String guess) {

        int s[] = new int[10];
        int g[] = new int[10];

        int bulls = 0;
        int cows = 0;


        for(int i=0;i<secret.length();i++){

            char sc = secret.charAt(i);
            char gc = guess.charAt(i);

            if(sc==gc){
                bulls++;
            }
            else{
                s[sc-'0']++;
                g[gc-'0']++;
            }
        }

        for(int i=0;i<10;i++){
            cows+=Math.min(s[i],g[i]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(bulls).append("A").append(cows).append("B");

        return sb.toString();
    }
}
