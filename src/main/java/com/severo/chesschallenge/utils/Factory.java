package com.severo.chesschallenge.utils;

import com.severo.chesschallenge.pieces.*;

import static com.severo.chesschallenge.utils.DefaultConstants.*;

public class Factory {

    private Factory() {}

    public static AbstractPieceType createNewPiece(char type, int line, int column) {
        switch (type) {
            case QUEEN:
                return new QueenPiece(line, column);
            case KING:
                return new KingPiece(line, column);
            case ROOK:
                return new RookPiece(line, column);
            case BISHOP:
                return new BishopPiece(line, column);
            case KNIGHT:
                return new KnightPiece(line, column);
            default:
                return null;
        }
    }
}
