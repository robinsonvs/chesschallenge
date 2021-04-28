package com.severo.chesschallenge.pieces;

public class BishopPiece extends AbstractPieceType {

    public BishopPiece(int line, int column) {
        super(line, column);
    }

    @Override
    public boolean canAttack(AbstractPieceType destiny) {
        return Math.abs(destiny.getLine() - this.getLine()) == Math.abs(destiny.getColumn() - this.getColumn());
    }

    @Override
    public char pieceType() {
        return 'B';
    }
}
