package chesschallenge.pieces;

import com.severo.chesschallenge.pieces.QueenPiece;
import org.junit.Assert;
import org.junit.Test;

public class QueenPieceTest {


    @Test
    public void testCanAttackOne() {
        QueenPiece queenFirst = new QueenPiece(5, 5);
        QueenPiece queenSecond = new QueenPiece(7, 7);
        
        Assert.assertTrue(queenFirst.canAttack(queenSecond));
    }

    @Test
    public void testCanAttackTwo() {
        QueenPiece queenFirst = new QueenPiece(5, 5);
        QueenPiece queenSecond = new QueenPiece(6,6);

        Assert.assertTrue(queenFirst.canAttack(queenSecond));
    }

    @Test
    public void testCanAttackThree() {
        QueenPiece queenFirst = new QueenPiece(5, 5);
        QueenPiece queenSecond = new QueenPiece(4, 6);

        Assert.assertTrue(queenFirst.canAttack(queenSecond));
    }

    @Test
    public void testCanAttackFour() {
        QueenPiece queenFirst = new QueenPiece(5, 5);
        QueenPiece queenSecond = new QueenPiece(3, 7);

        Assert.assertTrue(queenFirst.canAttack(queenSecond));
    }

    @Test
    public void testCanAttackFive() {
        QueenPiece queenFirst = new QueenPiece(5, 5);
        QueenPiece queenSecond = new QueenPiece(7, 3);
        Assert.assertTrue(queenFirst.canAttack(queenSecond));
    }

    @Test
    public void testCanAttackSix() {
        QueenPiece queenFirst = new QueenPiece(5, 5);
        QueenPiece queenSecond = new QueenPiece(6, 4);
        Assert.assertTrue(queenFirst.canAttack(queenSecond));
    }

    @Test
    public void testCanAttackSeven() {
        QueenPiece queenFirst = new QueenPiece(5, 5);
        QueenPiece queenSecond = new QueenPiece(4, 4);

        Assert.assertTrue(queenFirst.canAttack(queenSecond));
    }

    @Test
    public void testCanAttackEight() {
        QueenPiece queenFirst = new QueenPiece(5, 5);
        QueenPiece queenSecond = new QueenPiece(3, 3);

        Assert.assertTrue(queenFirst.canAttack(queenSecond));
    }

    @Test
    public void testCanAttackNine() {
        QueenPiece queenFirst = new QueenPiece(5, 5);
        QueenPiece queenSecond = new QueenPiece(6, 5);

        Assert.assertTrue(queenFirst.canAttack(queenSecond));
    }

    @Test
    public void testCanAttackTen() {
        QueenPiece queenFirst = new QueenPiece(5, 5);
        QueenPiece queenSecond = new QueenPiece(7,5);

        Assert.assertTrue(queenFirst.canAttack(queenSecond));
    }

    @Test
    public void testCanAttackEleven() {
        QueenPiece queenFirst = new QueenPiece(5, 5);
        QueenPiece queenSecond = new QueenPiece(4, 5);

        Assert.assertTrue(queenFirst.canAttack(queenSecond));
    }

    @Test
    public void testCanAttackTwelve() {
        QueenPiece queenFirst = new QueenPiece(5, 5);
        QueenPiece queenSecond = new QueenPiece(3, 5);

        Assert.assertTrue(queenFirst.canAttack(queenSecond));
    }

    @Test
    public void testCanAttackThirTeen() {
        QueenPiece queenFirst = new QueenPiece(5, 5);
        QueenPiece queenSecond = new QueenPiece(5, 6);

        Assert.assertTrue(queenFirst.canAttack(queenSecond));
    }

    @Test
    public void testCanAttackFourTeen() {
        QueenPiece queenFirst = new QueenPiece(5, 5);
        QueenPiece queenSecond = new QueenPiece(5, 7);

        Assert.assertTrue(queenFirst.canAttack(queenSecond));
    }

    @Test
    public void testCanAttackFifteen() {
        QueenPiece queenFirst = new QueenPiece(5, 5);
        QueenPiece queenSecond = new QueenPiece(5, 4);

        Assert.assertTrue(queenFirst.canAttack(queenSecond));
    }

    @Test
    public void testCanAttackSixteen() {
        QueenPiece queenFirst = new QueenPiece(5, 5);
        QueenPiece queenSecond = new QueenPiece(5, 3);

        Assert.assertTrue(queenFirst.canAttack(queenSecond));
    }

    @Test
    public void testDoesNotCanAttack() {
        QueenPiece queenFirst = new QueenPiece(1, 1);
        QueenPiece queenSecond = new QueenPiece(3, 4);

        Assert.assertFalse(queenFirst.canAttack(queenSecond));
    }
}
