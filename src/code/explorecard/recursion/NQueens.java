package code.explorecard.recursion;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/n-queens/solution/
//https://www.youtube.com/watch?v=05y82cP3bJo
//https://www.youtube.com/watch?v=-_wnZvsGjYA
public class NQueens {

    public static void main(String args[]){
        int n = 4;

        NQueens obj = new NQueens();

        List<List<String>> res = obj.solveNQueens(4);

        for(List<String> list:res){
            System.out.println("\nplacement");
            for(String str:list){
                System.out.println(str);
            }
            System.out.println("ends");
        }
    }
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> res = new ArrayList();
        int mat[][] = new int[n][n];
        solveNQueensUtil(n,mat,res,0);

        return res;
    }

    public void solveNQueensUtil(int n,int mat[][],List<List<String>> res,int row){

        if(row==n){
            List<String> temp = formString(mat);
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int col=0;col<n;col++){
            if(isSafeToPlaceQueen(mat,row,col)){
                mat[row][col] = 1;
                solveNQueensUtil(n,mat,res,row+1);
                mat[row][col] = 0;
            }
        }
    }

    public boolean isSafeToPlaceQueen(int mat[][],int row,int col){

        //left diagonal check
        int r = row-1;
        int c = col-1;
        while(r>=0 && c>=0){
            if(mat[r][c]==1){
                return false;
            }
            r--;
            c--;
        }

        //right digonal check
        r = row-1;
        c = col+1;

        while(r>=0 && c<mat[0].length){
            if(mat[r][c]==1){
                return false;
            }
            r--;
            c++;
        }

        r = row-1;
        c = col;
        while(r>=0){

            if(mat[r][c]==1){
                return false;
            }
            r--;
        }

        return true;
    }

    public List<String> formString(int mat[][]){

        List<String> res = new ArrayList<>();

        for(int i=0;i<mat.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<mat[i].length;j++){

                if(mat[i][j]==1){
                    sb.append("Q");
                }
                else{
                    sb.append(".");
                }
            }
            res.add(sb.toString());
        }

        return res;
    }
}
