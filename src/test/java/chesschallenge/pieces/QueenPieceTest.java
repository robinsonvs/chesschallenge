package chesschallenge.pieces;

import com.severo.chesschallenge.pieces.QueenPiece;
import org.junit.Assert;
import org.junit.Test;

public class QueenPieceTest {

    @Test
    public void testCanAttack() {
        QueenPiece queenFirst = new QueenPiece(1, 1);
        QueenPiece queenSecond = new QueenPiece(2, 2);

        Assert.assertTrue(queenFirst.canAttack(queenSecond));
    }

    @Test
    public void testDoesNotCanAttack() {
        QueenPiece queenFirst = new QueenPiece(1, 1);
        QueenPiece queenSecond = new QueenPiece(3, 4);

        Assert.assertFalse(queenFirst.canAttack(queenSecond));
    }
}
