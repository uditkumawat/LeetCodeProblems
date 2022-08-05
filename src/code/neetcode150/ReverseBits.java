package code.neetcode150;

//https://leetcode.com/problems/reverse-bits/submissions/
public class ReverseBits {

    public int reverseBits(int n) {

        int num = 0;

        for(int i=0;i<32;i++){
            num<<=1;
            num = num + (n&1);
            n>>>=1;
        }

        return num;
    }
}
