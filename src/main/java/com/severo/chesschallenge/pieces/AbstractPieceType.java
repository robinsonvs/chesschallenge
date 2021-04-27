package com.severo.chesschallenge.pieces;

import java.util.Objects;

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

    public abstract String pieceType();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPieceType pieceType = (AbstractPieceType) o;
        return line == pieceType.line &&
                column == pieceType.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(line, column);
    }
}
