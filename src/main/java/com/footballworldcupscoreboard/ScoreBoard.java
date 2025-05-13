package com.footballworldcupscoreboard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ScoreBoard {
    private final List<Match> matches = new ArrayList<>();

    public void startGame(String homeTeam, String guestTeam) {
        Match match = new Match(homeTeam, guestTeam);
        matches.add(match);
    }

    public void endGame(String homeTeam, String guestTeam) {
        matches.removeIf(m -> m.getHomeTeam().equalsIgnoreCase(homeTeam) && m.getGuestTeam().equalsIgnoreCase(guestTeam));
        }

    public void updateScore(String homeTeam, String guestTeam, int homeScore, int guestScore) {
        for (Match match : matches) {
            if(match.getHomeTeam().equalsIgnoreCase(homeTeam) &&
            match.getGuestTeam().equalsIgnoreCase(guestTeam)) {
                match.setHomeTeamScore(homeScore);
                match.setGuestTeamScore(guestScore);
                return;
            }
        }
        throw new IllegalArgumentException("Match not found: " + homeTeam + "vs" + guestTeam);
    }

    public List<Match> getSummary() {
    return matches.stream()
            .sorted(
                    Comparator
                            .comparingInt(Match::getTotalScore)
                            .thenComparing(Match::getSequenceId)
                            .reversed())
            .toList();
    }

    public List<Match> getMatches() {
        return new ArrayList<>(matches);
    }
}


























