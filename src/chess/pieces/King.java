package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {

    public King(Board board, Color color) {
        super(board, color);
    }
    
    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position) {
        ChessPiece auxPiece = (ChessPiece) getBoard().piece(position);
        return auxPiece == null || auxPiece.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] moves = new boolean[getBoard().getRows()][getBoard().getColumns()];
        
        Position auxPosition = new Position(0, 0);

        auxPosition.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
            moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        auxPosition.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
            moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        auxPosition.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
            moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        auxPosition.setValues(position.getRow(), position.getColumn() - 1);
        if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
            moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }
        
        auxPosition.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
            moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        auxPosition.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
            moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        auxPosition.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
            moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        auxPosition.setValues(position.getRow() + 1, position.getColumn() + 1);
        if (getBoard().positionExists(auxPosition) && canMove(auxPosition)) {
            moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        return moves;
    }

}
