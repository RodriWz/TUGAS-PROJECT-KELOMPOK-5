package javafxapplication1;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamId;
    private String name;
    private String coach;
    private List<String> players = new ArrayList<>();
    private int points = 0;

    public Team(String teamId, String name, String coach) {
        this.teamId = teamId;
        this.name = name;
        this.coach = coach;
    }

    public String getTeamId() {
        return teamId;
    }

    public String getName() {
        return name;
    }

    public String getCoach() {
        return coach;
    }

    public int getPoints() {
        return points;
    }

    public void addPlayer(String playerName) {
        players.add(playerName);
    }

    public void updatePoints(int points) {
        this.points += points;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public List<String> getPlayers() {
        return players;
    }
}
