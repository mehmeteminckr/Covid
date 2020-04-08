package com.example.covid.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.covid.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link vakasyisi#newInstance} factory method to
 * create an instance of this fragment.
 */
public class vakasyisi extends Fragment {

    private View view;
    private WebView webView;
    public vakasyisi() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_vakasyisi, container, false);
        webView = view.findViewById(R.id.vakasyisi);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://covid19.saglik.gov.tr/");
        return view;
    }
}
