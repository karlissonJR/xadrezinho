package boardgame;

public class Piece {
    
    protected Position position;
    private Board board;

    public Piece(Board board) {
        this.board = board;
    }

    protected Board getBoard() {
        return board;
    }

    public boolean[][] possibleMoves() {
        boolean[][] moves = new boolean[3][3];

        return moves;
    }

}
