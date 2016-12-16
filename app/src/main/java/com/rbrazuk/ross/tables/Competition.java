package com.rbrazuk.ross.tables;

public class Competition {

    private String mCaption;
    private String mLeagueTable;
    private int mId;

    public Competition(String caption, String leagueTable, int id) {
        mCaption = caption;
        mLeagueTable = leagueTable;
        mId = id;
    }

    public String getCaption() {
        return mCaption;
    }

    public void setCaption(String caption) {
        mCaption = caption;
    }

    public String getLeagueTable() {
        return mLeagueTable;
    }

    public void setLeagueTable(String leagueTable) {
        mLeagueTable = leagueTable;
    }

    public int getId() {return mId;}

    public void setId(int id) {
        mId = id;
    }

    @Override
    public String toString() {
        return this.mCaption + " " + this.mLeagueTable;
    }
}
