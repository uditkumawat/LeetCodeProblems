package code.top100;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String args[]){

        int arr[][] ={{1,2,3,4},{5,6,7,8},{9,10,11,12}};

        List<Integer> list = spiralOrder(arr);

        for(int n:list){
            System.out.print(n+" ");
        }
    }
    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int startRow = 0;
        int startCol = 0;
        int endRow = rows-1;
        int endCol = cols-1;

        while(list.size()<rows*cols){

            for(int i=startCol;i<=endCol;i++){
                list.add(matrix[startRow][i]);
            }

         //   System.out.println(startRow+" "+startCol+" "+endRow+" "+endCol);
            startRow++;

            for(int i=startRow;i<=endRow;i++){
                list.add(matrix[i][endCol]);
            }

        //    System.out.println(startRow+" "+startCol+" "+endRow+" "+endCol);
            endCol--;

            if(startRow<=endRow) {
                for (int i = endCol; i >= startCol; i--) {
                    list.add(matrix[endRow][i]);
                }
            }

         //   System.out.println(startRow+" "+startCol+" "+endRow+" "+endCol);
            endRow--;

            if(startCol<=endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    list.add(matrix[i][startCol]);
                }
            }

           // System.out.println(startRow+" "+startCol+" "+endRow+" "+endCol);
            startCol++;

        }

        return list;
    }
}
