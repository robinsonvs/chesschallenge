package com.severo.chesschallenge.board;

import com.severo.chesschallenge.pieces.AbstractPieceType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChessBoard {

    private final int lines;
    private final int columns;
    private final List<AbstractPieceType> piecesAlreadyUsed;
    private final char[][] board;

    public ChessBoard(int lines, int columns) {
        this.lines = lines;
        this.columns = columns;
        this.piecesAlreadyUsed = new ArrayList<>();
        this.board = new char[lines][columns];
    }

    public ChessBoard(int lines, int columns, List<AbstractPieceType> abstractPieceTypes) {
        this.lines = lines;
        this.columns = columns;
        this.board = new char[lines][columns];
        this.piecesAlreadyUsed = abstractPieceTypes;
        setPiecesAlreadyUsed(this.board, this.piecesAlreadyUsed);
    }

    private void setPiecesAlreadyUsed(char[][] board, List<AbstractPieceType> usedPieces) {
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
        List<AbstractPieceType> pieceTypes = new ArrayList<>(this.piecesAlreadyUsed);
        pieceTypes.add(pieceType);

        return new ChessBoard(lines, columns, pieceTypes);
    }

    public boolean isSafeMove(AbstractPieceType pieceTypeDestiny) {
        boolean canNotAttackOthers = this.piecesAlreadyUsed.stream().noneMatch(p -> (p.canAttack(pieceTypeDestiny) || pieceTypeDestiny.canAttack(p)));
        boolean isNotPositionOnBoard = this.board[pieceTypeDestiny.getLine()][pieceTypeDestiny.getColumn()] == '\u0000';

        return canNotAttackOthers && isNotPositionOnBoard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChessBoard)) return false;

        ChessBoard board1 = (ChessBoard) o;

        if (lines != board1.lines) return false;
        if (columns != board1.columns) return false;
        return Arrays.deepEquals(board, board1.board);

    }

    @Override
    public int hashCode() {
        return 31 * Arrays.deepHashCode(board);
    }
}
