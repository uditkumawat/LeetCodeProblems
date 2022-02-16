package code.google;

import java.util.Arrays;

//https://www.youtube.com/watch?v=rUVg2Vewbo8
public class MultiplyStrings {

    public static void main(String args[]){
        String num1 = "123";
        String num2 = "456";

        MultiplyStrings obj = new MultiplyStrings();

        System.out.println(obj.multiply(num1,num2));
    }
    public String multiply(String num1, String num2) {

        if(num1==null || num2==null || num1.equals("0") || num2.equals("0")){
            return "0";
        }

        int res[] = new int[num1.length()+num2.length()];

        Arrays.fill(res,0);

        int mul = 0;
        int carry = 0;
        int lsd = 0;

        for(int i=num1.length()-1;i>=0;i--){

            for(int j=num2.length()-1;j>=0;j--){

                //System.out.println(i+" "+j);
                int a = num1.charAt(i)-'0';
                int b = num2.charAt(j)-'0';

                mul = a*b + res[i+j+1];

                res[i+j+1] = mul % 10;
                res[i+j] += mul / 10;

            }
        }

        StringBuilder sb = new StringBuilder();

        for(int num:res){
            if(sb.length()==0 && num==0){
                continue;
            }
            sb.append(num);
        }

        return sb.toString();
    }
}
