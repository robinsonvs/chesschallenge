package com.severo.chesschallenge.utils;

import com.severo.chesschallenge.board.ChessBoard;
import com.severo.chesschallenge.pieces.AbstractPieceType;

import java.util.List;

public class BoardPiecesTypeContainer {

    private ChessBoard board;
    private List<AbstractPieceType> pieceTypes;

    public BoardPiecesTypeContainer(ChessBoard board, List<AbstractPieceType> pieceTypes) {
        this.board = board;
        this.pieceTypes = pieceTypes;
    }

    public ChessBoard getBoard() {
        return board;
    }

    public List<AbstractPieceType> getPieceTypes() {
        return pieceTypes;
    }

    public void setPieceTypes(List<AbstractPieceType> pieceTypes) {
        this.pieceTypes = pieceTypes;
    }
}
