package com.severo.chesschallenge.solver;

import com.severo.chesschallenge.board.ChessBoard;
import com.severo.chesschallenge.pieces.AbstractPieceType;
import com.severo.chesschallenge.utils.Validation;

import java.util.ArrayList;
import java.util.List;

public class ChallengeSolver {

    public static List<ChessBoard> configuration(ChessBoard chessBoard, List<AbstractPieceType> pieceTypes, List<ChessBoard> configurationsOk) {
        if (pieceTypes.isEmpty()) {
            if (!configurationsOk.contains(chessBoard)) {
                configurationsOk.add(chessBoard);
                chessBoard.show();
            }
        } else {
            for (int i = 1; i < chessBoard.getLines(); i++) {
                for (int j = 1; j < chessBoard.getColumns(); j++) {
                    if (!pieceTypes.isEmpty()) {
                        AbstractPieceType pieceType = Validation.validateType(pieceTypes.get(0).pieceType(), i, j);

                        if (isSafeMove(pieceType, chessBoard)) {
                            configuration(chessBoard.positionOnBoard(pieceType), removeFirstPieceType(pieceTypes), configurationsOk);
                        }
                    }
                }
            }
        }

        return configurationsOk;
    }

    private static boolean isSafeMove(AbstractPieceType abstractPieceType, ChessBoard chessBoard) {
        return chessBoard.isSafeMove(abstractPieceType) && !chessBoard.getPiecesAlreadyUsed().contains(abstractPieceType);
    }

    private static List<AbstractPieceType> removeFirstPieceType(List<AbstractPieceType> pieceTypes) {
        List<AbstractPieceType> removePieceType = new ArrayList<>(pieceTypes);
        removePieceType.remove(0);

        return removePieceType;
    }

}
