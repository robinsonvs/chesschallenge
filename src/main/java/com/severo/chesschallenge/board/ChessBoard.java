package com.severo.chesschallenge.board;

import com.severo.chesschallenge.pieces.AbstractPieceType;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ChessBoard {

    private int lines;
    private int columns;
    private Set<AbstractPieceType> piecesAlreadyUsed;

    public ChessBoard(int lines, int columns) {
        this.lines = lines;
        this.columns = columns;
        this.piecesAlreadyUsed = new HashSet<>();
    }

    public ChessBoard(int lines, int columns, Set<AbstractPieceType> abstractPieceTypes) {
        this.lines = lines;
        this.columns = columns;
        this.piecesAlreadyUsed = new HashSet<>(abstractPieceTypes);
    }

    public int getLines() {
        return lines;
    }

    public int getColumns() {
        return columns;
    }

    public void show() {
        for (int i = 1; i < lines; i++) {
            for (int j = 1; j < columns; j++) {
                System.out.println(this.findPieceType(i, j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public ChessBoard positionOnBoard(AbstractPieceType pieceType) {
        Set<AbstractPieceType> pieceTypes = new HashSet<>(this.piecesAlreadyUsed);
        pieceTypes.add(pieceType);

        return new ChessBoard(lines, columns, pieceTypes);
    }

    public String findPieceType(int line, int column) {
        return this.piecesAlreadyUsed.stream()
                .filter(p -> p.getColumn() == column && p.getLine() == line)
                .findFirst()
                .map(AbstractPieceType::toString)
                .orElse("x");
    }

    public boolean isSafeMove(AbstractPieceType pieceTypeDestiny) {
        boolean canNotAttackOthers = this.piecesAlreadyUsed.stream().noneMatch(p -> (p.canAttack(pieceTypeDestiny) || pieceTypeDestiny.canAttack(p)));
        boolean isNotPositionOnBoard = !this.piecesAlreadyUsed.contains(pieceTypeDestiny);

        return canNotAttackOthers && isNotPositionOnBoard;
    }

    public boolean contains(AbstractPieceType pieceType) {
        return this.piecesAlreadyUsed.contains(pieceType);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessBoard that = (ChessBoard) o;
        return lines == that.lines &&
                columns == that.columns &&
                Objects.equals(piecesAlreadyUsed, that.piecesAlreadyUsed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines, columns, piecesAlreadyUsed);
    }
}
