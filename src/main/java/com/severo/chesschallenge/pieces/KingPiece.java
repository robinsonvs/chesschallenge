package com.severo.chesschallenge.pieces;

import com.severo.chesschallenge.utils.Factory;

import java.util.ArrayList;
import java.util.List;

public class KingPiece extends AbstractPieceType {

    public KingPiece(int line, int column) {
        super(line, column);
    }

    @Override
    public boolean canAttack(AbstractPieceType destiny) {
        int[] moviesX = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
        int[] moviesY = new int[]{-1, 0, 1, 1, 1, 0, -1, -1};
        int line = this.getLine();
        int column = this.getColumn();

        List<AbstractPieceType> movies = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
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
        return "King";
    }

}
