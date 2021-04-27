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

            //BoardContainer boardContainer = Validation.validateInputs(new String[]{"8", "8", "Queen:8"});
            BoardContainer boardContainer = Validation.validateInputs(new String[]{"7", "7", "King:2;Queen:2;Bishop:2;Knight:1"});
            //BoardContainer boardContainer = Validation.validateInputs(new String[]{"3", "3", "King:2;Rook:1"});
            //BoardContainer boardContainer = Validation.validateInputs(new String[]{"4", "4", "Knight:4;Rook:2"});

            ChessBoard board = boardContainer.getBoard();
            List<String> pieceTypes = boardContainer.getPieceTypes();

            Set<ChessBoard> configurationsOk = ChallengeSolver.configuration(board, pieceTypes, new HashSet<>(), new HashSet<>());

            long endTime = System.currentTimeMillis();

            System.out.println("Number of configurations: " + configurationsOk.size());
            System.out.println("Total time: " + (endTime - beginTime) + " ms");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
