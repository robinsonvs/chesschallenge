package com.severo.chesschallenge.utils;

import com.severo.chesschallenge.board.ChessBoard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validation {
    private static final String SEMICOLON = ";";
    private static final String TWO_POINTS = ":";

    private Validation() {}

    public static BoardContainer validateInputs(String[] args) {
        int lines = Integer.parseInt(args[0]) + 1;
        int columns = Integer.parseInt(args[1]) + 1;

        String pieces = args[2];
        List<Character> pieceTypes = validatePiecesType(pieces);
        return new BoardContainer(new ChessBoard(lines, columns), pieceTypes);
    }

    private static List<Character> validatePiecesType(String pieces) {
        String[] piecesQuantity = pieces.split(SEMICOLON);
        List<Character> piecesOk = new ArrayList<>();
        Arrays.stream(piecesQuantity).forEach(p -> validatePiece(p, piecesOk));

        return piecesOk;
    }

    private static void validatePiece(String pieceQuantity, List<Character> pieces) {
        String[] quantities = pieceQuantity.split(TWO_POINTS);
        int quantity = Integer.parseInt(quantities[1]);

        for (int i = 0; i < quantity; i++) {
            pieces.add(quantities[0].charAt(0));
        }
    }

}
