package com.metropolitan.cs330_pz_nemanjavilic4050_java;

import java.io.Serializable;

public class Player implements Serializable {

    public String playerName;
    public int score = 0;

    public Player() {

    }

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public Player(String playerName, int score) {
        this.playerName = playerName;
        this.score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String cricketerName) {
        this.playerName = cricketerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
