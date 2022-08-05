package code.leetcode.studyplan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle/solution/
//TC - O(rows^2)
//SC - O(rows^2)
public class PascalTriangleI {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        res.add(Arrays.asList(1));
        res.add(Arrays.asList(1,1));

        for(int i=2;i<numRows;i++){
            List<Integer> prev = res.get(i-1);
            List<Integer> temp = new ArrayList<>();

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
