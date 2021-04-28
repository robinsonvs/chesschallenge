package com.severo.chesschallenge.pieces;

public abstract class AbstractPieceType {

    private final int line;
    private final int column;

    protected AbstractPieceType(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public abstract boolean canAttack(AbstractPieceType abstractPieceType);

    public abstract char pieceType();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractPieceType)) return false;

        AbstractPieceType that = (AbstractPieceType) o;

        if (line != that.line) return false;
        if (column != that.column) return false;
        return pieceType() == that.pieceType();

    }

    @Override
    public int hashCode() {
        int result = line;
        result = 103 * result + column;
        result = 103 * result + pieceType();
        return result;
    }
}
