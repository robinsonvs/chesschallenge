package com.severo.chesschallenge.utils;

import com.severo.chesschallenge.pieces.*;

public class Validation {

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
            default:
                throw new RuntimeException("Undefined Piece Type");
        }
    }
}
