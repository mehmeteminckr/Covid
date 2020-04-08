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
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class login_fragment extends Fragment implements View.OnClickListener {
    private View view;
    private Button button_register;
    private Button button_login;
    private FirebaseAuth mAuth;
    private EditText kullanici_adi;
    private EditText sifre_;

    public login_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =inflater.inflate(R.layout.fragment_login_fragment, container, false);
        /*mAuth = FirebaseAuth.getInstance();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent= new Intent(getActivity(), buttomnav.class);
            startActivity(intent);
        }*/
        kullanici_adi=view.findViewById(R.id.kullanici_adi);
        sifre_ = view.findViewById(R.id.sifre_pass);
        button_login=view.findViewById(R.id.button_login);
        button_register=view.findViewById(R.id.button_register);
        button_login.setOnClickListener(this);
        button_register.setOnClickListener(this);
        Log.d("dee",Integer.toString(view.getId()));
        return view;
    }
    @Override
    public void onClick(final View view){
        String kullaniciadi=null;
        String sifre=null;
        Log.d("asdasd",Integer.toString(view.getId()));
        switch (view.getId()){
            case R.id.button_login:
                kullaniciadi=kullanici_adi.getText().toString();
                sifre=sifre_.getText().toString();
                if(kullaniciadi.isEmpty() || sifre.isEmpty()){
                    Toast toast =Toast.makeText(getActivity(),"Email veya şifre kısmı boş bırakılamaz",Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    mAuth.signInWithEmailAndPassword(kullaniciadi, sifre).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                Intent intent = new Intent(getActivity(), buttomnav.class);
                                startActivity(intent);
                                getActivity().finish();
                            }
                            else {
                                Toast toast =Toast.makeText(getActivity(),"Kullanıcı adı veya şifre hatalı",Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        }
                    });
                }
                break;
            case R.id.button_register:
                Navigation.findNavController(view).navigate(R.id.action_login_fragment_to_register_fragment);
                break;
        }
    }
}
