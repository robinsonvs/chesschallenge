package chesschallenge.pieces;

import com.severo.chesschallenge.pieces.KnightPiece;
import org.junit.Assert;
import org.junit.Test;

public class KnightPieceTest {


    @Test
    public void testCanAttackOne() {
        KnightPiece knightFirst = new KnightPiece(5, 5);
        KnightPiece knightSecond = new KnightPiece(7, 6);

        Assert.assertTrue(knightFirst.canAttack(knightSecond));
    }

    @Test
    public void testCanAttackTwo() {
        KnightPiece knightFirst = new KnightPiece(5, 5);
        KnightPiece knightSecond = new KnightPiece(6,7);

        Assert.assertTrue(knightFirst.canAttack(knightSecond));
    }

    @Test
    public void testCanAttackThree() {
        KnightPiece knightFirst = new KnightPiece(5, 5);
        KnightPiece knightSecond = new KnightPiece(4, 7);

        Assert.assertTrue(knightFirst.canAttack(knightSecond));
    }

    @Test
    public void testCanAttackFour() {
        KnightPiece knightFirst = new KnightPiece(5, 5);
        KnightPiece knightSecond = new KnightPiece(3, 6);

        Assert.assertTrue(knightFirst.canAttack(knightSecond));
    }

    @Test
    public void testCanAttackFive() {
        KnightPiece knightFirst = new KnightPiece(5, 5);
        KnightPiece knightSecond = new KnightPiece(3, 4);

        Assert.assertTrue(knightFirst.canAttack(knightSecond));
    }

    @Test
    public void testCanAttackSix() {
        KnightPiece knightFirst = new KnightPiece(5, 5);
        KnightPiece knightSecond = new KnightPiece(4, 3);

        Assert.assertTrue(knightFirst.canAttack(knightSecond));
    }

    @Test
    public void testCanAttackSeven() {
        KnightPiece knightFirst = new KnightPiece(5, 5);
        KnightPiece knightSecond = new KnightPiece(7, 4);

        Assert.assertTrue(knightFirst.canAttack(knightSecond));
    }

    @Test
    public void testCanAttackEight() {
        KnightPiece knightFirst = new KnightPiece(5, 5);
        KnightPiece knightSecond = new KnightPiece(6, 3);

        Assert.assertTrue(knightFirst.canAttack(knightSecond));
    }

    @Test
    public void testDoesNotCanAttack() {
        KnightPiece knightFirst = new KnightPiece(1, 1);
        KnightPiece knightSecond = new KnightPiece(8, 8);

        Assert.assertFalse(knightFirst.canAttack(knightSecond));
    }
}
