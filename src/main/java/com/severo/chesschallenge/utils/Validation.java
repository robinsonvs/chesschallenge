package com.severo.chesschallenge.utils;

import com.severo.chesschallenge.board.ChessBoard;

import java.util.ArrayList;
import java.util.List;

public class Validation {

    public static BoardContainer validateInputs(String[] args) {
        int lines = Integer.parseInt(args[0]) + 1;
        int columns = Integer.parseInt(args[1]) + 1;

        String pieces = args[2];

        List<String> pieceTypes = validatePiecesType(pieces);

        return new BoardContainer(new ChessBoard(lines, columns), pieceTypes);
    }

    public static List<String> validatePiecesType(String pieces) {
        String[] piecesQuantity = pieces.split(";");
        List<String> piecesOk = new ArrayList<>();

        for (String pieceQuantity : piecesQuantity) {
            validatePiece(pieceQuantity, piecesOk);
        }

        return piecesOk;
    }

    public static void validatePiece(String pieceQuantity, List<String> pieces) {
        String[] quantities = pieceQuantity.split(":");
        int quantity = Integer.parseInt(quantities[1]);

        for (int i = 0; i < quantity; i++) {
            pieces.add(quantities[0]);
        }
    }

}
