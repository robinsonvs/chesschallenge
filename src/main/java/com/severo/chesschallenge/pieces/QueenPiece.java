package com.severo.chesschallenge.pieces;

public class QueenPiece extends AbstractPieceType {

    public QueenPiece(int line, int column) {
        super(line, column);
    }

    @Override
    public boolean canAttack(AbstractPieceType destiny) {
        boolean sameLine = this.getLine() == destiny.getLine();
        boolean sameColumn = this.getColumn() == destiny.getColumn();
        boolean sameDiagonal = Math.abs(destiny.getLine() - this.getLine()) == Math.abs(destiny.getColumn() - this.getColumn());
        return sameLine || sameColumn || sameDiagonal;
    }

    @Override
    public char pieceType() {
        return 'Q';
    }
}
