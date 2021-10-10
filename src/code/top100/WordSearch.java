package code.top100;

/**
 * Time Complexity: \mathcal{O}(N \cdot 3 ^ L)O(N⋅3
 * L
 *  ) where NN is the number of cells in the board and LL is the length of the word to be matched.
 *
 * For the backtracking function, initially we could have at most 4 directions to explore, but further the choices are reduced into 3 (since we won't go back to where we come from). As a result, the execution trace after the first step could be visualized as a 3-ary tree, each of the branches represent a potential exploration in the corresponding direction. Therefore, in the worst case, the total number of invocation would be the number of nodes in a full 3-nary tree, which is about 3^L3
 * L
 *  .
 *
 * We iterate through the board for backtracking, i.e. there could be NN times invocation for the backtracking function in the worst case.
 *
 * As a result, overall the time complexity of the algorithm would be \mathcal{O}(N \cdot 3 ^ L)O(N⋅3
 * L
 *  ).
 *
 * Space Complexity: \mathcal{O}(L)O(L) where LL is the length of the word to be matched.
 *
 * The main consumption of the memory lies in the recursion call of the backtracking function. The maximum length of the call stack would be the length of the word. Therefore, the space complexity of the algorithm is \mathcal{O}(L)O(L).
 */
public class WordSearch {

    public static void main(String args[]){

        char board[][] = {{'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}};
        String word = "ABCB";

        System.out.println(exist(board,word));
    }
    public static boolean exist(char[][] board, String word) {

        boolean visited[][] = new boolean[board.length][board[0].length];

        for(int i=0;i<visited.length;i++){
            for(int j=0;j<visited[i].length;j++){
                visited[i][j] = false;
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(visited[i][j]==false && board[i][j]==word.charAt(0)){
                    if(backTrack(board,visited,i,j,word,0)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean backTrack(char board[][],boolean visited[][],int row,int col,String word,int wordIndex){

        if(wordIndex>=word.length()){
            return true;
        }

        if(row<0 || row==board.length || col<0 || col==board[0].length || visited[row][col]==true  || board[row][col]!=word.charAt(wordIndex) ){
            return false;
        }

        int dir[][] = {{0,-1},{-1,0},{0,1},{1,0}};

        visited[row][col] = true;

        for(int i=0;i<4;i++){

            int newRow = row+dir[i][0];
            int newCol = col+dir[i][1];

            if(backTrack(board,visited,newRow,newCol,word,wordIndex+1)){
                return true;
            }
        }

        visited[row][col] = false;

        return false;
    }
}
