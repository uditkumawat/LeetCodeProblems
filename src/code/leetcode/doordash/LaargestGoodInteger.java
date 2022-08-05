package code.leetcode.doordash;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LaargestGoodInteger {

    public static void main(String args[]){

        LaargestGoodInteger obj = new LaargestGoodInteger();

        System.out.println(obj.largestGoodInteger("222244444666666600000"));
    }
    public String largestGoodInteger(String num) {

        if(num==null || num.length()<3){
            return "";
        }

        List<String> res = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<num.length()-3;i++){

            char c1 = num.charAt(i);
            char c2 = num.charAt(i+1);
            char c3 = num.charAt(i+2);

            if(c1==c2 && c2==c3){
                sb.append(c1).append(c2).append(c3);
                res.add(sb.toString());
            }
            sb = new StringBuilder();
        }


        Collections.sort(res);

        return res.isEmpty() ? "":res.get(res.size()-1);
    }
}
