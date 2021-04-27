package com.severo.chesschallenge.solver;

import com.severo.chesschallenge.board.ChessBoard;
import com.severo.chesschallenge.pieces.AbstractPieceType;
import com.severo.chesschallenge.utils.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ChallengeSolver {

    public static Set<ChessBoard> configuration(ChessBoard chessBoard, List<String> pieceTypes, Set<ChessBoard> configurationsOk) {
        if (pieceTypes.isEmpty()) {
            if (!configurationsOk.contains(chessBoard)) {
                configurationsOk.add(chessBoard);
            }
        } else {
            for (int i = 1; i < chessBoard.getLines(); i++) {
                for (int j = 1; j < chessBoard.getColumns(); j++) {
                    AbstractPieceType pieceType = Factory.createNewPiece(pieceTypes.get(0), i, j);

                    if (chessBoard.isSafeMove(pieceType)) {
                        configuration(chessBoard.positionOnBoard(pieceType), removeFirstPieceType(pieceTypes), configurationsOk);
                    }
                }
            }
        }

        return configurationsOk;
    }

    private static List<String> removeFirstPieceType(List<String> pieceTypes) {
        List<String> removePieceType = new ArrayList<>(pieceTypes);
        removePieceType.remove(0);

        return removePieceType;
    }

}
