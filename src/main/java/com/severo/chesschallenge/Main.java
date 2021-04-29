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
            runConfigOne();
            runConfigTwo();
            runConfigThree();
            runConfigFour();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private static void runConfigOne() {
        BoardContainer boardContainer = Validation.validateInputs(new String[]{"3", "3", "K:2;R:1"});
        System.out.println("board 3x3 with 2 Kinds / 1 Rook");

        List<Character> pieceTypes = boardContainer.getPieceTypes();
        ChessBoard board = boardContainer.getBoard();

        long beginTime = System.currentTimeMillis();
        Set<ChessBoard> configurationsOk = ChallengeSolver.findPossibleSolutions(board, pieceTypes, new HashSet<>(), new HashSet<>());
        long endTime = System.currentTimeMillis();

        printResults(beginTime, configurationsOk, endTime);
    }

    private static void runConfigTwo() {
        BoardContainer boardContainer = Validation.validateInputs(new String[]{"4", "4", "N:4;R:2"});
        System.out.println("board 4x4 with 4 Knights / 2 Rooks");

        List<Character> pieceTypes = boardContainer.getPieceTypes();
        ChessBoard board = boardContainer.getBoard();

        long beginTime = System.currentTimeMillis();
        Set<ChessBoard> configurationsOk = ChallengeSolver.findPossibleSolutions(board, pieceTypes, new HashSet<>(), new HashSet<>());
        long endTime = System.currentTimeMillis();

        printResults(beginTime, configurationsOk, endTime);
    }

    private static void runConfigThree() {
        BoardContainer boardContainer = Validation.validateInputs(new String[]{"8", "8", "Q:8"});
        System.out.println("board 8x8 with 8 Queens");

        List<Character> pieceTypes = boardContainer.getPieceTypes();
        ChessBoard board = boardContainer.getBoard();

        long beginTime = System.currentTimeMillis();
        Set<ChessBoard> configurationsOk = ChallengeSolver.findPossibleSolutions(board, pieceTypes, new HashSet<>(), new HashSet<>());
        long endTime = System.currentTimeMillis();

        printResults(beginTime, configurationsOk, endTime);
    }

    private static void runConfigFour() {
        BoardContainer boardContainer = Validation.validateInputs(new String[]{"7", "7", "K:2;Q:2;B:2;N:1"});
        System.out.println("board 7x7 with 2 Kinds / 2 Queens / 2 Bishops / 1 Knight");

        List<Character> pieceTypes = boardContainer.getPieceTypes();
        ChessBoard board = boardContainer.getBoard();

        long beginTime = System.currentTimeMillis();
        Set<ChessBoard> configurationsOk = ChallengeSolver.findPossibleSolutions(board, pieceTypes, new HashSet<>(), new HashSet<>());
        long endTime = System.currentTimeMillis();

        printResults(beginTime, configurationsOk, endTime);
    }

    private static void printResults(long beginTime, Set<ChessBoard> configurationsOk, long endTime) {
        System.out.println("Number of configurations: " + configurationsOk.size());
        System.out.println("Total time: " + (endTime - beginTime) + " ms");
        System.out.println("-------------------------------------------------------");
    }
}
