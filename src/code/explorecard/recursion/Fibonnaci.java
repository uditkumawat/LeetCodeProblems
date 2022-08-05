package code.explorecard.recursion;

import java.util.HashMap;
import java.util.Map;

//TC - O(N)
public class Fibonnaci {

    Map<Integer,Integer> cache;
    Fibonnaci(){
        cache = new HashMap<>();
        cache.put(0,0);
        cache.put(1,1);
    }

    public static void main(String args[]){

        Fibonnaci obj = new Fibonnaci();

        System.out.println(obj.fib(6));
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
