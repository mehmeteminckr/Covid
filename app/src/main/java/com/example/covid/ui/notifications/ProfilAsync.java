package com.example.covid.ui.notifications;

import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONObject;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProfilAsync extends AsyncTask<Void,Void,String> {


    DatabaseReference ref;
    FirebaseUser firebaseUser;
    LinkedHashMap<String,Object> map = new LinkedHashMap<String, Object>();

    @Override
    protected String doInBackground(Void... voids) {
        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        ref = database.getReference("covid19/"+firebaseUser.getUid().toString()+"/testResult");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot childSnapShot : dataSnapshot.getChildren()){
                    if(NotificationsViewModel.mText.getValue() != null){
                        map = NotificationsViewModel.mText.getValue();
                    }
                    map.put(childSnapShot.getKey(),childSnapShot.getValue());
                    NotificationsViewModel.mText.setValue(map);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return null;
    }
}
