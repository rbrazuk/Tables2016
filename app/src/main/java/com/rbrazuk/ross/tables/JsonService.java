package com.rbrazuk.ross.tables;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonService {

    public ArrayList<Competition> getCompetitionsArrayList(String json) throws JSONException {

        JSONArray competitionsJsonArray = new JSONArray(json);
        ArrayList<Competition> competitionsArrayList = new ArrayList<>();

        for (int i = 0; i < competitionsJsonArray.length(); i++) {
            JSONObject comp = competitionsJsonArray.getJSONObject(i);

            String leagueTableLink = comp.getJSONObject("_links").getJSONObject("leagueTable").getString("href");

            competitionsArrayList.add(new Competition(comp.getString("caption"), leagueTableLink));
        }

        System.out.println(competitionsArrayList.toString());

        return competitionsArrayList;
    }
}
