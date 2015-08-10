package com.broadcast.ipcall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
/**
 * 即使本应用的进程是关闭（没有开这个软件）的，if
 * 系统发出的广播（这里指打电话广播）的action和该CallReCeive的intent-filter
 * 中的action相同，那么该应用会被启动
 * @author Administrator
 *
 */
public class CallReceiver extends BroadcastReceiver {

	//因为电话号码可以在打的时候修改拨打号码
	//，用intent是不能修改data（电话号码）
	//所以data通过广播传送
	@Override
	public void onReceive(Context context, Intent intent) {
//		Log.e("ha", "接收成功~~~~~");
		
		//接收到的打电话广播包含所拨打的号码
		String number = getResultData();
		//一般前面加0的号码都不是本地号码
		if(number.startsWith("0")) {
			
			SharedPreferences sp = context.getSharedPreferences("ip", context.MODE_PRIVATE);
			String ipNumber = sp.getString("ipNumber", "");
			
			//把IP线路号码添加至用户拨打号码的前面
			number = ipNumber + number;
			
			//把新的号码重新放入广播中(重新设置要拨打的电话号码)
			setResultData(number);
			//把该广播杀死，不让其他应用的broadcast接收到该广播
			abortBroadcast();
		}
	}

}
