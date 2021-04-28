package chesschallenge.board;

import com.severo.chesschallenge.board.ChessBoard;
import com.severo.chesschallenge.pieces.BishopPiece;
import com.severo.chesschallenge.pieces.KingPiece;
import com.severo.chesschallenge.pieces.QueenPiece;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class ChessBoardTest {

    @Test
    public void twoIdenticalPieces() {
        KingPiece kingFirst = new KingPiece(1, 1);
        KingPiece kingSecond = new KingPiece(1, 1);

        Assert.assertEquals(kingFirst, kingSecond);
    }

    @Test
    public void twoDifferentPieces() {
        KingPiece king = new KingPiece(1, 1);
        BishopPiece bishop = new BishopPiece(1, 1);

        Assert.assertNotEquals(king, bishop);
    }

    @Test
    public void twoIdenticalBoards() {
        ChessBoard chessBoardFirst = new ChessBoard(6, 6, new ArrayList<>(Arrays.asList(new KingPiece(1, 1), new QueenPiece(2, 2))));
        ChessBoard chessBoardSecond = new ChessBoard(6, 6, new ArrayList<>(Arrays.asList(new KingPiece(1, 1), new QueenPiece(2, 2))));

        Assert.assertEquals(chessBoardFirst, chessBoardSecond);
    }

    @Test
    public void testDifferentHash() {
        QueenPiece queenPieceOne = new QueenPiece(1,1);
        QueenPiece queenPieceTwo = new QueenPiece(1,1);
        QueenPiece queenPieceThree = new QueenPiece(1,2);
        KingPiece kingPiece = new KingPiece(1,1);
        Assert.assertEquals(queenPieceOne.hashCode(), queenPieceTwo.hashCode());
        Assert.assertTrue(queenPieceOne.hashCode() != queenPieceThree.hashCode());
        Assert.assertTrue(queenPieceOne.hashCode() != kingPiece.hashCode());
    }
}
