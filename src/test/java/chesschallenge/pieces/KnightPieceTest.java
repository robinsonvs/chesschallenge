package chesschallenge.pieces;

import com.severo.chesschallenge.pieces.KnightPiece;
import org.junit.Assert;
import org.junit.Test;

public class KnightPieceTest {

    @Test
    public void testCanAttack() {
        KnightPiece knightFirst = new KnightPiece(1, 1);
        KnightPiece knightSecond = new KnightPiece(3, 2);

        Assert.assertTrue(knightFirst.canAttack(knightSecond));
    }

    @Test
    public void testDoesNotCanAttack() {
        KnightPiece knightFirst = new KnightPiece(1, 1);
        KnightPiece knightSecond = new KnightPiece(8, 8);

        Assert.assertFalse(knightFirst.canAttack(knightSecond));
    }
}
