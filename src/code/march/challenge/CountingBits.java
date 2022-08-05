package code.march.challenge;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=awxaRgUB4Kw
//https://leetcode.com/problems/counting-bits/
//TC - O(N)
//SC - O(N)
public class CountingBits {

    public static void main(String args[]){

        int num = 10;

        CountingBits obj = new CountingBits();

        List<Integer> res = obj.countBits(num);

        for(int n:res){
            System.out.print(n+" ");
        }
    }

    public List<Integer> countBits(int num){

        List<Integer> res = new ArrayList<>();
        res.add(0,0);

        for(int i=1;i<=num;i++){
            // x / 2 is x >> 1 and x % 2 is x & 1
            res.add(res.get(i>>1) + i%2);
        }

        return res;
    }
}
