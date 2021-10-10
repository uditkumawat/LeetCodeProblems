package code.top100;

import java.util.ArrayList;
import java.util.List;

public class Pascal {

    public static void main(String args[]){

        List<List<Integer>> lists = generate(5);

        for(List<Integer> list:lists){
            for(int n:list){
                System.out.print(n+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> lists = new ArrayList<>();

        lists.add(new ArrayList<>());
        lists.get(0).add(1);

        for(int i=1;i<numRows;i++){
            List<Integer> prevRow = lists.get(i-1);
            List<Integer> newRow = new ArrayList<>();

            newRow.add(1);
            for(int j=1;j<i;j++){
                newRow.add(prevRow.get(j-1)+prevRow.get(j));
            }
            newRow.add(1);

            lists.add(newRow);
        }

        return lists;
    }
}
