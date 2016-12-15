package com.rbrazuk.ross.tables;

public class Competition {

    private String mCaption;
    private String mLeagueTable;

    public Competition(String caption, String leagueTable) {
        mCaption = caption;
        mLeagueTable = leagueTable;
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
}
