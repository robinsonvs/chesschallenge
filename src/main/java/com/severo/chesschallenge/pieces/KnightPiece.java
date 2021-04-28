package com.severo.chesschallenge.pieces;

public class KnightPiece extends AbstractPieceType {

    public KnightPiece(int line, int column) {
        super(line, column);
    }

    @Override
    public boolean canAttack(AbstractPieceType destiny) {
        int dLine = Math.abs(this.getLine() - destiny.getLine());
        int dColumn = Math.abs(this.getColumn() - destiny.getColumn());
        return ((dLine == 2 && dColumn == 1) || (dLine == 1 && dColumn == 2));
    }

    @Override
    public char pieceType() {
        return 'N';
    }
}
