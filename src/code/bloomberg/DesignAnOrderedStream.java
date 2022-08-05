package code.bloomberg;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/design-an-ordered-stream/submissions/
//TC - O(N)
//SC - O(N)
public class DesignAnOrderedStream {

    int ptr;
    String res[];
    public DesignAnOrderedStream(int n) {
        ptr = 0;
        res = new String[n];
    }

    public List<String> insert(int idKey, String value) {

        List<String> list = new ArrayList<>();
        res[idKey-1] = value;

        while(ptr<res.length && res[ptr]!=null){
            list.add(res[ptr]);
            ptr++;
        }

        return list;
    }
}
