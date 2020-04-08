package com.example.covid.ui;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class User {
    public String userName;
    public String email;

    public User(){

    }
    public User(String userName,String email) throws JSONException {
        this.userName=userName;
        this.email=email;
    }

}
