package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
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

            // EN PASSANT BRANCA
            if (position.getRow() == 3) {
                Position leftPosition = new Position(position.getRow(), position.getColumn() - 1);
                if (getBoard().positionExists(leftPosition) && isThereOpponentPiece(leftPosition) && getBoard().piece(leftPosition) == chessMatch.getEnPassantVunerable()) {
                    moves[leftPosition.getRow() - 1][leftPosition.getColumn()] = true;
                }

                Position rightPosition = new Position(position.getRow(), position.getColumn() + 1);
                if (getBoard().positionExists(rightPosition) && isThereOpponentPiece(rightPosition) && getBoard().piece(rightPosition) == chessMatch.getEnPassantVunerable()) {
                    moves[rightPosition.getRow() - 1][rightPosition.getColumn()] = true;
                }
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

            // EN PASSANT PRETA
            if (position.getRow() == 4) {
                Position leftPosition = new Position(position.getRow(), position.getColumn() - 1);
                if (getBoard().positionExists(leftPosition) && isThereOpponentPiece(leftPosition) && getBoard().piece(leftPosition) == chessMatch.getEnPassantVunerable()) {
                    moves[leftPosition.getRow() + 1][leftPosition.getColumn()] = true;
                }

                Position rightPosition = new Position(position.getRow(), position.getColumn() + 1);
                if (getBoard().positionExists(rightPosition) && isThereOpponentPiece(rightPosition) && getBoard().piece(rightPosition) == chessMatch.getEnPassantVunerable()) {
                    moves[rightPosition.getRow() + 1][rightPosition.getColumn()] = true;
                }
            }
        }

        return moves;
    }
}
