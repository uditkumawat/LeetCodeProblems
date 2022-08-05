package code.leetcode.studyplan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle-ii/submissions/
//TC - O(N^2)
//SC - O(N)
public class PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {

        List<Integer> prev = Arrays.asList(1);

        for(int i=1;i<=rowIndex;i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j=1;j<i;j++){
                temp.add(prev.get(j-1)+prev.get(j));
            }
            temp.add(1);
            prev = temp;
        }

        return prev;
    }
}
