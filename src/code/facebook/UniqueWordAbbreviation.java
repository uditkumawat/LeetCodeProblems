package code.facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueWordAbbreviation {

    Map<String, List<String>> map;

    public UniqueWordAbbreviation(String[] dictionary) {
        map = new HashMap<>();
        init(dictionary);
    }

    public static void main(String args[]){
        String dict[] = {"deer", "door", "cake", "card"};
        UniqueWordAbbreviation obj = new UniqueWordAbbreviation(dict);
        System.out.println(obj.isUnique("dear"));
        System.out.println(obj.isUnique("cart"));
        System.out.println(obj.isUnique("cane"));
        System.out.println(obj.isUnique("make"));
        System.out.println(obj.isUnique("cake"));
    }
    private void init(String dictionary[]){
        for(String word:dictionary){
            updateAbbr(word);
        }
    }

    private void updateAbbr(String word){

        String abbr = getAbbr(word);

        if(!map.containsKey(abbr)){
            map.put(abbr,new ArrayList<>());
        }
        map.get(abbr).add(word);

    }

    private String getAbbr(String word){

        int len = word.length();

        StringBuilder sb = new StringBuilder();

        if(len<=2){
            sb.append(word);
        }
        else{
            sb.append(word.charAt(0)+String.valueOf(len-2)+word.charAt(len-1));
        }

        return sb.toString();
    }

    public boolean isUnique(String word) {
        String newWordAbbr = getAbbr(word);

        if(!map.containsKey(newWordAbbr)){
            return true;
        }

        if(map.containsKey(newWordAbbr)){
            List<String> list = map.get(newWordAbbr);
            for(String str:list){
                if(str.equals(word)){
                    return true;
                }
            }
        }
        return false;
    }
}
