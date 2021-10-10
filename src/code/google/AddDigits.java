package code.google;

import java.util.List;

/**
 * Given an integer num, repeatedly add all its digits until the result has only one digit, and return it.
 */
public class AddDigits {

    public static void main(String args[]){

        AddDigits obj = new AddDigits();
        int num = 38;
        System.out.println(obj.addDigits(num));
    }

    public int addDigits(int num) {

        while(num/10>=1){

            int ans = 0;
            while(num!=0){
                ans += num%10;
                num = num/10;
            }

            num = ans;
        }

        return num;
    }
}
