package chesschallenge.pieces;

import com.severo.chesschallenge.pieces.BishopPiece;
import org.junit.Assert;
import org.junit.Test;

public class BishopPieceTest {


    @Test
    public void testCanAttackOne() {
        BishopPiece bishopFirst = new BishopPiece(5, 5);
        BishopPiece bishopSecond = new BishopPiece(7, 7);

        Assert.assertTrue(bishopFirst.canAttack(bishopSecond));
    }

    @Test
    public void testCanAttackTwo() {
        BishopPiece bishopFirst = new BishopPiece(5, 5);
        BishopPiece bishopSecond = new BishopPiece(6,6);

        Assert.assertTrue(bishopFirst.canAttack(bishopSecond));
    }

    @Test
    public void testCanAttackThree() {
        BishopPiece bishopFirst = new BishopPiece(5, 5);
        BishopPiece bishopSecond = new BishopPiece(4, 6);

        Assert.assertTrue(bishopFirst.canAttack(bishopSecond));
    }

    @Test
    public void testCanAttackFour() {
        BishopPiece bishopFirst = new BishopPiece(5, 5);
        BishopPiece bishopSecond = new BishopPiece(3, 7);

        Assert.assertTrue(bishopFirst.canAttack(bishopSecond));
    }

    @Test
    public void testCanAttackFive() {
        BishopPiece bishopFirst = new BishopPiece(5, 5);
        BishopPiece bishopSecond = new BishopPiece(7, 3);

        Assert.assertTrue(bishopFirst.canAttack(bishopSecond));
    }

    @Test
    public void testCanAttackSix() {
        BishopPiece bishopFirst = new BishopPiece(5, 5);
        BishopPiece bishopSecond = new BishopPiece(6, 4);

        Assert.assertTrue(bishopFirst.canAttack(bishopSecond));
    }

    @Test
    public void testCanAttackSeven() {
        BishopPiece bishopFirst = new BishopPiece(5, 5);
        BishopPiece bishopSecond = new BishopPiece(4, 4);

        Assert.assertTrue(bishopFirst.canAttack(bishopSecond));
    }

    @Test
    public void testCanAttackEight() {
        BishopPiece bishopFirst = new BishopPiece(5, 5);
        BishopPiece bishopSecond = new BishopPiece(3, 3);

        Assert.assertTrue(bishopFirst.canAttack(bishopSecond));
    }

    @Test
    public void testDoesNotCanAttack() {
        BishopPiece bishopFirst = new BishopPiece(1, 1);
        BishopPiece bishopSecont = new BishopPiece(8, 1);

        Assert.assertFalse(bishopFirst.canAttack(bishopSecont));
    }
}
