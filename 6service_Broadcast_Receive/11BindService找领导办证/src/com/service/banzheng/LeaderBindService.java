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

	//�и�����ǣ��Ҳ����
	class ZhouMi  extends Binder implements IBanZheng{
		
		public void qianXian() {
			banZheng();
		}
		//���齫��ֻ��������ܺ��쵼���齫��ƨ���ܺ��쵼���齫
		public void daMaJiang() {
			Toast.makeText(LeaderBindService.this, "�ͳ��쵼���齫", 0).show();
		}
	}
	
	//ֻ���쵼���ܰ�֤���ߺ����£�
	public void banZheng() {

		Toast.makeText(this, "�Ѿ���֤�ˣ�����", 0).show();
	}
}
