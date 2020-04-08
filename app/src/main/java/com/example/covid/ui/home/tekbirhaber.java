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
 */
public class tekbirhaber extends Fragment {
    private View view;
    private WebView webView;
    private String mParam;

    public tekbirhaber() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mParam=getArguments().getString("url");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_tekbirhaber, container, false);
        webView = view.findViewById(R.id.tekbirhaber);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(mParam);
        return view;
    }
}
