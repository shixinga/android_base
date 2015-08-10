package com.service.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ScreenBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String action = intent.getAction();
		if(action.equals(Intent.ACTION_SCREEN_ON)) {
			
			System.out.println("��Ļ��������");
		} else if(action.equals(Intent.ACTION_SCREEN_OFF)) {
			System.out.println("��Ļ�ر���������");
		}
	}

}
