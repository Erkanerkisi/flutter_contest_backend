package com.erkan.model;

public class Score implements Comparable {
    private String name;
    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(Object o) {
        Score _score = (Score) o;
        if (this.score > (_score.getScore()))
            return -1;
        else if (this.score < (_score.getScore()))
            return 1;
        else return 1;
    }
}
