package code.leetcode.studyplan75;

public class WordSearch {

    int dirs[][] = {{-1,0},{1,0},{0,1},{0,-1}};

    public boolean exist(char[][] board, String word) {

        if(board==null || board.length==0){
            return false;
        }

        if(word==null || word.length()==0){
            return true;
        }

        int rows = board.length;
        int cols = board[0].length;

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                char c = board[row][col];
                if(c==word.charAt(0) && dfs(board,row,col,rows,cols,0,word)){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char board[][],int row,int col,int rows,int cols,int index,String word){

        if(index>=word.length()){
            return true;
        }

        if(!isValid(board,row,col,rows,cols,index,word)){
            return false;
        }

        char c = board[row][col];
        board[row][col] = '$';

        for(int dir=0;dir<dirs.length;dir++){

            int newRow = row + dirs[dir][0];
            int newCol = col + dirs[dir][1];

            if(dfs(board,newRow,newCol,rows,cols,index+1,word)){
                return true;
            }
        }

        board[row][col] = c;
        return false;
    }

    private boolean isValid(char board[][],int row,int col,int rows,int cols,int index,String word){

        if(row<0 || row>=rows || col<0 || col>=cols || board[row][col]!=word.charAt(index)){
            return false;
        }
        return true;
    }
}
