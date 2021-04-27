package com.severo.chesschallenge.pieces;

import com.severo.chesschallenge.utils.Factory;

import java.util.ArrayList;
import java.util.List;

public class KnightPiece extends AbstractPieceType {

    public KnightPiece(int line, int column) {
        super(line, column);
    }

    @Override
    public boolean canAttack(AbstractPieceType destiny) {
        int[] moviesX = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
        int[] moviesY = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
        int line = this.getLine();
        int column = this.getColumn();

        List<AbstractPieceType> movies = new ArrayList<>();

        for(int i = 0; i < 8; i++) {
            int destinyLine = line + moviesX[i];
            int destinyColumn = column + moviesY[i];

            if (destinyLine > 0 && destinyColumn > 0) {
                movies.add(Factory.createNewPiece(destiny.pieceType(), destinyLine, destinyColumn));
            }
        }

        return movies.contains(destiny);
    }

    @Override
    public String pieceType() {
        return "Knight";
    }
}
