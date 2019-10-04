import com.github.dmitry_mingazov.connect_four.boards.StandardBoard;
import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class StandardBoardTest {
    @Test
    public void isLegalMoveShouldReturnTrue(){
        StandardBoard board = new StandardBoard();
        assertTrue("Column = width / 2 should return true", board.isLegalMove(board.getWidth()/2));
    }

}
