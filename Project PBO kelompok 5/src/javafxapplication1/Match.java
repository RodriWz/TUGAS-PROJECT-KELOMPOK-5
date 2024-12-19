package javafxapplication1;

import java.time.LocalDate;

public class Match {
    private String matchId;
    private Team team1;
    private Team team2;
    private LocalDate matchDate;
    private int scoreTeam1;
    private int scoreTeam2;
    private boolean completed = false;

    public Match(String matchId, Team team1, Team team2, LocalDate matchDate) {
        this.matchId = matchId;
        this.team1 = team1;
        this.team2 = team2;
        this.matchDate = matchDate;
    }

    public String getMatchId() {
        return matchId;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setScores(int scoreTeam1, int scoreTeam2) {
        this.scoreTeam1 = scoreTeam1;
        this.scoreTeam2 = scoreTeam2;
        this.completed = true;
    }

    @Override
    public String toString() {
        return matchId + ": " + team1.getName() + " vs " + team2.getName() + " pada " + matchDate + " | Skor: " + scoreTeam1 + " - " + scoreTeam2;
    }
}
