package code.facebook;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {

    public static void main(String args[]){

        SequentialDigits obj = new SequentialDigits();

        int low = 1000;
        int high = 13000;
        List<Integer> res = obj.sequentialDigits(low,high);

        for(int num:res){
            System.out.print(num+" ");
        }
    }
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> res = new ArrayList<>();
        int minLength = String.valueOf(low).length();
        int maxLength = String.valueOf(high).length();
        String digits = "123456789";

        for(int length=minLength;length<=maxLength;length++){
            //index+length<10 ...as the digits are of length 10
            //otherwise, when we do index+length will give ArrayIndexOutOfBoundException
            for(int index=0;index<=digits.length()-length;index++){

                int num = Integer.parseInt(digits.substring(index,index+length));

                if(low<=num && num<high){
                    res.add(num);
                }
            }
        }

        return res;
    }
}
