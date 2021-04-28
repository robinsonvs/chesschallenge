package com.severo.chesschallenge.pieces;

public class KingPiece extends AbstractPieceType {

    public KingPiece(int line, int column) {
        super(line, column);
    }

    @Override
    public boolean canAttack(AbstractPieceType destiny) {
        if (Math.abs(this.getLine() - destiny.getLine()) == 1 && Math.abs(this.getColumn() - destiny.getColumn()) == 1)
            return true;

        return ((this.getLine() == destiny.getLine() && Math.abs(this.getColumn() - destiny.getColumn()) == 1) ||
                (this.getColumn() == destiny.getColumn() && Math.abs(this.getLine() - destiny.getLine()) == 1));
    }

    @Override
    public char pieceType() {
        return 'K';
    }

}
