package chesschallenge.board;

import com.severo.chesschallenge.board.ChessBoard;
import com.severo.chesschallenge.pieces.KingPiece;
import com.severo.chesschallenge.pieces.KnightPiece;
import com.severo.chesschallenge.pieces.QueenPiece;
import org.junit.Assert;
import org.junit.Test;

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
        KnightPiece knight = new KnightPiece(1, 1);

        Assert.assertNotEquals(king, knight);
    }

    @Test
    public void twoIdenticalBoards() {
        ChessBoard chessBoardFirst = new ChessBoard(5, 5, 2, Arrays.asList(new KingPiece(1, 1), new QueenPiece(2, 2)));
        ChessBoard chessBoardSecond = new ChessBoard(5, 5, 2, Arrays.asList(new KingPiece(1, 1), new QueenPiece(2, 2)));

        Assert.assertEquals(chessBoardFirst, chessBoardSecond);
    }
}
