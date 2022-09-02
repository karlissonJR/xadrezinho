package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

    public Knight(Board board, Color color) {
        super(board, color);
    }
    
    @Override
    public String toString() {
        return "N";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] moves = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position auxPosition = new Position(0, 0);
    
        auxPosition.setValues(position.getRow() - 2, position.getColumn() - 1);
        if (getBoard().positionExists(auxPosition) && (!getBoard().thereIsAPiece(auxPosition) || isThereOpponentPiece(auxPosition))) {
            moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        auxPosition.setValues(position.getRow() - 2, position.getColumn() + 1);
        if (getBoard().positionExists(auxPosition) && (!getBoard().thereIsAPiece(auxPosition) || isThereOpponentPiece(auxPosition))) {
            moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        auxPosition.setValues(position.getRow() - 1, position.getColumn() + 2);
        if (getBoard().positionExists(auxPosition) && (!getBoard().thereIsAPiece(auxPosition) || isThereOpponentPiece(auxPosition))) {
            moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        auxPosition.setValues(position.getRow() + 1, position.getColumn() + 2);
        if (getBoard().positionExists(auxPosition) && (!getBoard().thereIsAPiece(auxPosition) || isThereOpponentPiece(auxPosition))) {
            moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        auxPosition.setValues(position.getRow() + 2, position.getColumn() - 1);
        if (getBoard().positionExists(auxPosition) && (!getBoard().thereIsAPiece(auxPosition) || isThereOpponentPiece(auxPosition))) {
            moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        auxPosition.setValues(position.getRow() + 2, position.getColumn() + 1);
        if (getBoard().positionExists(auxPosition) && (!getBoard().thereIsAPiece(auxPosition) || isThereOpponentPiece(auxPosition))) {
            moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        auxPosition.setValues(position.getRow() - 1, position.getColumn() - 2);
        if (getBoard().positionExists(auxPosition) && (!getBoard().thereIsAPiece(auxPosition) || isThereOpponentPiece(auxPosition))) {
            moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        auxPosition.setValues(position.getRow() + 1, position.getColumn() - 2);
        if (getBoard().positionExists(auxPosition) && (!getBoard().thereIsAPiece(auxPosition) || isThereOpponentPiece(auxPosition))) {
            moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        return moves;
    }

}
