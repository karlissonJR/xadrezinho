package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

    public Bishop(Board board, Color color) {
        super(board, color);
    }
    
    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] moves = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position auxPosition = new Position(0, 0);
        
        //Pra cima diagonal esquerda
        auxPosition.setValues(position.getRow() - 1, position.getColumn() - 1);
        while (getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
            moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
            auxPosition.setValues(auxPosition.getRow() - 1, auxPosition.getColumn() - 1);
        }

        if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
            moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        //Pra cima diagonal direita
        auxPosition.setValues(position.getRow() - 1, position.getColumn() + 1);
        while(getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
            moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
            auxPosition.setValues(auxPosition.getRow() - 1, auxPosition.getColumn() + 1);
        }

        if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
            moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        //Pra baixo diagonal esquerda
        auxPosition.setValues(position.getRow() + 1, position.getColumn() - 1);
        while(getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
            moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
            auxPosition.setValues(auxPosition.getRow() + 1, auxPosition.getColumn() - 1);
        }

        if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
            moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        //Pra baixo diagonal direita
        auxPosition.setValues(position.getRow() + 1, position.getColumn() + 1);
        while(getBoard().positionExists(auxPosition) && !getBoard().thereIsAPiece(auxPosition)) {
            moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
            auxPosition.setValues(auxPosition.getRow() + 1, auxPosition.getColumn() + 1);
        }

        if (getBoard().positionExists(auxPosition) && isThereOpponentPiece(auxPosition)) {
            moves[auxPosition.getRow()][auxPosition.getColumn()] = true;
        }

        return moves;
    }

}
