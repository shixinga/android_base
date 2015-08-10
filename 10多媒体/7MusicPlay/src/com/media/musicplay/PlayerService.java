package com.media.musicplay;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;

public class PlayerService extends Service {

	private MediaPlayer player;
	private Timer timer;
	@Override
	public IBinder onBind(Intent intent) {
		return new ZhongJianRenPlayer();
	}

	
	@Override
	public void onCreate() {
		super.onCreate();
		player = new MediaPlayer();
	}


	@Override
	public void onDestroy() {
		super.onDestroy();
		//ֹͣ����
		player.stop();
		//�ͷ�ռ�õ���Դ����ʱplayer�����Ѿ��ϵ���
		player.release();
		player = null;
		if(timer != null){
			timer.cancel();
			timer = null;
		}
	}


	public void play() {
		//����
		player.reset();
		try {
			//���ض�ý���ļ�
//			player.setDataSource(getFilesDir() + "qq.mp3");
			player.setDataSource("http://192.168.1.102:8080/qq.mp3");
			//�첽����,���������̼߳��أ���Ϊ���������������첽
			player.prepareAsync();

			//ͬ�����أ����ڱ��ؼ���,���ؼ���Ҳ�������첽����
//			player.prepare();
//					player.start();
			player.setOnPreparedListener(new OnPreparedListener() {
				//׼�����ʱ���˷�������
				@Override
				public void onPrepared(MediaPlayer mp) {
					player.start();
					addTimer();
				}
			});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public void pause() {
		player.pause();
	}
	//��������
	public void goOnPlay() {
		player.start();
	}
	public void seekTo(int progress) {
		player.seekTo(progress);
	}
	
	public void addTimer(){
		if(timer == null){
			timer = new Timer();
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					//��ȡ������ʱ��
					int duration = player.getDuration();
					//��ȡ������ǰ���Ž���
					int currentPosition= player.getCurrentPosition();
					
					Message msg = MainActivity.handler.obtainMessage();
					//�ѽ��ȷ�װ����Ϣ������
					Bundle bundle = new Bundle();
					bundle.putInt("duration", duration);
					bundle.putInt("currentPosition", currentPosition);
					msg.setData(bundle);
					MainActivity.handler.sendMessage(msg);
					
				}
				//��ʼ��ʱ������5���룬��һ��ִ��run�������Ժ�ÿ500����ִ��һ��
			}, 5, 500);
		}
	}
	
	class ZhongJianRenPlayer extends Binder implements IPlay {

		@Override
		public void play() {
			PlayerService.this.play();
		}

		@Override
		public void pause() {
			PlayerService.this.pause();
			
		}

		@Override
		public void goOnPlay() {
			
			PlayerService.this.goOnPlay();
		}

		@Override
		public void seekTo(int progress) {
			PlayerService.this.seekTo(progress);
			
		}
		
	}
}
