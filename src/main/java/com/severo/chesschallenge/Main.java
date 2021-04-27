package com.severo.chesschallenge;

import com.severo.chesschallenge.board.ChessBoard;
import com.severo.chesschallenge.solver.ChallengeSolver;
import com.severo.chesschallenge.utils.BoardContainer;
import com.severo.chesschallenge.utils.Validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        try {
            long beginTime = System.currentTimeMillis();

            BoardContainer boardContainer = Validation.validateInputs(new String[]{"7", "7", "King:2;Queen:2;Bishop:2;Knight:1"});
            ChessBoard board = boardContainer.getBoard();
            List<String> pieceTypes = boardContainer.getPieceTypes();

            Set<ChessBoard> configurationsOk = ChallengeSolver.configuration(board, pieceTypes, new HashSet<>());

            long endTime = System.currentTimeMillis();

            //configurationsOk.forEach(ChessBoard::show);

            System.out.println("Number of configurations: " + configurationsOk.size());
            System.out.println("Total time: " + (endTime - beginTime) + " ms");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
