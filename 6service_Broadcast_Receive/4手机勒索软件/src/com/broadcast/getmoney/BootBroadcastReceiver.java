package com.broadcast.getmoney;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		//because BroadcastReceiver������Context������
		//so����дthis�����Ǵ���context����
		Intent it = new Intent(context, MainActivity.class);
		System.out.println("�����ɹ�!!!!!!!");
		//��������ջ���������Activity
		it.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(it);
	}

}
