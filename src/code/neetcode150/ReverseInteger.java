package code.neetcode150;

//https://leetcode.com/problems/reverse-integer/submissions/
//TC  O(\log(x))O(log(x)). There are roughly \log_{10}(x)log
//10
//​
// (x) digits in xx.
//https://www.youtube.com/watch?v=B-Yc10DUaM8&list=PLtQWXpf5JNGJagakc_kBtOH5-gd8btjEW&index=5
public class ReverseInteger {

    public int reverse(int x) {

        long res = 0;

        while(x!=0){
            res = res*10 + x%10;
            if(res<Integer.MIN_VALUE || res>Integer.MAX_VALUE){
                return 0;
            }
            x = x/10;
        }

        return (int)res;
    }
}
