package code.top100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII {

    Map<String, List<String>> map = new HashMap();

    public List<String> wordBreak(String s,List<String> wordDict){

        if(map.containsKey(s)){
            return map.get(s);
        }

        List<String> result = new ArrayList<>();

        if(wordDict.contains(s)){
            result.add(s);
        }

        for(int i=1;i<s.length();i++){
            String left = s.substring(0,i);
            if(wordDict.contains(left)){
                List<String> list = wordBreak(s.substring(i),wordDict);
                for(String str:list){
                    result.add(left+" "+str);
                }
            }
        }

        map.put(s,result);
        return result;
    }
}
