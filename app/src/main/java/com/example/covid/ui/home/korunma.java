package com.example.covid.ui.home;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.covid.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.utils.YouTubePlayerUtils;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class korunma extends Fragment{

    private View view;
    public static final String DEVELOPER_KEY = "*/*/";
    private static final String VIDEO_ID = "IqiTJK_uzUY";
    public korunma() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_korunma, container, false);
        YouTubePlayerView youTubePlayerView = view.findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);
        /*youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                String videoId = "UY03fnBmxK8";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
        YouTubePlayerView youTubePlayerView2 = view.findViewById(R.id.youtube_player_view2);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView2.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer youTubePlayer) {
                String videoId = "1Pjfz41H8-s";
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
        YouTubePlayerView youTubePlayerView3 = view.findViewById(R.id.youtube_player_view3);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
              public void onReady(YouTubePlayer youTubePlayer) {
                String videoId = "mGybeLo4IzU";
                youTubePlayer.loadVideo(videoId, 0);
              }
        });*/


        return view;
    }


}
