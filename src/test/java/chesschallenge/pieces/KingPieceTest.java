package chesschallenge.pieces;

import com.severo.chesschallenge.pieces.KingPiece;
import org.junit.Assert;
import org.junit.Test;

public class KingPieceTest {

    @Test
    public void testCanAttack() {
        KingPiece kingFirst = new KingPiece(1,1);
        KingPiece kingSecond = new KingPiece(1,2);

        Assert.assertTrue(kingFirst.canAttack(kingSecond));
    }

    @Test
    public void testDoesNotCanAttack() {
        KingPiece kingFirst = new KingPiece(1,1);
        KingPiece kingSecond = new KingPiece(8,8);

        Assert.assertFalse(kingFirst.canAttack(kingSecond));
    }
}
