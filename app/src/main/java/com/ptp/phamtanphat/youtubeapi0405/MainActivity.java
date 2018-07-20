package com.ptp.phamtanphat.youtubeapi0405;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{


    YouTubePlayerView youTubePlayerView;
    String API_Key = "AIzaSyAPGfgmwWYTjcYFvw7_7sKopLkQPzi2P8Y";
    int Request_Code_Fail = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        youTubePlayerView = findViewById(R.id.youtubeplayerview);

        youTubePlayerView.initialize(API_Key,this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Request_Code_Fail && resultCode == RESULT_OK){
            youTubePlayerView.initialize(API_Key,this);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.loadVideo("OvkAcTBpedg");
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(MainActivity.this,Request_Code_Fail);
        }
    }
}
