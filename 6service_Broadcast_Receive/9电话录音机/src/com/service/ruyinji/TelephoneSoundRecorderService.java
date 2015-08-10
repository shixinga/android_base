package com.service.ruyinji;

import java.io.IOException;

import android.app.Service;
import android.content.Intent;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

public class TelephoneSoundRecorderService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		//�õ��绰������
		TelephonyManager tm = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
		//�����绰״̬
		//events:����PhoneStateListener����ʲô����
		tm.listen(new MyListener(), PhoneStateListener.LISTEN_CALL_STATE);
	}

	class MyListener extends PhoneStateListener{

		private MediaRecorder  mediaRecorder = null;
		//һ���绰״̬�ı䣬�˷�������
		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			super.onCallStateChanged(state, incomingNumber);
			if(state == TelephonyManager.CALL_STATE_IDLE) {
				System.out.println("�绰����");
				if(mediaRecorder != null) {
					mediaRecorder.stop();
					mediaRecorder.release();
					mediaRecorder = null;
				}
				
			} else if(state == TelephonyManager.CALL_STATE_RINGING) {
				System.out.println("�绰����");
				if(mediaRecorder == null) {
						mediaRecorder = new MediaRecorder();
						mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
						mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
						mediaRecorder.setOutputFile(getFilesDir() + "luyin.3gp");
						mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
						
						try {
							mediaRecorder.prepare();
						} catch (IOException e) {
							Log.e("ahah", "prepare() failed");
						}
				}
				
			} else if(state == TelephonyManager.CALL_STATE_OFFHOOK) {
				System.out.println("�绰ժ��������������˼");
				//��ʼ¼��
				if(mediaRecorder != null) {
					
					mediaRecorder.start();
				}
				
			}
		}
		
	}
}
