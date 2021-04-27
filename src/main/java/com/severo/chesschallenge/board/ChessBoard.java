package com.severo.chesschallenge.board;

import com.severo.chesschallenge.pieces.AbstractPieceType;

import java.util.*;

public class ChessBoard {

    private final int lines;
    private final int columns;
    private List<AbstractPieceType> piecesAlreadyUsed;

    public ChessBoard(int lines, int columns) {
        this.lines = lines;
        this.columns = columns;
        this.piecesAlreadyUsed = new ArrayList<>();
    }

    public ChessBoard(int lines, int columns, List<AbstractPieceType> abstractPieceTypes) {
        this.lines = lines;
        this.columns = columns;
        this.piecesAlreadyUsed = setPiecesOnBoard(abstractPieceTypes);
    }

    public int getLines() {
        return lines;
    }

    public int getColumns() {
        return columns;
    }

    public List<AbstractPieceType> getPiecesAlreadyUsed() {
        return piecesAlreadyUsed;
    }

    public List<AbstractPieceType> setPiecesOnBoard(List<AbstractPieceType> abstractPieceTypes) {
        return new ArrayList<>(abstractPieceTypes);
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

    public String findPieceType(int line, int column) {
        return this.piecesAlreadyUsed.stream()
                .filter(p -> p.getColumn() == column && p.getLine() == line)
                .findFirst()
                .map(AbstractPieceType::pieceType)
                .orElse("x");
    }

    public ChessBoard positionOnBoard(AbstractPieceType pieceType) {
        List<AbstractPieceType> pieceTypes = new ArrayList<>(this.piecesAlreadyUsed);
        pieceTypes.add(pieceType);

        return new ChessBoard(lines, columns, pieceTypes);
    }


    public boolean isSafeMove(AbstractPieceType pieceTypeDestiny) {
        return this.piecesAlreadyUsed.stream().noneMatch(piece -> (piece.canAttack(pieceTypeDestiny) || pieceTypeDestiny.canAttack(piece)));
    }

    public boolean identicalPieces(List<AbstractPieceType> boardOne, List<AbstractPieceType> boardTwo) {
        Set<AbstractPieceType> setOne = new HashSet<>(boardOne);
        Set<AbstractPieceType> setTwo = new HashSet<>(boardTwo);

        return setOne.containsAll(setTwo);
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
