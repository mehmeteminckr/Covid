package com.example.covid.ui.notifications;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.Map;

public class NotificationsViewModel extends ViewModel {

    public static MutableLiveData<LinkedHashMap<String,Object>> mText;

    public NotificationsViewModel() {
        mText = new MutableLiveData<>();
    }

    public LiveData<LinkedHashMap<String,Object>> getText() {
        return mText;
    }
}