package code.september2022.challenge;

//https://leetcode.com/problems/utf-8-validation/submissions/
//TC - O(N)
//SC - O(1)
//https://www.youtube.com/watch?v=3zyxpFPKkEU
public class UTF8validation {

    public boolean validUtf8(int[] data) {
        int remainingBytes = 0;

        for(int val:data){
            if(remainingBytes==0){

                if((val>>5) == 0b110){
                    remainingBytes = 1;
                }
                else if((val>>4) == 0b1110){
                    remainingBytes = 2;
                }
                else if((val>>3) == 0b11110){
                    remainingBytes = 3;
                }
                else if((val>>7)!=0){
                    return false;
                }
            }
            else{
                if((val>>6)==0b10){
                    remainingBytes--;
                }
                else{
                    return false;
                }
            }
        }

        return remainingBytes==0;
    }
}
