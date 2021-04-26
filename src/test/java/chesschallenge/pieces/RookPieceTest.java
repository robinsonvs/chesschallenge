package chesschallenge.pieces;

import com.severo.chesschallenge.pieces.RookPiece;
import org.junit.Assert;
import org.junit.Test;

public class RookPieceTest {

    @Test
    public void testCanAttack() {
        RookPiece rookFirst = new RookPiece(1, 1);
        RookPiece rookSecond = new RookPiece(1, 2);

        Assert.assertTrue(rookFirst.canAttack(rookSecond));
    }

    @Test
    public void testDoesNotCanAttack() {
        RookPiece rookFirst = new RookPiece(1, 1);
        RookPiece rookSecond = new RookPiece(7, 2);

        Assert.assertFalse(rookFirst.canAttack(rookSecond));
    }
}
