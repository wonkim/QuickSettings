package com.wonkim.quicksettings;

import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.service.quicksettings.TileService;
import android.util.Log;

/**
 * Created by wonil on 6/9/16.
 */
public class MyTileService extends TileService {
    private final int STATE_OFF = 0;
    private final int STATE_ON = 1;
    private final String LOG_TAG = "MyTileService";
    private int toggleState = STATE_ON;

    @Override
    public void onTileAdded() {
        Log.d(LOG_TAG, "onTileAdded");
    }

    @Override
    public void onTileRemoved() {
        Log.d(LOG_TAG, "onTileRemoved");
    }

    @Override
    public void onClick() {
        Log.d(LOG_TAG, "onClick state = " + Integer.toString(getQsTile().getState()));
        Icon icon;
        if (toggleState == STATE_ON) {
            toggleState = STATE_OFF;
            icon =  Icon.createWithResource(getApplicationContext(), R.drawable.ic_videocam_off);
        } else {
            toggleState = STATE_ON;
            icon = Icon.createWithResource(getApplicationContext(), R.drawable.ic_videocam);
        }
        getQsTile().setIcon(icon);
        getQsTile().updateTile();
    }

    @Override
    public void onStartListening () {
        Log.d(LOG_TAG, "onStartListening");
    }

    @Override
    public void onStopListening () {
        Log.d(LOG_TAG, "onStopListening");
    }
}
