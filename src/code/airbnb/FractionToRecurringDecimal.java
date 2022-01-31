package code.airbnb;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {

    public static void main(String args[]){
        FractionToRecurringDecimal obj = new FractionToRecurringDecimal();
        System.out.println(obj.fractionToDecimal(4,333));
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0){
            return "0";
        }

        if(denominator==0){
            throw new ArithmeticException();
        }

        StringBuilder fraction = new StringBuilder();

        //if either of them is negative (not both, thats why XOR is used)
        if(numerator<0 ^ denominator<0){
            fraction.append("-");
        }

        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));

        fraction.append(String.valueOf(dividend/divisor));

        long remainder = dividend % divisor;

        if(remainder==0){
            return fraction.toString();
        }

        fraction.append(".");

        Map<Long,Integer> map = new HashMap<>();

        while(remainder!=0){
            if(map.containsKey(remainder)){
                fraction.insert(map.get(remainder),"(");
                fraction.append(")");
                break;
            }
            map.put(remainder,fraction.length());
            remainder = remainder * 10;
            fraction.append(String.valueOf(remainder/divisor));
            remainder = remainder % divisor;
        }

        return fraction.toString();
    }
}
