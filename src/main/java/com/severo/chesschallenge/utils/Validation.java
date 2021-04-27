package com.severo.chesschallenge.utils;

import com.severo.chesschallenge.board.ChessBoard;
import com.severo.chesschallenge.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Validation {

    public static BoardPiecesTypeContainer validateInputs(String[] args) {
        int lines = Integer.parseInt(args[0]) + 1;
        int columns = Integer.parseInt(args[1]) + 1;

        String pieces = args[2];

        List<AbstractPieceType> pieceTypes = validatePiecesType(pieces);

        return new BoardPiecesTypeContainer(new ChessBoard(lines, columns), pieceTypes);
    }

    public static List<AbstractPieceType> validatePiecesType(String pieces) {
        String[] piecesQuantity = pieces.split(";");
        List<AbstractPieceType> piecesOk = new ArrayList<>();

        for (String pieceQuantity : piecesQuantity) {
            validatePiece(pieceQuantity, piecesOk);
        }

        return piecesOk;
    }

    public static void validatePiece(String pieceQuantity, List<AbstractPieceType> pieces) {
        String[] quantities = pieceQuantity.split(":");
        int quantity = Integer.parseInt(quantities[1]);

        for (int i = 0; i < quantity; i++) {
            pieces.add(validateType(quantities[0]));
        }
    }

    public static AbstractPieceType validateType(String pieceType) {
        switch (pieceType) {
            case "Queen":
                return new QueenPiece(0, 0);
            case "King":
                return new KingPiece(0, 0);
            case "Rook":
                return new RookPiece(0, 0);
            case "Bishop":
                return new BishopPiece(0, 0);
            case "Knight":
                return new KnightPiece(0, 0);
            default:
                throw new RuntimeException("Undefined Piece Type");
        }
    }

    public static AbstractPieceType validateType(String pieceType, int line, int column) {
        switch (pieceType) {
            case "Queen":
                return new QueenPiece(line, column);
            case "King":
                return new KingPiece(line, column);
            case "Knight":
                return new KnightPiece(line, column);
            case "Bishop":
                return new BishopPiece(line, column);
            case "Rook":
                return new RookPiece(line, column);
        }

        return null;
    }
}
