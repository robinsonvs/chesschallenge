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

            BoardContainer boardContainer = Validation.validateInputs(new String[]{"7", "7", "K:2;Q:2;B:2;N:1"});

            System.out.println("board 7x7 with 2 Kinds / 2 Queens / 2 Bishops / 1 Knight");

            List<Character> pieceTypes = boardContainer.getPieceTypes();
            ChessBoard board = boardContainer.getBoard();

            long beginTime = System.currentTimeMillis();
            Set<ChessBoard> configurationsOk = ChallengeSolver.findPossibleSolutions(board, pieceTypes, new HashSet<>(), new HashSet<>());
            long endTime = System.currentTimeMillis();

            System.out.println("Number of configurations: " + configurationsOk.size());
            System.out.println("Total time: " + (endTime - beginTime) + " ms");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
