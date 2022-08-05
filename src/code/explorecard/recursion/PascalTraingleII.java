package code.explorecard.recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalTraingleII {

    public static void main(String args[]){

        int rowIndex = 3;

        PascalTraingleII obj = new PascalTraingleII();
        List<Integer> res = obj.getRow(rowIndex);

        for(int num:res){
            System.out.print(num+" ");
        }
    }
    public List<Integer> getRow(int rowIndex) {

        List<Integer> res = new ArrayList<>();

        for(int colIndex=0;colIndex<=rowIndex;colIndex++){
            res.add(pascal(rowIndex,colIndex));
        }

        return res;
    }

    public int pascal(int row,int col){
        if(row==0 || col==0 || row==col){
            return 1;
        }

        return pascal(row-1,col-1)+pascal(row-1,col);
    }
}
