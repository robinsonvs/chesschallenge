package com.severo.chesschallenge;

import com.severo.chesschallenge.board.ChessBoard;
import com.severo.chesschallenge.pieces.AbstractPieceType;
import com.severo.chesschallenge.utils.BoardPiecesTypeContainer;
import com.severo.chesschallenge.utils.Validation;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        try {
            long beginTime = System.currentTimeMillis();
            long endTime = System.currentTimeMillis();

            BoardPiecesTypeContainer boardPiecesTypeContainer = Validation.validateInputs(args);
            ChessBoard board = boardPiecesTypeContainer.getBoard();

            List<AbstractPieceType> pieceTypes = boardPiecesTypeContainer.getPieceTypes();

            //solutionsSolver here ...
            System.out.println("Number of configurations: ");
            System.out.println("Total time: " + (endTime - beginTime) + " ms");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
