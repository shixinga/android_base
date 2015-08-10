package com.service.banzheng;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class LeaderBindService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return new ZhouMi();
	}

	//有个秘书牵线也不错
	class ZhouMi  extends Binder implements IBanZheng{
		
		public void qianXian() {
			banZheng();
		}
		//打麻将是只有秘书才能和领导打麻将，屁民不能和领导打麻将
		public void daMaJiang() {
			Toast.makeText(LeaderBindService.this, "和陈领导打麻将", 0).show();
		}
	}
	
	//只有领导才能办证（走后门呗）
	public void banZheng() {

		Toast.makeText(this, "已经办证了！！！", 0).show();
	}
}
