package code.facebook;

import java.util.Arrays;

//SC - O(26)
//TC - o(order.length()+s.length())
public class CustomSortString {

    public static void main(String args[]){

        String order = "cbafg";
        String s = "abcd";

        CustomSortString obj = new CustomSortString();

        System.out.println(obj.customSortString(order,s));

    }
    public String customSortString(String order, String s) {

        int freq[] = new int[26];
        Arrays.fill(freq,0);

        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
        }

        StringBuilder sb = new StringBuilder();

        for(char c:order.toCharArray()){
            while(freq[c-'a']-->0){
                sb.append(c);
            }
        }

        for(char i='a';i<='z';i++){
            while(freq[i-'a']-->0){
                sb.append(i);
            }
        }

        return sb.toString();
    }
}
