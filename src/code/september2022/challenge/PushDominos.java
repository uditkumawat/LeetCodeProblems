package code.september2022.challenge;

//https://leetcode.com/problems/push-dominoes/submissions
//TC - O(N)
//SC - O(N)
//https://www.youtube.com/watch?v=2LcdnLGHUHE
public class PushDominos {

    public String pushDominoes(String dominos) {

        if(dominos==null || dominos.length()==0){
            return null;
        }

        int n = dominos.length();

        int left[] = new int[n];
        int nearestLeftIndex = -1;

        int right[] = new int[n];
        int nearestRightIndex = -1;

        for(int i=n-1;i>=0;i--){
            char c = dominos.charAt(i);

            if(c=='L'){
                nearestLeftIndex = i;
            }
            else if(c=='R'){
                nearestLeftIndex = -1;
            }
            left[i] = nearestLeftIndex;
        }

        for(int i=0;i<n;i++){
            char c = dominos.charAt(i);

            if(c=='R'){
                nearestRightIndex = i;
            }
            else if(c=='L'){
                nearestRightIndex = -1;
            }
            right[i] = nearestRightIndex;
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){

            if(dominos.charAt(i)=='.'){
                int leftPower = left[i]==-1?Integer.MAX_VALUE:Math.abs(i-left[i]);
                int rightPower = right[i]==-1?Integer.MAX_VALUE:Math.abs(right[i]-i);

                if(leftPower==rightPower){
                    sb.append(".");
                }
                else if(leftPower>rightPower){
                    sb.append("R");
                }
                else if(rightPower>leftPower){
                    sb.append("L");
                }
            }
            else{
                sb.append(dominos.charAt(i));
            }
        }

        return sb.toString();
    }
}
