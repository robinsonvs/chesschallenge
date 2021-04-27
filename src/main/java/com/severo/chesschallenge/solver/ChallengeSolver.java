package com.severo.chesschallenge.solver;

import com.severo.chesschallenge.board.ChessBoard;
import com.severo.chesschallenge.pieces.AbstractPieceType;
import com.severo.chesschallenge.utils.Factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ChallengeSolver {

    public static Set<ChessBoard> findPossibleSolutions(ChessBoard chessBoard, List<String> pieceTypes, Set<ChessBoard> configurationsOk, Set<ChessBoard> tested) {
        if (!pieceTypes.isEmpty()) {
            for (int i = 1; i < chessBoard.getLines(); i++) {
                for (int j = 1; j < chessBoard.getColumns(); j++) {
                    final AbstractPieceType pieceType = Factory.createNewPiece(pieceTypes.get(0), i, j);
                    if (chessBoard.isSafeMove(pieceType)) {
                        final ChessBoard board = chessBoard.positionOnBoard(pieceType);
                        if (pieceTypes.size() != 1) {
                            if (tested.add(board)) {
                                findPossibleSolutions(board, removeFirstPieceType(pieceTypes), configurationsOk, tested);
                            }
                        } else {
                            configurationsOk.add(board);
                        }
                    }
                }
            }
        }

        return configurationsOk;
    }

    private static List<String> removeFirstPieceType(List<String> pieceTypes) {
        final List<String> removePieceType = new ArrayList<>(pieceTypes);
        removePieceType.remove(0);

        return removePieceType;
    }

}
