package code.blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/encode-and-decode-strings/
//TC - O(N)
//SC - O(1)
public class EncodeAndDecodeStrings {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {

        if(strs.size()==0){
            return Character.toString((char)258);
        }

        String delimiter = Character.toString((char)257);
        StringBuilder sb = new StringBuilder();
        for(String str:strs){
            sb.append(str);
            sb.append(delimiter);
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String d = Character.toString((char)258);
        if(s.equals(d)){
            return new ArrayList<>();
        }
        d = Character.toString((char)257);
        return Arrays.asList(s.split(d));
    }
}
