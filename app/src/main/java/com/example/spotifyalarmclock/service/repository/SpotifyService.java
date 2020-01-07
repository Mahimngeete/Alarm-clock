package com.example.spotifyalarmclock.service.repository;


import android.content.Context;
import android.util.Log;

import com.example.spotifyalarmclock.APIKeys;
import com.spotify.android.appremote.api.ConnectionParams;
import com.spotify.android.appremote.api.Connector;
import com.spotify.android.appremote.api.SpotifyAppRemote;


public class SpotifyService {

    private static final String TAG = "SpotifyService";

    private static final String CLIENT_ID = APIKeys.SPOTIFY_CLIENT_ID;
    private static final String REDIRECT_URI = "com.example.spotifyalarmclock://callback";
    private SpotifyAppRemote mSpotifyAppRemote;
    private Context context;

    SpotifyService(Context context){
        this.context = context;
    }

    public boolean isConnectedToSpotify(){
        final boolean[] isConnected = {false};
        ConnectionParams connectionParams =
                new ConnectionParams.Builder(CLIENT_ID)
                        .setRedirectUri(REDIRECT_URI)
                        .showAuthView(true)
                        .build();

        SpotifyAppRemote.connect(context, connectionParams,
                new Connector.ConnectionListener() {

                    @Override
                    public void onConnected(SpotifyAppRemote spotifyAppRemote) {
                        mSpotifyAppRemote = spotifyAppRemote;
                        Log.d(TAG, "Connected! Yay!");
                        isConnected[0] = true;

                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        Log.e(TAG, throwable.getMessage(), throwable);
                        isConnected[0] = false;
                    }
                });
        return isConnected[0];
    }

    public void playPlaylist(String playlistName, boolean isShuffle){
        mSpotifyAppRemote.getPlayerApi().setShuffle(isShuffle);
        mSpotifyAppRemote.getPlayerApi().play(playlistName);
    }

}
