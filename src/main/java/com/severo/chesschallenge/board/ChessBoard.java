package com.severo.chesschallenge.board;

import com.severo.chesschallenge.pieces.AbstractPieceType;

import java.util.*;

public class ChessBoard {

    private final int lines;
    private final int columns;
    private final Set<AbstractPieceType> piecesAlreadyUsed;
    private final String[][] board;

    public ChessBoard(int lines, int columns) {
        this.lines = lines;
        this.columns = columns;
        this.piecesAlreadyUsed = new HashSet<>();
        this.board = new String[lines][columns];
    }

    public ChessBoard(int lines, int columns, Set<AbstractPieceType> abstractPieceTypes) {
        this.lines = lines;
        this.columns = columns;
        this.board = new String[lines][columns];
        this.piecesAlreadyUsed = abstractPieceTypes;
        setPiecesAlreadyUsed(this.board, this.piecesAlreadyUsed);
    }

    private void setPiecesAlreadyUsed(String[][] board, Set<AbstractPieceType> usedPieces) {
        for (AbstractPieceType abstractPieceType : usedPieces) {
            board[abstractPieceType.getLine()][abstractPieceType.getColumn()] = abstractPieceType.pieceType();
        }
    }

    public int getLines() {
        return lines;
    }

    public int getColumns() {
        return columns;
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
