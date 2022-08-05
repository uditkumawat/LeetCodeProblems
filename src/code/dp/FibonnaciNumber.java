package code.dp;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/fibonacci-number/
//TC - O(N)
//SC- O(N)
public class FibonnaciNumber {

    Map<Integer,Integer> cache;
    FibonnaciNumber(){
        cache = new HashMap<>();
        cache.put(0,0);
        cache.put(1,1);

    }
    public static void main(String args[])
    {
        int n = 3;
        FibonnaciNumber obj = new FibonnaciNumber();

        System.out.print(obj.fib(n));
    }

    public int fib(int n) {
        if(n<2){
            return cache.get(n);
        }

        if(cache.containsKey(n)){
            return cache.get(n);
        }

        int result = fib(n-2)+fib(n-1);

        cache.put(n,result);

        return cache.get(n);

    }
}
