package commentary;

import models.Player;
import models.ScoreBoard;
import view.OutputDriver;

import java.util.List;

public class Commentary {
    OutputDriver outputDriver = new OutputDriver();

    public void generateOverMessage(ScoreBoard scoreBoard) {
        int oversLeft = 4 - (scoreBoard.getCurrentBallsPlayed() / 6);
        int runsNeededToWin = scoreBoard.getCurrentRunsToWin();
        outputDriver.print("\n" + oversLeft + " over" + getSuffixString(oversLeft) + " left. " + runsNeededToWin + " runs to win\n");
    }

    private String getSuffixString(int count) {
        if (count <= 1)
            return "";
        return "s";
    }

    public void generateBallByBallMessage(ScoreBoard scoreBoard) {
        int overs = scoreBoard.getCurrentBallsPlayed() / 6;
        int ballsCountOfCurrentOver = scoreBoard.getCurrentBallsPlayed() % 6;
        if (ballsCountOfCurrentOver == 0 && scoreBoard.getCurrentBallsPlayed() != 0) {
            ballsCountOfCurrentOver = 6;
            overs = overs - 1;
        }
        outputDriver.print(overs + "." + ballsCountOfCurrentOver + " " + scoreBoard.getCurrentStriker().getName() + " scores " + scoreBoard.getCurrentRunCount() + " run" + getSuffixString(scoreBoard.getCurrentRunCount()));
    }

    public void generateWonMessage(String playingTeam, ScoreBoard scoreBoard) {
        outputDriver.print("\n" + playingTeam + " won by " + scoreBoard.getCurrentWicketLeft() + " wicket" + getSuffixString(scoreBoard.getCurrentWicketLeft()) + " and " + (40 - scoreBoard.getCurrentBallsPlayed()) + " ball" + getSuffixString(scoreBoard.getCurrentBallsPlayed()) + " remaining");
    }

    public void generateLostMessage(String playingTeam, ScoreBoard scoreBoard) {
        outputDriver.print("\n" + playingTeam + " Lost by " + scoreBoard.getCurrentRunsToWin() + " run needed to win and " + (40 - scoreBoard.getCurrentBallsPlayed()) + " ball" + getSuffixString(scoreBoard.getCurrentBallsPlayed()) + " remaining");
    }

    public void generateScores(List<Player> players, ScoreBoard scoreBoard) {
        for (Player player : players) {
            outputDriver.print(player.getName() + " - " + player.getTotalRuns() + getPlayerOnCreaseSuffix(player, scoreBoard) + " (" + player.getTotalBallsPlayed() + " balls)");
        }
    }

    private String getPlayerOnCreaseSuffix(Player player, ScoreBoard scoreBoard) {
        if (!scoreBoard.onCrease(player))
            return "";
        return "*";
    }
}
