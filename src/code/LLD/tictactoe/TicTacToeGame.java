package code.LLD.tictactoe;

import javafx.util.Pair;

import java.util.*;

//https://gitlab.com/shrayansh8/interviewcodingpractise/-/tree/main/src/LowLevelDesign/LLDTicTacToe
public class TicTacToeGame {

    private Deque<Player> players;
    private Board board;

    public TicTacToeGame(int size){
        initialize(size);
    }

    private void initialize(int size){
        board = new Board(size);
        players = new LinkedList();

        PlayingPiece playingPieceX = new PlayingPieceX();
        Player player1 = new Player("U",playingPieceX);

        PlayingPiece playingPieceO = new PlayingPieceO();
        Player player2 = new Player("S",playingPieceO);

        players.add(player1);
        players.add(player2);
    }

    public String startGame(){

        boolean noWinner = true;
        while(noWinner){

            Player playerTurn = players.remove();

            board.printBoard();

            List<Pair<Integer,Integer>> freeSpaces = board.getFreeCells();
            if(freeSpaces.isEmpty()){
                System.out.println("No free spaces");
                noWinner = false;
                continue;
            }

            System.out.println("Player turn "+playerTurn.getName()+" and his symbol "+playerTurn.getPlayingPiece());

            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String values[] = s.split(",");
            int inputRow = Integer.parseInt(values[0]);
            int inputCol = Integer.parseInt(values[1]);

            boolean pieceAddedSuccessfully = board.addPiece(inputRow,inputCol, playerTurn.getPlayingPiece());
            if(!pieceAddedSuccessfully) {
                //player can not insert the piece into this cell, player has to choose another cell
                System.out.println("Incorredt possition chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean winner = isThereWinner(inputRow, inputCol, playerTurn.getPlayingPiece().pieceType);
            if(winner) {
                return playerTurn.getName();
            }
        }
        return "tie";
    }

    public boolean isThereWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<board.getSize();i++) {

            if(board.board[row][i] == null || board.board[row][i].pieceType != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<board.getSize();i++) {

            if(board.board[i][column] == null || board.board[i][column].pieceType != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<board.getSize();i++,j++) {
            if (board.board[i][j] == null || board.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=board.getSize()-1; i<board.getSize();i++,j--) {
            if (board.board[i][j] == null || board.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }

}
