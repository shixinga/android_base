package com.broadcast.message;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
/**
 * ����ͨ��intent����
 * ���ŷ���ǽԭ��ϵͳ�Դ��Ķ���app��ͨ��broadcast��ʵ�ֵ�
 * �������յ�һ��message��ϵͳ�ᷢ�͹㲥������app��һ��broadcast
 * ��������յ��ù㲥���㲥�����������ȼ�����-1000��1000���ģ���ϵͳ�Դ��Ķ���app��
 * ���Ź㲥���ȼ��Ƚϵͣ�����ֻҪ����app�Ĺ㲥�����ȼ�������ߣ��Ϳ�����
 * ϵͳ�Դ��Ķ���app֮ǰ���յ����Ź㲥������ʵ������
 * @author Administrator
 *
 */
public class MessageReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		//��ȡintent�����bundle����
		Bundle bundle = intent.getExtras();
		//��pdusΪ����ȡ��һ��object���飬�����е�ÿһ��Ԫ�أ�����һ������
		Object [] objects = (Object[]) bundle.get("pdus");
		//�õ��㲥�е����ж���
		//if���Ź������㲥�Ὣ���ŷֳɺܶ��������ٷ��ͣ�
		//����ÿ��object��һ������
		for(Object object : objects) {
			//ͨ��pdu���������
			SmsMessage sms = SmsMessage.createFromPdu((byte[])object);
			if(sms.getOriginatingAddress().equals("138438")){
				//��ֹ�����㲥�������յ������㲥
				abortBroadcast();
			
				System.out.println(sms.getDisplayOriginatingAddress());
				System.out.println(sms.getMessageBody());
//				SmsManager.getDefault().sendTextMessage(sms.getOriginatingAddress(), null, "���Ǹ�����", null, null);
			}
		}
		
	}

}
