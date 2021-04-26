package com.severo.chesschallenge.pieces;

public class WithoutPiece extends AbstractPieceType {

    public WithoutPiece(int line, int column) {
        super(line, column);
    }

    @Override
    public boolean canAttack(AbstractPieceType abstractPieceType) {
        return false;
    }

    @Override
    public String pieceType() {
        return "x";
    }
}
