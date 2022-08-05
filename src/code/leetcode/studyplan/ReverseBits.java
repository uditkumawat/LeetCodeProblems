package code.leetcode.studyplan;

//https://leetcode.com/problems/reverse-bits/
//TC - O(1)
public class ReverseBits {

    public int reverseBits(int n) {

        int num = 0;

        for(int i=0;i<32;i++){

            num = num<<1;
            num = num + (n&1);
            n = n>>>1;
        }

        return num;
    }
}
