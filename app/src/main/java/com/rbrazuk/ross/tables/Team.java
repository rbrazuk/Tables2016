package com.rbrazuk.ross.tables;

/**
 * Created by Ross on 12/16/2016.
 */

public class Team {

    private String mName;
    private int position;
    private int points;

    public Team(String name, int position, int points) {
        mName = name;
        this.position = position;
        this.points = points;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
