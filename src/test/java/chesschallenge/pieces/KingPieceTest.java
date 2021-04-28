package chesschallenge.pieces;

import com.severo.chesschallenge.pieces.KingPiece;
import org.junit.Assert;
import org.junit.Test;

public class KingPieceTest {

    @Test
    public void testCanAttackOne() {
        KingPiece kingFirst = new KingPiece(5, 5);
        KingPiece kingSecond = new KingPiece(5, 6);

        Assert.assertTrue(kingFirst.canAttack(kingSecond));
    }

    @Test
    public void testCanAttackTwo() {
        KingPiece kingFirst = new KingPiece(5, 5);
        KingPiece kingSecond = new KingPiece(6, 4);

        Assert.assertTrue(kingFirst.canAttack(kingSecond));
    }

    @Test
    public void testCanAttackThree() {
        KingPiece kingFirst = new KingPiece(5, 5);
        KingPiece kingSecond = new KingPiece(5, 4);

        Assert.assertTrue(kingFirst.canAttack(kingSecond));
    }

    @Test
    public void testCanAttackFour() {
        KingPiece kingFirst = new KingPiece(5, 5);
        KingPiece kingSecond = new KingPiece(4, 4);

        Assert.assertTrue(kingFirst.canAttack(kingSecond));
    }

    @Test
    public void testCanAttackFive() {
        KingPiece kingFirst = new KingPiece(5, 5);
        KingPiece kingSecond = new KingPiece(4, 5);

        Assert.assertTrue(kingFirst.canAttack(kingSecond));
    }

    @Test
    public void testCanAttackSix() {
        KingPiece kingFirst = new KingPiece(5, 5);
        KingPiece kingSecond = new KingPiece(4, 6);

        Assert.assertTrue(kingFirst.canAttack(kingSecond));
    }

    @Test
    public void testCanAttackSeven() {
        KingPiece kingFirst = new KingPiece(5, 5);
        KingPiece kingSecond = new KingPiece(5, 6);

        Assert.assertTrue(kingFirst.canAttack(kingSecond));
    }

    @Test
    public void testCanAttackEight() {
        KingPiece kingFirst = new KingPiece(5, 5);
        KingPiece kingSecond = new KingPiece(6, 6);

        Assert.assertTrue(kingFirst.canAttack(kingSecond));
    }

    @Test
    public void testDoesNotCanAttack() {
        KingPiece kingFirst = new KingPiece(1,1);
        KingPiece kingSecond = new KingPiece(8,8);

        Assert.assertFalse(kingFirst.canAttack(kingSecond));
    }
}
