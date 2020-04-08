package com.example.covid.ui.dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.covid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TestSonuc extends Fragment {
    private View root;
    private String mParam;
    private TextView textView;
    public TestSonuc() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_test_sonuc, container, false);
        mParam = getArguments().getString("sonuc");
        textView = root.findViewById(R.id.test_sonuc);
        textView.setText(mParam);
        return root;
    }
}
