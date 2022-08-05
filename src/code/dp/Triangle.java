package code.dp;

import java.util.List;

//https://leetcode.com/problems/triangle/solution/
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        if(triangle==null || triangle.size()==0){
            return 0;
        }

        List<Integer> prevRow = null;
        List<Integer> currRow = null;

        for(int row=1;row<triangle.size();row++){
            prevRow = triangle.get(row-1);
            currRow = triangle.get(row);
            System.out.println(prevRow);
            for(int col=0;col<=row;col++){
                int smallestAbove = Integer.MAX_VALUE;
                if(col>0){
                    smallestAbove = prevRow.get(col-1);
                }
                if(col<row){
                    smallestAbove = Math.min(smallestAbove,prevRow.get(col));
                }

                currRow.set(col,currRow.get(col)+smallestAbove);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0;i<currRow.size();i++){
            min = Math.min(currRow.get(i),min);
        }

        return min;
    }
}
