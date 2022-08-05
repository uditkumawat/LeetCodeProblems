package code.april.challenge;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/encode-and-decode-tinyurl/solution/
public class TinyURL {

    public final String mapper = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public final int BASE = 62;
    public Map<String,String> map;
    public int num;

    TinyURL(){
        num = 1;
        map = new HashMap();
    }

    public static void main(String args[]){

        TinyURL obj = new TinyURL();

        System.out.println(obj.encode("leetcode"));

    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

        String encodedString = encode(num++);
        map.put(encodedString,longUrl);
        return encodedString;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }

    private String encode(int num){
        StringBuilder sb = new StringBuilder();
        while(num!=0){
            sb.append(mapper.charAt(num % BASE));
            num/=BASE;
        }
        return sb.toString();
    }
}
