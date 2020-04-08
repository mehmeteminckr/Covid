package com.example.covid;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.covid.ui.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONException;


/**
 * A simple {@link Fragment} subclass.
 */
public class register_fragment extends Fragment implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private View view;
    EditText mail_adres;
    EditText sifre_pass;
    EditText sifre_pass2;
    EditText kullanici;
    Button kayit_ol;
    Button giris_yap;
    private DatabaseReference mDatabase;
    public register_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_register_fragment, container, false);
        mAuth = FirebaseAuth.getInstance();
        mail_adres = view.findViewById(R.id.mail_adres);
        kullanici = view.findViewById(R.id.kullanici_adi);
        sifre_pass = view.findViewById(R.id.sifre_pass);
        sifre_pass2 = view.findViewById(R.id.sifre_pass2);
        kayit_ol = view.findViewById(R.id.button_register);
        giris_yap = view.findViewById(R.id.button_login);
        kayit_ol.setOnClickListener(this);
        giris_yap.setOnClickListener(this);
        mDatabase= FirebaseDatabase.getInstance().getReference();
        return view;
    }
    @Override
    public void onClick(View v) {
        String mail;
        String sifre;
        String sifre2;
        switch (v.getId()){
            case R.id.button_register:
                mail=mail_adres.getText().toString();
                System.out.println(mail);
                sifre=sifre_pass.getText().toString();
                System.out.println(sifre);
                sifre2=sifre_pass2.getText().toString();
                System.out.println(sifre2);
                if(sifre.equals(sifre2)){
                    mAuth.createUserWithEmailAndPassword(mail,sifre).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isComplete()){
                                try {
                                    onSucces(task.getResult().getUser());
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                Intent intent= new Intent(getActivity(), buttomnav.class);
                                startActivity(intent);
                            }
                            else {
                                Log.d("Fails","Kayıt");
                            }
                        }
                    });
                }
            case R.id.button_login:
                Navigation.findNavController(view).navigate(R.id.action_register_fragment_to_login_fragment);
        }
    }
    public void onSucces(FirebaseUser user) throws JSONException {
        String username = kullanici.getText().toString();
        User user1 = new User(username,user.getEmail());
        mDatabase.child("covid19").child(user.getUid()).setValue(user1);
    }

}
