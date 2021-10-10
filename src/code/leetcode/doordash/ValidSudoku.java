package code.leetcode.doordash;

import java.util.HashSet;

public class ValidSudoku {

    public static void main(String args[]){

        char board[][] = {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValid(board));
    }


    public static boolean isValid(char matrix[][]){
        if(matrix==null || matrix.length==0){
            return false;
        }
        HashSet<String> set = new HashSet<>();

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                char currChar = matrix[i][j];

                if(currChar!='.'){
                    if(!set.add(currChar+"found in row"+i)
                            || !set.add(currChar+"found in col"+j)
                            || !set.add(currChar+" found in box"+i+" "+j) ){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
