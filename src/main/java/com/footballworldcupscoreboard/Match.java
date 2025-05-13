package com.footballworldcupscoreboard;

import java.time.LocalDateTime;

public class Match {

    private final String homeTeam;
    private final String guestTeam;
    private int homeTeamScore;
    private int guestTeamScore;
    private final LocalDateTime startTime;
    private static long sequence = 0;
    private final long sequenceId;

    public Match( String homeTeam, String guestTeam) {
        this.homeTeam = homeTeam;
        this.guestTeam = guestTeam;
        this.homeTeamScore = 0;
        this.guestTeamScore = 0;
        this.startTime = LocalDateTime.now();
        this.sequenceId = ++sequence;
    }

    public String getHomeTeam() {return homeTeam;}
    public String getGuestTeam() {return guestTeam;}
    public int getHomeTeamScore() {return homeTeamScore;}
    public int getGuestTeamScore() {return guestTeamScore;}
    public LocalDateTime getStartTime() {return startTime;}

    public int getTotalScore(){
        return homeTeamScore + guestTeamScore;
    }
    public void setHomeTeamScore(int newScore){
        this.homeTeamScore = newScore;
    }
    public void setGuestTeamScore(int newScore){
        this.guestTeamScore = newScore;
    }


    @Override
    public String toString() {
        return homeTeam + " " + homeTeamScore + " - " + guestTeam + " " + guestTeamScore;
    }

    public long getSequenceId() {return sequenceId;
    }
}







































