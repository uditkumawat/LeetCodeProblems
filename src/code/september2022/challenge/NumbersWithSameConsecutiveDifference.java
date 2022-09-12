package code.september2022.challenge;

import java.util.HashSet;
import java.util.Set;

//TC - O(2^N)
//sc-O(2^N)
public class NumbersWithSameConsecutiveDifference {

    public int[] numsSameConsecDiff(int n, int k) {

        if(n==0){
            return new int[]{0,1,2,3,4,5,6,7,8,9};
        }

        Set<Integer> res = new HashSet<Integer>();

        for(int num=1;num<10;num++){
            getNumbers(n-1,k,res,num);
        }

        int result[] = new int[res.size()];
        int index = 0;

        for(int num:res){
            result[index++] = num;
        }

        return result;
    }

    public void getNumbers(int n,int k,Set<Integer> res,int num){
        if(n<=0){
            res.add(num);
            return;
        }

        int lastDigits[] = new int[2];

        lastDigits[0] = num%10 + k;
        lastDigits[1] = num%10 - k;

        for(int digit:lastDigits){
            if(digit>=0 && digit<10){
                int newNum = num*10 + digit;
                getNumbers(n-1,k,res,newNum);
            }
        }

    }
}
