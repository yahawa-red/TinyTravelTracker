package com.rareventure.gps2.bootup;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.core.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.rareventure.gps2.GTG;
import com.rareventure.gps2.GpsTrailerService;

public class GpsTrailerReceiver extends BroadcastReceiver
{
	@Override
	public void onReceive(Context context, Intent intent) {
		Log.d("GTG", "GpsTrailerReceiver called");

        ContextCompat.startForegroundService(context,new Intent(context,
                GpsTrailerService.class));
//		Toast.makeText(context, "Good morning! " +intent.getAction(),
//				Toast.LENGTH_SHORT).show();
	}
}
