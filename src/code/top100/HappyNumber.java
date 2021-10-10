package code.top100;

import java.util.HashSet;
import java.util.Set;

// https://www.youtube.com/watch?v=Egw03gI-Tf0
//TC - O(logn)

public class HappyNumber {

    public static void main(String args[]){

        int n = 82;

        System.out.println(isHappyNumber(n));
    }

    public static boolean isHappyNumber(int n){

        int sum = 0;
        Set<Integer> set = new HashSet<>();

        while(true){

            sum = 0;
            while(n!=0){
                int rem = n%10;
                sum = sum + rem*rem;
                n=n/10;
            }

            if(sum==1){
                return true;
            }

            if(set.contains(sum)){
                return false;
            }
            else{
                set.add(sum);
            }
            n = sum;
        }

    }
}
