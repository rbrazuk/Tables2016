package com.rbrazuk.ross.tables;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonService {

    public ArrayList<Competition> parseCompetitionsJson(String json) throws JSONException {

        JSONArray competitionsJsonArray = new JSONArray(json);
        ArrayList<Competition> competitionsArrayList = new ArrayList<>();

        for (int i = 0; i < competitionsJsonArray.length(); i++) {
            JSONObject comp = competitionsJsonArray.getJSONObject(i);

            System.out.println("comp id: " + comp.getInt("id"));

            if (comp.getInt("id") != 424 && comp.getInt("id") != 440 && comp.getInt("id") != 432 ) {
                String leagueTableLink = comp.getJSONObject("_links").getJSONObject("leagueTable").getString("href");

                competitionsArrayList.add(new Competition(comp.getString("caption"), leagueTableLink, comp.getInt("id")));
            }


        }

        System.out.println(competitionsArrayList.toString());

        return competitionsArrayList;
    }

    public ArrayList<Team> parseTableJson(String json) throws JSONException{
        ArrayList<Team> tableArrayList = new ArrayList<>();
        JSONObject tableObject = new JSONObject(json);
        JSONArray tableJsonArray = tableObject.getJSONArray("standing");

        for (int i = 0; i < tableJsonArray.length(); i++) {
            JSONObject jsonTeam = tableJsonArray.getJSONObject(i);
            Team team = new Team(jsonTeam.getString("teamName"), jsonTeam.getInt("position"), jsonTeam.getInt("points"));
            tableArrayList.add(team);
        }

        return  tableArrayList;
    }
}
