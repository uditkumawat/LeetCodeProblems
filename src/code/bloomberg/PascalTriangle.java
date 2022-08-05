package code.bloomberg;

import java.util.ArrayList;
import java.util.List;

//TC - O(n^2)
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        res.add(temp);

        if(numRows==1){
            return res;
        }

        List<Integer> prev = null;

        for(int i=1;i<numRows;i++){
            temp = new ArrayList<>();
            prev = res.get(i-1);
            temp.add(1);
            for(int j=1;j<i;j++){
                temp.add(prev.get(j-1)+prev.get(j));
            }
            temp.add(1);
            res.add(temp);
        }

        return res;
    }
}
