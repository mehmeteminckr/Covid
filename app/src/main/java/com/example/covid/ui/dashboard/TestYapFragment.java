package com.example.covid.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavInflater;
import androidx.navigation.Navigation;

import com.example.covid.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TestYapFragment extends Fragment implements View.OnClickListener{

    private DashboardViewModel dashboardViewModel;
    public Map<String,Object> testResult;
    private DatabaseReference mDatabase;
    private FirebaseUser firebaseUser;
    CheckBox ates;
    CheckBox agri;
    CheckBox halsizlik;
    CheckBox ishal;
    CheckBox oksuruk;
    Button test;
    Bundle bundle;
    private int count;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        testResult= new HashMap<>();
        bundle = new Bundle();
        ates = root.findViewById(R.id.radioButton_ates);
        agri = root.findViewById(R.id.radioButton_agri);
        halsizlik = root.findViewById(R.id.radioButton_halsizlik);
        ishal = root.findViewById(R.id.radioButton_ishal);
        oksuruk = root.findViewById(R.id.radioButton_oksuruk);
        test= root.findViewById(R.id.button_test);
        ates.setOnClickListener( this);
        agri.setOnClickListener( this);
        halsizlik.setOnClickListener( this);
        ishal.setOnClickListener( this);
        oksuruk.setOnClickListener( this);
        test.setOnClickListener(this);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        return root;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.radioButton_ates:
                testResult.put("ates",ates.isChecked());
                Log.d("heyooooo",testResult.toString());
                break;
            case R.id.radioButton_halsizlik:
                testResult.put("halsizlik",halsizlik.isChecked());
                Log.d("heyooooo",testResult.toString());
                break;
            case R.id.radioButton_agri:
                testResult.put("agri",agri.isChecked());
                Log.d("heyooooo",testResult.toString());
                break;
            case R.id.radioButton_ishal:
                testResult.put("ishal",ishal.isChecked());
                Log.d("heyooooo",testResult.toString());
                break;
            case R.id.radioButton_oksuruk:
                testResult.put("oksuruk",oksuruk.isChecked());
                Log.d("heyooooo",testResult.toString());
                break;
            case R.id.button_test:
                mDatabase.child("covid19").child(firebaseUser.getUid()).child("testResult").push().setValue(testResult);
                count = Collections.frequency(testResult.values(),true);
                if(count > 3){
                    bundle.putString("sonuc","Durumunuz kritik, İlgili mercihlere başvurunuz ...");
                }
                else {
                    bundle.putString("sonuc","Korkulacak bir şey yok");
                }
                Navigation.findNavController(v).navigate(R.id.action_navigation_dashboard_to_testSonuc,bundle);
        }
    }
}
