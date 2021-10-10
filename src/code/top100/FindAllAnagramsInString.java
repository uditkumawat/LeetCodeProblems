package code.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {
        int slen = s.length();
        int plen = p.length();

        if(slen<plen){
            return new ArrayList<>();
        }

        Map<Character,Integer> pCount = new HashMap<>();
        Map<Character,Integer> sCount = new HashMap<>();

        for(char c:p.toCharArray()){
            pCount.put(c,pCount.getOrDefault(c,0)+1);
        }

        List<Integer> output = new ArrayList<>();

        for(int i=0;i<s.length();i++){

            char c = s.charAt(i);
            sCount.put(c,sCount.getOrDefault(c,0)+1);

            if(i>=plen){
                c = s.charAt(i-plen);
                if(sCount.get(c)==1){
                    sCount.remove(c);
                }
                else{
                    sCount.put(c,sCount.getOrDefault(c,0)-1);
                }
            }

            if(pCount==sCount){
                output.add(i-plen+1);
            }
        }

        return output;
    }
}
