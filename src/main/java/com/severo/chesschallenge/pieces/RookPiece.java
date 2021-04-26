package com.severo.chesschallenge.pieces;

public class RookPiece extends AbstractPieceType {

    public RookPiece(int line, int column) {
        super(line, column);
    }

    @Override
    public boolean canAttack(AbstractPieceType destiny) {
        boolean sameLine = this.getLine() == destiny.getLine();
        boolean sameColumn = this.getColumn() == destiny.getColumn();

        return sameLine || sameColumn;
    }

    @Override
    public String pieceType() {
        return "Rook";
    }
}
