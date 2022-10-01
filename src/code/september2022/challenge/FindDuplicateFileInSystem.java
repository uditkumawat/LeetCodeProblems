package code.september2022.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/find-duplicate-file-in-system/solution/
//TC - O(n * x) -> n strings of average length x is parsed
//SC - O(n * x) -> map and res sisze grows upto n * x
public class FindDuplicateFileInSystem {

    public List<List<String>> findDuplicate(String[] paths) {

        List<List<String>> res = new ArrayList();
        if(paths==null || paths.length==0){
            return res;
        }

        Map<String,List<String>> map = new HashMap();

        for(String path:paths){

            String tokens[] = path.split("\\s+");

            String directoryName = tokens[0];

            for(int i=1;i<tokens.length;i++){

                String file = tokens[i];
                int startingBracketIndex = file.indexOf("(");
                int endindBracketIndex = file.indexOf(")");

                String fileName = file.substring(0,startingBracketIndex);
                String content = file.substring(startingBracketIndex,endindBracketIndex);

                if(!map.containsKey(content)){
                    map.put(content,new ArrayList());
                }

                StringBuilder directoryPath = new StringBuilder();
                directoryPath.append(directoryName);
                directoryPath.append("/");
                directoryPath.append(fileName);

                map.get(content).add(directoryPath.toString());

            }
        }

        for(String key:map.keySet()){
            if(map.get(key).size()>1){
                res.add(map.get(key));
            }
        }

        return res;
    }
}
