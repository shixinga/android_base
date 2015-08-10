package com.broadcast.ipcall;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
/**
 * ��ʹ��Ӧ�õĽ����ǹرգ�û�п����������ģ�if
 * ϵͳ�����Ĺ㲥������ָ��绰�㲥����action�͸�CallReCeive��intent-filter
 * �е�action��ͬ����ô��Ӧ�ûᱻ����
 * @author Administrator
 *
 */
public class CallReceiver extends BroadcastReceiver {

	//��Ϊ�绰��������ڴ��ʱ���޸Ĳ������
	//����intent�ǲ����޸�data���绰���룩
	//����dataͨ���㲥����
	@Override
	public void onReceive(Context context, Intent intent) {
//		Log.e("ha", "���ճɹ�~~~~~");
		
		//���յ��Ĵ�绰�㲥����������ĺ���
		String number = getResultData();
		//һ��ǰ���0�ĺ��붼���Ǳ��غ���
		if(number.startsWith("0")) {
			
			SharedPreferences sp = context.getSharedPreferences("ip", context.MODE_PRIVATE);
			String ipNumber = sp.getString("ipNumber", "");
			
			//��IP��·����������û���������ǰ��
			number = ipNumber + number;
			
			//���µĺ������·���㲥��(��������Ҫ����ĵ绰����)
			setResultData(number);
			//�Ѹù㲥ɱ������������Ӧ�õ�broadcast���յ��ù㲥
			abortBroadcast();
		}
	}

}
