package com.severo.chesschallenge.solver;

import com.severo.chesschallenge.board.ChessBoard;
import com.severo.chesschallenge.pieces.AbstractPieceType;
import com.severo.chesschallenge.utils.Validation;

import java.util.ArrayList;
import java.util.List;

public class ChallengeSolver {

    public static List<ChessBoard> configuration(ChessBoard chessBoard, List<AbstractPieceType> pieceTypes, List<ChessBoard> configurationsOk) {
        if (chessBoard.isValidConfiguration()) {
            if (!configurationsOk.contains(chessBoard)) {
                configurationsOk.add(chessBoard);
                chessBoard.show();
            }
        } else {
            List<AbstractPieceType> tempPieces = new ArrayList<>(pieceTypes);
            for (int i = 1; i < chessBoard.getLines(); i++) {
                for (int j = 1; j < chessBoard.getColumns(); j++) {
                    if (!pieceTypes.isEmpty()) {
                        AbstractPieceType pieceType = Validation.validateType(pieceTypes.get(0).pieceType(), i, j);

                        if (chessBoard.isSafeMove(pieceType)) {
                            pieceTypes.remove(0);
                            ChessBoard positionedPierceBoard = chessBoard.positionOnBoard(pieceType);
                            configuration(positionedPierceBoard, pieceTypes, configurationsOk);
                            chessBoard.remove(pieceType);
                            pieceTypes.clear();
                            pieceTypes.addAll(tempPieces);
                        }
                    }
                }
            }
        }

        return configurationsOk;
    }

}
