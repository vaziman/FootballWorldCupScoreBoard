import com.footballworldcupscoreboard.Match;
import com.footballworldcupscoreboard.ScoreBoard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreBoardTest {

    private ScoreBoard scoreBoard;

    @BeforeEach
    void setUp() {
        scoreBoard = new ScoreBoard();
    }

    @Test
    void testStartGameWithZeroScores() {
        scoreBoard.startGame("Mexico", "Canada");
        List<Match> maches = scoreBoard.getMatches();
        assertEquals(1, maches.size());
        Match match = maches.get(0);
        assertEquals("Mexico", match.getHomeTeam());
        assertEquals("Canada", match.getGuestTeam());
        assertEquals(0, match.getHomeTeamScore());
        assertEquals(0, match.getGuestTeamScore());
    }

    @Test
    void testUpdateScore(){
        scoreBoard.startGame("Mexico", "Canada");
        scoreBoard.updateScore("Mexico", "Canada", 0, 5);

        Match match = scoreBoard.getMatches().get(0);
        assertEquals(0, match.getHomeTeamScore());
        assertEquals(5, match.getGuestTeamScore());
    }

    @Test
    void testEndGame(){
        scoreBoard.startGame("Mexico", "Canada");
        scoreBoard.endGame("Mexico", "Canada");

        assertEquals(0, scoreBoard.getMatches().size());
    }

    @Test
    void testGetSummaryMatchesWithSort() throws InterruptedException {

        scoreBoard.startGame( "Mexico", "Canada");
        scoreBoard.updateScore("Mexico", "Canada", 0, 5);

        scoreBoard.startGame("Spain", "Brazil");
        scoreBoard.updateScore("Spain", "Brazil", 10, 2);

        scoreBoard.startGame("Germany", "France");
        scoreBoard.updateScore("Germany", "France", 2, 2);

        scoreBoard.startGame( "Uruguay", "Italy");
        scoreBoard.updateScore("Uruguay", "Italy", 6, 6);

        scoreBoard.startGame( "Argentina", "Australia");
        scoreBoard.updateScore("Argentina", "Australia", 3, 1);

        List<Match> summary = scoreBoard.getSummary();

        summary.forEach(m ->
                System.out.println(m.getHomeTeam() + " " + m.getHomeTeamScore()
                        + " - " + m.getGuestTeam() + " " + m.getGuestTeamScore()
                        + " | Total: " + m.getTotalScore()
                        + " | Started at: " + m.getStartTime())
        );

        assertEquals("Uruguay", summary.get(0).getHomeTeam());
        assertEquals("Spain", summary.get(1).getHomeTeam());
        assertEquals("Mexico", summary.get(2).getHomeTeam());
        assertEquals("Argentina", summary.get(3).getHomeTeam());
        assertEquals("Germany", summary.get(4).getHomeTeam());

    }

    @Test
    void testUpdateScoreExceptionIfMatchNotFound(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            scoreBoard.updateScore("home", "guest", 0, 5);
        });
        assertTrue(exception.getMessage().contains("Match not found"));
    }

}
