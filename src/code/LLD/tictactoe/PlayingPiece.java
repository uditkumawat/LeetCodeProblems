package code.LLD.tictactoe;

/**
 * There are two types of pieces and both will have same attributes ,
 * but value will be different
 * that's why created a parent class
 */
public class PlayingPiece {

    PieceType pieceType;

    PlayingPiece(PieceType pieceType){
        this.pieceType = pieceType;
    }
}
