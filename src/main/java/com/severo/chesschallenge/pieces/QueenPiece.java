package com.severo.chesschallenge.pieces;

public class QueenPiece {

    private final int line;
    private final int column;


    public QueenPiece(int line, int column) {
        this.line = line;
        this.column = column;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }


    public boolean canAttack(QueenPiece destiny) {
        boolean sameLine = this.getLine() == destiny.getLine();
        boolean sameColumn = this.getColumn() == destiny.getColumn();
        boolean sameDiagonal = Math.abs(destiny.getLine() - this.getLine()) == Math.abs(destiny.getColumn() - this.getColumn());

        return sameLine || sameColumn || sameDiagonal;
    }
}
