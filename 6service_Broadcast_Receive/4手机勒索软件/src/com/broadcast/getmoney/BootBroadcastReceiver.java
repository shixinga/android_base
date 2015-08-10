package com.broadcast.getmoney;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		//because BroadcastReceiver并不是Context的子类
		//so不能写this，而是传入context参数
		Intent it = new Intent(context, MainActivity.class);
		System.out.println("开启成功!!!!!!!");
		//创建任务栈存放启动的Activity
		it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(it);
	}

}
