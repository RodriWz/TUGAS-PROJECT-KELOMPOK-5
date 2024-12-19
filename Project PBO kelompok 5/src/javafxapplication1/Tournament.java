package javafxapplication1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Tournament {
    private List<Team> teams = new ArrayList<>();
    private List<Match> matches = new ArrayList<>();

    public List<Team> getTeams() {
        return teams;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void registerTeam(Team team) {
        teams.add(team);
    }

    public Team searchTeamById(String teamId) {
        return teams.stream().filter(team -> team.getTeamId().equals(teamId)).findFirst().orElse(null);
    }

    public void addMatch(Match match) {
        matches.add(match);
    }

    public Match getMatchById(String matchId) {
        return matches.stream().filter(match -> match.getMatchId().equals(matchId)).findFirst().orElse(null);
    }

   public List<Team> getStandings() {
    return teams.stream()
                .sorted((t1, t2) -> Integer.compare(t1.getPoints(), t2.getPoints())) 
                .collect(Collectors.toList());

    }
}
