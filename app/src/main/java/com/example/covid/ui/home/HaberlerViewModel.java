package com.example.covid.ui.home;

import android.os.AsyncTask;
import android.util.JsonReader;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class HaberlerViewModel extends ViewModel {

    protected static MutableLiveData<JSONArray> mText;
    private String url="http://newsapi.org/v2/top-headlines?country=tr&category=health&apiKey=b8867e244f204c9791848936070a7a34";

    public HaberlerViewModel() throws IOException {
        mText = new MutableLiveData<JSONArray>();
        SimpleAsyncTask2 simpleAsyncTask2 = new SimpleAsyncTask2();
        simpleAsyncTask2.execute();
    }

    public MutableLiveData<JSONArray> getSelected (){
        return mText;
    }


}