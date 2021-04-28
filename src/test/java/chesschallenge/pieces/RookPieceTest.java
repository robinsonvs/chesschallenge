package chesschallenge.pieces;

import com.severo.chesschallenge.pieces.RookPiece;
import org.junit.Assert;
import org.junit.Test;

public class RookPieceTest {


    @Test
    public void testCanAttackOne() {
        RookPiece rookFirst = new RookPiece(5, 5);
        RookPiece rookSecond = new RookPiece(6, 5);

        Assert.assertTrue(rookFirst.canAttack(rookSecond));
    }

    @Test
    public void testCanAttackTwo() {
        RookPiece rookFirst = new RookPiece(5, 5);
        RookPiece rookSecond = new RookPiece(7,5);

        Assert.assertTrue(rookFirst.canAttack(rookSecond));
    }

    @Test
    public void testCanAttackThree() {
        RookPiece rookFirst = new RookPiece(5, 5);
        RookPiece rookSecond = new RookPiece(4, 5);

        Assert.assertTrue(rookFirst.canAttack(rookSecond));
    }

    @Test
    public void testCanAttackFour() {
        RookPiece rookFirst = new RookPiece(5, 5);
        RookPiece rookSecond = new RookPiece(3, 5);

        Assert.assertTrue(rookFirst.canAttack(rookSecond));
    }

    @Test
    public void testCanAttackFive() {
        RookPiece rookFirst = new RookPiece(5, 5);
        RookPiece rookSecond = new RookPiece(5, 6);

        Assert.assertTrue(rookFirst.canAttack(rookSecond));
    }

    @Test
    public void testCanAttackSix() {
        RookPiece rookFirst = new RookPiece(5, 5);
        RookPiece rookSecond = new RookPiece(5, 7);

        Assert.assertTrue(rookFirst.canAttack(rookSecond));
    }

    @Test
    public void testCanAttackSeven() {
        RookPiece rookFirst = new RookPiece(5, 5);
        RookPiece rookSecond = new RookPiece(5, 4);

        Assert.assertTrue(rookFirst.canAttack(rookSecond));
    }

    @Test
    public void testCanAttackEight() {
        RookPiece rookFirst = new RookPiece(5, 5);
        RookPiece rookSecond = new RookPiece(5, 3);

        Assert.assertTrue(rookFirst.canAttack(rookSecond));
    }

    @Test
    public void testDoesNotCanAttack() {
        RookPiece rookFirst = new RookPiece(1, 1);
        RookPiece rookSecond = new RookPiece(7, 2);

        Assert.assertFalse(rookFirst.canAttack(rookSecond));
    }
}
