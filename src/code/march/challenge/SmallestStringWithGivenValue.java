package code.march.challenge;

import java.util.Arrays;

//https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/
public class SmallestStringWithGivenValue {

    public static void main(String args[]){

        int n = 4;
        int k = 78;

        SmallestStringWithGivenValue obj = new SmallestStringWithGivenValue();

        System.out.println(obj.getSmallestString(n,k));
    }
    public String getSmallestString(int n, int k) {
        char result[] = new char[n];
        Arrays.fill(result,'a');
        k=k-n;

        for(int i=n-1;i>=0 && k>0;i--){
            int add = Math.min(k,25);
            result[i] = (char)(result[i]+add);
            k=k-add;
        }

        return new String(result);
    }
}
