package com.severo.chesschallenge.utils;

import com.severo.chesschallenge.board.ChessBoard;

import java.util.List;

public class BoardContainer {

    private ChessBoard board;
    private List<String> pieceTypes;

    public BoardContainer(ChessBoard board, List<String> pieceTypes) {
        this.board = board;
        this.pieceTypes = pieceTypes;
    }

    public ChessBoard getBoard() {
        return board;
    }

    public List<String> getPieceTypes() {
        return pieceTypes;
    }

    public void setPieceTypes(List<String> pieceTypes) {
        this.pieceTypes = pieceTypes;
    }
}
