package chesschallenge.solver;

import com.severo.chesschallenge.board.ChessBoard;
import com.severo.chesschallenge.pieces.KingPiece;
import com.severo.chesschallenge.pieces.RookPiece;
import com.severo.chesschallenge.solver.ChallengeSolver;
import com.severo.chesschallenge.utils.BoardContainer;
import com.severo.chesschallenge.utils.Validation;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChallengeSolverTest {

    @Test
    public void testBoardWith3x3With2Kings1Rook() {
        BoardContainer boardContainer = Validation.validateInputs(new String[]{"3", "3", "King:2;Rook:1"});
        List<String> pieces = boardContainer.getPieceTypes();
        ChessBoard chessBoard = boardContainer.getBoard();

        Set<ChessBoard> validConfigurations = new HashSet<>();
        Set<ChessBoard> actual = ChallengeSolver.configuration(chessBoard, pieces, validConfigurations);
        Set<ChessBoard> expected = validConfigurationBoard3x3With2Kings1Rook();

        Assert.assertTrue(actual.equals(expected));
    }

    private Set<ChessBoard> validConfigurationBoard3x3With2Kings1Rook() {
        Set<ChessBoard> configurations = new HashSet<>(4);

        configurations.add(new ChessBoard(4, 4, new HashSet<>(Arrays
                .asList(
                        new KingPiece(1, 1),
                        new KingPiece(1, 3),
                        new RookPiece(3, 2)))));

        configurations.add(new ChessBoard(4, 4, new HashSet<>(Arrays
                .asList(
                        new KingPiece(1, 1),
                        new KingPiece(3, 1),
                        new RookPiece(2, 3)))));

        configurations.add(new ChessBoard(4, 4, new HashSet<>(Arrays
                .asList(
                        new KingPiece(1, 3),
                        new KingPiece(3, 3),
                        new RookPiece(2, 1)))));

        configurations.add(new ChessBoard(4, 4, new HashSet<>(Arrays
                .asList(
                        new KingPiece(3, 1),
                        new KingPiece(3, 3),
                        new RookPiece(1, 2)))));

        return configurations;
    }
}
