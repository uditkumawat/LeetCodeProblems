package code.september2022.challenge;

//https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/
//https://www.youtube.com/watch?v=ttlNQ6YrdGs
//https://www.youtube.com/watch?v=xFnK4psa3Ek
//TC - O(N)
//SC - O(1)
public class ConcatenationOfConsecutiveBinaryNumbers {

    public int concatenatedBinary(int n) {

        final int MOD = 1000000007;
        int length = 0;
        long result = 0;

        for(int i=1;i<=n;i++){

            // from 2 to 3 - length of binary string is 2
            // from 4 to 7 - length of binary string is 3
            // from 8 to 15 - length of binary string is 4
            //so it means length is changing at every number which is even and having single bit set
            if((i & (i-1)) == 0){
                length++;
            }

            result = ((result << length) | i) % MOD;
        }

        return (int) result;
    }

}
