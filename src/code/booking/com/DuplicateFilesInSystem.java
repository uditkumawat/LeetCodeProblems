package code.booking.com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/find-duplicate-file-in-system/solution/
//TC - O(n*x) - n strings of average length x is parsed
public class DuplicateFilesInSystem {

    public List<List<String>> findDuplicate(String[] paths) {

        Map<String,List<String>> map = new HashMap();

        for(String path:paths){

            String values[] = path.split(" ");

            for(int i=1;i<values.length;i++){

                String name_cont[] = values[i].split("\\(");

                name_cont[1] = name_cont[1].replace(")","");

                List<String> list = map.getOrDefault(name_cont[1],new ArrayList<String>());

                list.add(values[0]+"/"+name_cont[0]);

                map.put(name_cont[1],list);
            }
        }

        List<List<String>> res = new ArrayList<>();

        for(String key:map.keySet()){
            if(map.get(key).size()>1){
                res.add(map.get(key));
            }
        }

        return res;
    }
}
