package models;

public class MatchStatus {
    private Player currentStriker;
    private Player currentNonStriker;
    private int currentRunCount;
    private int currentWicketLeft;
    private int currentBallsPlayed;
    private int currentRunsToWin;
    private boolean currentPlayerIsOut;
    private int currentPlayerPosition;

    public MatchStatus(Player currentStriker, Player currentNonStriker, int currentRunCount, int currentWicketLeft,
                       int currentBallsPlayed, int currentRunsToWin, boolean currentPlayerIsOut, int currentPlayerPosition) {
        this.currentStriker = currentStriker;
        this.currentNonStriker = currentNonStriker;
        this.currentRunCount = currentRunCount;
        this.currentWicketLeft = currentWicketLeft;
        this.currentBallsPlayed = currentBallsPlayed;
        this.currentRunsToWin = currentRunsToWin;
        this.currentPlayerIsOut = currentPlayerIsOut;
        this.currentPlayerPosition = currentPlayerPosition;
    }

    public Player getCurrentStriker() {
        return currentStriker;
    }

    public void setCurrentStriker(Player currentStriker) {
        this.currentStriker = currentStriker;
    }

    public Player getCurrentNonStriker() {
        return currentNonStriker;
    }

    public void setCurrentNonStriker(Player currentNonStriker) {
        this.currentNonStriker = currentNonStriker;
    }

    public int getCurrentRunCount() {
        return currentRunCount;
    }

    public void setCurrentRunCount(int currentRunCount) {
        this.currentRunCount = currentRunCount;
    }

    public int getCurrentWicketLeft() {
        return currentWicketLeft;
    }

    public void setCurrentWicketLeft(int currentWicketLeft) {
        this.currentWicketLeft = currentWicketLeft;
    }

    public int getCurrentBallsPlayed() {
        return currentBallsPlayed;
    }

    public void setCurrentBallsPlayed(int currentBallsPlayed) {
        this.currentBallsPlayed = currentBallsPlayed;
    }

    public int getCurrentRunsToWin() {
        return currentRunsToWin;
    }

    public void setCurrentRunsToWin(int currentRunsToWin) {
        this.currentRunsToWin = currentRunsToWin;
    }

    public boolean isCurrentPlayerIsOut() {
        return currentPlayerIsOut;
    }

    public void setCurrentPlayerIsOut(boolean currentPlayerIsOut) {
        this.currentPlayerIsOut = currentPlayerIsOut;
    }

    public int getCurrentPlayerPosition() {
        return currentPlayerPosition;
    }

    public void setCurrentPlayerPosition(int currentPlayerPosition) {
        this.currentPlayerPosition = currentPlayerPosition;
    }
}