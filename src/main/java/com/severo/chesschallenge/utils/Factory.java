package com.severo.chesschallenge.utils;

import com.severo.chesschallenge.pieces.*;

public class Factory {

    public static AbstractPieceType createNewPiece(String name, int line, int column) {
        switch (name) {
            case "Queen":
                return new QueenPiece(line, column);
            case "King":
                return new KingPiece(line, column);
            case "Rook":
                return new RookPiece(line, column);
            case "Bishop":
                return new BishopPiece(line, column);
            case "Knight":
                return new KnightPiece(line, column);
        }

        return null;
    }
}
