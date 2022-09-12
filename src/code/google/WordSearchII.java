package code.google;

import java.util.ArrayList;
import java.util.List;

//TC - O(N*M * N*M)
//SC - O(N*M)
// not optimized
public class WordSearchII {

    public static void main(String args[]){

        char board[][] = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};

        List<String> dict = new ArrayList<>();
        dict.add("oath");
        dict.add("pea");
        dict.add("eat");
        dict.add("rain");

        WordSearchII obj = new WordSearchII();

        List<String> words = obj.wordSearch(board,dict);

        for(String word:words){
            System.out.println(word);
        }
    }

    public List<String> wordSearch(char board[][],List<String> dict){

        List<String> res = new ArrayList<>();

        int rows = board.length;
        int cols = board[0].length;

        for(String word:dict){

            char temp[][] = reinitialize(board,rows,cols);
            for(int row=0;row<rows;row++){
                for(int col=0;col<cols;col++){
                    if(temp[row][col]==word.charAt(0) && searchWordUtil(temp,word,row,col,temp.length,temp[0].length,0)){
                        res.add(word);
                    }
                }
            }
        }

        return res;
    }

    private char[][] reinitialize(char board[][],int rows,int cols){
        char temp[][] = new char[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                temp[i][j] = board[i][j];
            }
        }
        return temp;
    }

    private boolean searchWordUtil(char board[][],String word,int row,int col,int rows,int cols,int index){

        if(index>=word.length()){
            return true;
        }

        if(!isValidMove(board,word,row,col,rows,cols,index)){
            return false;
        }

        char c = board[row][col];
        board[row][col] = '$';

        if(searchWordUtil(board,word,row+1,col,rows,cols,index+1) ||
                searchWordUtil(board,word,row,col+1,rows,cols,index+1) ||
                searchWordUtil(board,word,row-1,col,rows,cols,index+1)||
                searchWordUtil(board,word,row,col-1,rows,cols,index+1)){
            return true;
        }

        board[row][col] = c;
        return false;
    }

    private boolean isValidMove(char board[][],String word,int row,int col,int rows,int cols,int index){
        if(row<0 || row>=rows || col<0 || col>=cols || board[row][col]!=word.charAt(index)){
            return false;
        }
        return true;
    }
}
