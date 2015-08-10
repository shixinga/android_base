package com.broadcast.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
/**
 * 短信通过intent传递
 * 短信防火墙原理：系统自带的短信app是通过broadcast来实现的
 * ，当接收到一条message，系统会发送广播，短信app有一个broadcast
 * 接听会接收到该广播。广播接收是有优先级（从-1000到1000）的，而系统自带的短信app的
 * 短信广播优先级比较低，所以只要将本app的广播的优先级设置最高，就可以在
 * 系统自带的短信app之前接收到短信广播，即可实现拦截
 * @author Administrator
 *
 */
public class MessageReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		//获取intent里面的bundle对象
		Bundle bundle = intent.getExtras();
		//以pdus为键，取出一个object数组，数组中的每一个元素，都是一条短信
		Object [] objects = (Object[]) bundle.get("pdus");
		//拿到广播中的所有短信
		//if短信过长，广播会将短信分成很多条短信再发送，
		//所以每个object是一条短信
		for(Object object : objects) {
			//通过pdu来构造短信
			SmsMessage sms = SmsMessage.createFromPdu((byte[])object);
			if(sms.getOriginatingAddress().equals("138438")){
				//阻止其他广播接收者收到这条广播
				abortBroadcast();
			
				System.out.println(sms.getDisplayOriginatingAddress());
				System.out.println(sms.getMessageBody());
//				SmsManager.getDefault().sendTextMessage(sms.getOriginatingAddress(), null, "你是个好人", null, null);
			}
		}
		
	}

}
