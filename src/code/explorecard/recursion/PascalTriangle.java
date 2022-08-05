package code.explorecard.recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/pascals-triangle/
//TC - O(numRows^2)
//SC - O(numRows^2)
public class PascalTriangle {

    public static void main(String args[]){

        int numRows = 4;

        PascalTriangle obj = new PascalTriangle();

        System.out.println(obj.generate(numRows));
    }
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

        List<Integer> first = new ArrayList<>();
        first.add(1);

        res.add(first);

        for(int row=1;row<=numRows;row++){

            List<Integer> temp = new ArrayList<>();
            List<Integer> prevRow = res.get(row-1);
            temp.add(1);
            for(int col=1;col<row;col++){
                temp.add(prevRow.get(col-1)+prevRow.get(col));
            }
            temp.add(1);
            res.add(temp);
        }

        return res;
    }
}
