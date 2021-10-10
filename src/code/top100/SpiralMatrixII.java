package code.top100;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixII {

    public static void main(String args[]){

        int arr[][] = {{1,2,3,4},
                       {5,6,7,8},
                      {9,10,11,12},
                        {13,14,15,16}};

        List<Integer> list = getSpiralForm(arr);

        for(int i:list){
            System.out.print(i+" ");
        }
    }

    public static List<Integer> getSpiralForm(int arr[][]){

        List<Integer> list = new ArrayList<>();
        int rows = arr.length;
        int cols = arr[0].length;

        int topRow = 0;
        int lastRow = rows-1;
        int firstColumn = 0;
        int lastColumn = cols-1;

        while(topRow<=lastRow && firstColumn<=lastColumn){

            for(int i=firstColumn;i<=lastColumn;i++){
                list.add(arr[topRow][i]);
            }
            topRow++;

            for(int i=topRow;i<=lastRow;i++){
                list.add(arr[i][lastColumn]);
            }
            lastColumn--;

            if(topRow<=lastRow) {
                for (int i = lastColumn; i >= firstColumn; i--) {
                    list.add(arr[lastRow][i]);
                }
                lastRow--;
            }

            if(firstColumn<=lastColumn) {
                for (int i = lastRow; i >= topRow; i--) {
                    list.add(arr[i][firstColumn]);
                }

                firstColumn++;
            }
        }
        return list;
    }
}
