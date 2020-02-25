package commentary;

import helper.MatchHelper;
import models.Match;
import models.Player;
import models.ScoreBoard;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CommentaryTest {
    MatchHelper matchHelper;
    Match match;
    ScoreBoard scoreBoard;
    List<Player> players;
    Commentary commentary;
    ByteArrayOutputStream outContent;
    String expectedCommentary;

    @Before
    public void init() {
        matchHelper = new MatchHelper();
        match = matchHelper.createMatch();
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        commentary = new Commentary();
        players = new ArrayList<>();
        players.add(new Player("Kirat Boli", Arrays.asList(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 93.0), 0, 0, false));
        players.add(new Player("NS Nodhi", Arrays.asList(1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 93.0), 0, 0, false));
        scoreBoard = new ScoreBoard(players.get(0), players.get(1), 0, 4, 0, 40, false);
    }

    @Test
    public void shouldGenerateOverCommentaryForGivenScoreBoard() {
        commentary.generateOverMessage(scoreBoard);
        expectedCommentary = "\n\n4 overs left. 40 runs to win\n";
        assertEquals(expectedCommentary, outContent.toString());
    }

    @Test
    public void shouldGenerateOverCommentaryForGivenScoreBoardWith1overLeft() {
        scoreBoard.setCurrentBallsPlayed(18);
        commentary.generateOverMessage(scoreBoard);
        expectedCommentary = "\n\n1 over left. 40 runs to win\n";
        assertEquals(expectedCommentary, outContent.toString());
    }

    @Test
    public void shouldGenerateBallCommentaryForGivenScoreBoard() {
        scoreBoard.setCurrentRunCount(2);
        commentary.generateBallByBallMessage(scoreBoard);
        expectedCommentary = "\n0.0 Kirat Boli scores 2 runs";
        assertEquals(expectedCommentary, outContent.toString());
    }

    @Test
    public void shouldGenerateBallCommentaryForGivenScoreBoardWith1run() {
        commentary.generateBallByBallMessage(scoreBoard);
        expectedCommentary = "\n0.0 Kirat Boli scores 0 run";
        assertEquals(expectedCommentary, outContent.toString());
    }

    @Test
    public void shouldGenerateBallCommentaryForGivenScoreBoardBallsCount() {
        scoreBoard.setCurrentBallsPlayed(6);
        commentary.generateBallByBallMessage(scoreBoard);
        expectedCommentary = "\n0.6 Kirat Boli scores 0 run";
        assertEquals(expectedCommentary, outContent.toString());
    }

    @Test
    public void shouldGenerateWonSummaryCommentaryWithGivenScoreBoard() {
        scoreBoard.setCurrentRunCount(40);
        scoreBoard.setCurrentBallsPlayed(20);
        commentary.generateWonMessage("Bengaluru", scoreBoard);
        expectedCommentary = "\n\nBengaluru won by 4 wickets and 20 balls remaining";
        assertEquals(expectedCommentary, outContent.toString());
    }

    @Test
    public void shouldGenerateLostSummaryCommentaryWithGivenScoreBoard() {
        scoreBoard.setCurrentRunsToWin(20);
        scoreBoard.setCurrentWicketLeft(0);
        scoreBoard.setCurrentBallsPlayed(20);
        commentary.generateLostMessage("Bengaluru", scoreBoard);
        expectedCommentary = "\n\nBengaluru Lost by 20 runs needed to win and 20 balls remaining";
        assertEquals(expectedCommentary, outContent.toString());
    }

    @Test
    public void shouldGeneratePlayerScoresCommentaryWithGivenScoreBoard() {
        players.get(0).setTotalBallsPlayed(5);
        players.get(0).setTotalRuns(10);
        players.get(1).setTotalBallsPlayed(15);
        players.get(1).setTotalRuns(10);
        commentary.generatePlayerScores(players, scoreBoard);
        expectedCommentary = "\nKirat Boli - 10* (5 balls)\nNS Nodhi - 10* (15 balls)";
        assertEquals(expectedCommentary, outContent.toString());
    }

    @Test
    public void shouldGeneratePlayerScoresCommentaryWithPlayerNotOnCrease() {
        players.get(0).setTotalBallsPlayed(5);
        players.get(0).setTotalRuns(10);
        players.get(1).setTotalBallsPlayed(15);
        players.get(1).setTotalRuns(10);
        scoreBoard.setCurrentNonStriker(null);
        commentary.generatePlayerScores(players, scoreBoard);
        expectedCommentary = "\nKirat Boli - 10* (5 balls)\nNS Nodhi - 10 (15 balls)";
        assertEquals(expectedCommentary, outContent.toString());
    }
}
