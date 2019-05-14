package com.tjeit.banklistfromserver02.datas;

import org.json.JSONException;
import org.json.JSONObject;

public class Bank {
    public int id;
    public String name;
    public String code;
    public String logo;

    public static Bank getBankFromJson(JSONObject bankJson) {
        Bank bankObject = new Bank();

        try {

            bankObject.id = bankJson.getInt("id");
            bankObject.code = bankJson.getString("code");
            bankObject.name = bankJson.getString("name");
            bankObject.logo = bankJson.getString("logo");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return bankObject;
    }
}
