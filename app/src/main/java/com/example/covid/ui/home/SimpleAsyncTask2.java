package com.example.covid.ui.home;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SimpleAsyncTask2 extends  AsyncTask<Void,Void,String>{
    private String data;
    private StringBuilder sb;
    private URL url_;
    private JSONObject json;
    private String url ="http://newsapi.org/v2/top-headlines?country=tr&category=health&apiKey=b8867e244f204c9791848936070a7a34";
    @Override
    protected void onPreExecute() {
       //HaberlerViewModel.mText.setValue({Action:"Başlıyor"});
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            url_ = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url_.openConnection();
        } catch (IOException e) {
            Log.d("url","asdasdasd");
            e.printStackTrace();
        }
        BufferedReader br= null;
        try {
            InputStream inputStream =urlConnection.getInputStream();
            br = new BufferedReader(new InputStreamReader(inputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
        sb = new StringBuilder();
        String line = "";
        while(line !=null){
            try {
                line=br.readLine();
            } catch (IOException e) {
                Log.d("buffer","asasd");
            }

            sb.append(line);

        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        try {
            json = new JSONObject(sb.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            JSONArray jsonArray = json.getJSONArray("articles");
            //JSONObject jsonObject = new JSONObject(jsonArray.getString(0));
            HaberlerViewModel.mText.setValue(jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
