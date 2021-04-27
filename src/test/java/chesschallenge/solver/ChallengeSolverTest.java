package chesschallenge.solver;

import com.severo.chesschallenge.board.ChessBoard;
import com.severo.chesschallenge.pieces.AbstractPieceType;
import com.severo.chesschallenge.pieces.KingPiece;
import com.severo.chesschallenge.pieces.RookPiece;
import com.severo.chesschallenge.solver.ChallengeSolver;
import com.severo.chesschallenge.utils.BoardPiecesTypeContainer;
import com.severo.chesschallenge.utils.Validation;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChallengeSolverTest {

    @Test
    public void testBoardWith3x3With2Kings1Rook() {
        BoardPiecesTypeContainer boardPiecesTypeContainer = Validation.validateInputs(new String[]{"3", "3", "King:2;Rook:1"});
        List<AbstractPieceType> pieces = boardPiecesTypeContainer.getPieceTypes();
        ChessBoard chessBoard = boardPiecesTypeContainer.getBoard();

        List<ChessBoard> validConfigurations = new ArrayList<>();
        List<ChessBoard> actual = ChallengeSolver.configuration(chessBoard, pieces, validConfigurations);
        List<ChessBoard> expected = validConfigurationBoard3x3With2Kings1Rook();

        Assert.assertArrayEquals(actual.toArray(), expected.toArray());
    }

    private List<ChessBoard> validConfigurationBoard3x3With2Kings1Rook() {
        List<ChessBoard> configurations = new ArrayList<>(4);
        ChessBoard chessBoardOne = new ChessBoard(4, 4);
        chessBoardOne.setPiecesOnBoard(Arrays
                .asList(
                        new KingPiece(1, 1),
                        new KingPiece(1, 3),
                        new RookPiece(3, 2)));
        configurations.add(chessBoardOne);

        ChessBoard chessBoardTwo = new ChessBoard(4, 4);
        chessBoardOne.setPiecesOnBoard(Arrays
                .asList(
                        new KingPiece(1, 1),
                        new KingPiece(3, 1),
                        new RookPiece(2, 3)));
        configurations.add(chessBoardTwo);

        ChessBoard chessBoardThree = new ChessBoard(4, 4);
        chessBoardOne.setPiecesOnBoard(Arrays
                .asList(
                        new KingPiece(1, 3),
                        new KingPiece(3, 3),
                        new RookPiece(2, 1)));
        configurations.add(chessBoardThree);

        ChessBoard chessBoardFour = new ChessBoard(4, 4);
        chessBoardOne.setPiecesOnBoard(Arrays
                .asList(
                        new KingPiece(3, 1),
                        new KingPiece(3, 3),
                        new RookPiece(1, 2)));
        configurations.add(chessBoardFour);


        return configurations;
    }
}
