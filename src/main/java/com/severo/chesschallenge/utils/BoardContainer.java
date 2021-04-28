package com.severo.chesschallenge.utils;

import com.severo.chesschallenge.board.ChessBoard;

import java.util.List;

public class BoardContainer {

    private final ChessBoard board;
    private final List<Character> pieceTypes;

    public BoardContainer(ChessBoard board, List<Character> pieceTypes) {
        this.board = board;
        this.pieceTypes = pieceTypes;
    }

    public ChessBoard getBoard() {
        return board;
    }

    public List<Character> getPieceTypes() {
        return pieceTypes;
    }

}
