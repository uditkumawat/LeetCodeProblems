package code.LLD.tictactoe;

public class Player {

    private String name;
    private PlayingPiece playingPiece;

    public Player(String name,PlayingPiece playingPiece){
        this.name = name;
        this.playingPiece = playingPiece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayingPiece(PlayingPiece playingPiece){
        this.playingPiece = playingPiece;
    }

    public PlayingPiece getPlayingPiece(){
        return this.playingPiece;
    }

}
