package chesschallenge.main;

import com.severo.chesschallenge.board.ChessBoard;
import com.severo.chesschallenge.solver.ChallengeSolver;
import com.severo.chesschallenge.utils.BoardContainer;
import com.severo.chesschallenge.utils.Validation;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainTest {

    @Ignore
    @Test
    public void testMainClassWithBoard7x7With2Kinds2Queens2Bishops1Knight() {
        BoardContainer boardContainer = Validation.validateInputs(new String[]{"7", "7", "K:2;Q:2;B:2;N:1"});

        List<Character> pieces = boardContainer.getPieceTypes();
        ChessBoard chessBoard = boardContainer.getBoard();

        Set<ChessBoard> actualConfigurations = ChallengeSolver.findPossibleSolutions(chessBoard, pieces, new HashSet<>(), new HashSet<>());

        Assert.assertEquals(3063828, actualConfigurations.size());
    }

    @Test
    public void testNQueenWithBoard8x8With8Queens() {
        BoardContainer boardContainer = Validation.validateInputs(new String[]{"8", "8", "Q:8"});

        List<Character> pieces = boardContainer.getPieceTypes();
        ChessBoard chessBoard = boardContainer.getBoard();

        Set<ChessBoard> actualConfigurations = ChallengeSolver.findPossibleSolutions(chessBoard, pieces, new HashSet<>(), new HashSet<>());

        Assert.assertEquals(92, actualConfigurations.size());
    }

    @Test
    public void testMainClassWithBoard3x3With2Kinds1Rook() {
        BoardContainer boardContainer = Validation.validateInputs(new String[]{"3", "3", "K:2;R:1"});

        List<Character> pieces = boardContainer.getPieceTypes();
        ChessBoard chessBoard = boardContainer.getBoard();

        Set<ChessBoard> actualConfigurations = ChallengeSolver.findPossibleSolutions(chessBoard, pieces, new HashSet<>(), new HashSet<>());

        Assert.assertEquals(4, actualConfigurations.size());
    }

    @Test
    public void testMainClassWithBoard4x4With4Knights2Rook() {
        BoardContainer boardContainer = Validation.validateInputs(new String[]{"4", "4", "N:4;R:2"});

        List<Character> pieces = boardContainer.getPieceTypes();
        ChessBoard chessBoard = boardContainer.getBoard();

        Set<ChessBoard> actualConfigurations = ChallengeSolver.findPossibleSolutions(chessBoard, pieces, new HashSet<>(), new HashSet<>());

        Assert.assertEquals(8, actualConfigurations.size());
    }
}
