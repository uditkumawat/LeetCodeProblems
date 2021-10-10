package code.top100;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String args[]){

        int numRows=10;
        List<List<Integer>> lists = getPattern(numRows);
        for(List<Integer> list:lists){
            System.out.println(list);
        }
    }

    public static List<List<Integer>> getPattern(int numRows){

        List<List<Integer>> lists = new ArrayList<>();

        for(int i=0;i<numRows;i++){
            List<Integer> list = new ArrayList<>();

            list.add(1);   // add 1 to 0th index
            for(int j=1;j<i;j++){
                List<Integer> prev = lists.get(i-1);   //get previous list
                list.add(prev.get(j-1)+prev.get(j));
            }
            if(i>0){
                list.add(1);       // add 1 to last index
            }

            lists.add(list);
        }
        return lists;
    }

}
