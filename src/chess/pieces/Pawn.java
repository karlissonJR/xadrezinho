package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color) {
        super(board, color);
    }
    
    @Override
    public String toString() {
        return "P";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] moves = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position auxPosition = new Position(0, 0);
        boolean firstPosition = false;
        
        if (getColor() == Color.WHITE) {
            auxPosition.setValues(position.getRow() - 1, position.getColumn());

            if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
                firstPosition = true;
                moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
            }

            auxPosition.setRow(auxPosition.getRow() - 1);

            if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition) && getMoveCount() == 0 && firstPosition) {
                moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
            }

            auxPosition.setValues(position.getRow() - 1, position.getColumn() - 1);
            if(getBoard().positionExists(auxPosition) && getBoard().thereIsAPiece(auxPosition) && isThereOpponentPiece(auxPosition)) {
                moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
            }

            auxPosition.setColumn(auxPosition.getColumn() + 2);
            if(getBoard().positionExists(auxPosition) && getBoard().thereIsAPiece(auxPosition) && isThereOpponentPiece(auxPosition)) {
                moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
            }
        } else {
            auxPosition.setValues(position.getRow() + 1, position.getColumn());

            if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
                firstPosition = true;
                moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
            }

            auxPosition.setRow(auxPosition.getRow() + 1);

            if (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition) && getMoveCount() == 0 && firstPosition) {
                moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
            }

            auxPosition.setValues(position.getRow() + 1, position.getColumn() - 1);
            if(getBoard().positionExists(auxPosition) && getBoard().thereIsAPiece(auxPosition) && isThereOpponentPiece(auxPosition)) {
                moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
            }

            auxPosition.setColumn(auxPosition.getColumn() + 2);
            if(getBoard().positionExists(auxPosition) && getBoard().thereIsAPiece(auxPosition) && isThereOpponentPiece(auxPosition)) {
                moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
            }
        }

        return moves;
    }
}
