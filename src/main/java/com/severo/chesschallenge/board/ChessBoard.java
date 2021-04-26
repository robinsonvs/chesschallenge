package com.severo.chesschallenge.board;

import com.severo.chesschallenge.pieces.AbstractPieceType;
import com.severo.chesschallenge.pieces.WithoutPiece;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ChessBoard {

    private final int lines;
    private final int columns;
    private final int initNumberPieces;
    private List<AbstractPieceType> piecesAlreadyUsed;
    private AbstractPieceType[][] boardHouses;

    public ChessBoard(int lines, int columns, int initNumberPieces) {
        this.lines = lines;
        this.columns = columns;
        this.initNumberPieces = initNumberPieces;

        this.piecesAlreadyUsed = new ArrayList<>();
        startPositions(lines, columns);
    }

    public ChessBoard(int lines, int columns, int initNumberPieces, List<AbstractPieceType> abstractPieceTypes) {
        this.lines = lines;
        this.columns = columns;
        this.initNumberPieces = initNumberPieces;

        startPositions(lines, columns);
        setBoardHouses(abstractPieceTypes);
    }

    private void startPositions(int lines, int columns) {
        this.boardHouses = new AbstractPieceType[lines][columns];

        for (int line = 1; line < lines; line++) {
            for (int column = 1; column < columns; column++) {
                this.boardHouses[line][column] = new WithoutPiece(line, column);
            }
        }
    }

    private AbstractPieceType[][] setBoardHouses(List<AbstractPieceType> abstractPieceTypes) {
        this.piecesAlreadyUsed = new ArrayList<>();

        for (AbstractPieceType pieceType : abstractPieceTypes) {
            this.boardHouses[pieceType.getLine()][pieceType.getColumn()] = pieceType;
            this.piecesAlreadyUsed.add(pieceType);
        }

        return this.boardHouses;
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
                System.out.println(this.boardHouses[i][j].toString() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public ChessBoard place(AbstractPieceType pieceType) {
        ChessBoard board = new ChessBoard(lines, columns, initNumberPieces, this.usedPositions());
        board.piecesAlreadyUsed.add(pieceType);
        board.boardHouses[pieceType.getLine()][pieceType.getColumn()] = pieceType;

        return board;
    }

    public List<AbstractPieceType> usedPositions() {
        List<AbstractPieceType> usedPositions = new ArrayList<>();

        for (int i = 1; i < lines; i++) {
            for (int j = 1; j < columns; j++) {
                AbstractPieceType place = this.boardHouses[i][j];

                if (!place.toString().equals("x")) {
                    usedPositions.add(place);
                }
            }
        }

        return usedPositions;
    }

    public boolean isSafeMove(AbstractPieceType pieceTypeDestiny) {
        return this.piecesAlreadyUsed.stream().noneMatch(piece -> (piece.canAttack(pieceTypeDestiny) || pieceTypeDestiny.canAttack(piece)));
    }

    public void remove(AbstractPieceType pieceType) {
        this.piecesAlreadyUsed.remove(pieceType);
        this.boardHouses[pieceType.getLine()][pieceType.getColumn()] = new WithoutPiece(pieceType.getLine(), pieceType.getColumn());
    }

    public boolean identicalPieces(AbstractPieceType[][] positionsOne, AbstractPieceType[][] positionsTwo) {
        for (int i = 1; i < lines; i++) {
            for (int j = 1; j < columns; j++) {
                if (!positionsOne[i][j].equals(positionsTwo[i][j])) {
                    return false;
                }
            }
        }

        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChessBoard that = (ChessBoard) o;
        return lines == that.lines &&
                columns == that.columns &&
                Arrays.equals(boardHouses, that.boardHouses);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(lines, columns);
        result = 31 * result + Arrays.hashCode(boardHouses);
        return result;
    }

    @Override
    public String toString() {
        return "ChessBoard{" +
                "lines=" + lines +
                ", columns=" + columns +
                ", initNumberPieces=" + initNumberPieces +
                ", piecesAlreadyUsed=" + piecesAlreadyUsed +
                ", boardHouses=" + Arrays.toString(boardHouses) +
                '}';
    }
}
