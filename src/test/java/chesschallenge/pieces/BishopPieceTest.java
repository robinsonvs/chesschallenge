package chesschallenge.pieces;

import com.severo.chesschallenge.pieces.BishopPiece;
import org.junit.Assert;
import org.junit.Test;

public class BishopPieceTest {

    @Test
    public void testCanAttack() {
        BishopPiece bishopFirst = new BishopPiece(1, 1);
        BishopPiece bishopSecond = new BishopPiece(2, 2);

        Assert.assertTrue(bishopFirst.canAttack(bishopSecond));
    }

    @Test
    public void testDoesNotCanAttack() {
        BishopPiece bishopFirst = new BishopPiece(1, 1);
        BishopPiece bishopSecont = new BishopPiece(8, 1);

        Assert.assertFalse(bishopFirst.canAttack(bishopSecont));
    }
}
