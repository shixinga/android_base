package com.broadcast.install;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class AppBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		String action = intent.getAction();
		Uri uri = intent.getData();
		if("android.intent.action.PACKAGE_ADDED".equals(action)){
			Toast.makeText(context, uri.toString() + "被安装了", 0).show();
		}
		if("android.intent.action.PACKAGE_REPLACED".equals(action)){
			Toast.makeText(context, uri.toString() + "被升级了", 0).show();
		}
		if("android.intent.action.PACKAGE_REMOVED".equals(action)){
			Toast.makeText(context, uri.toString() + "被卸载了", 0).show();
		}
	}

}
