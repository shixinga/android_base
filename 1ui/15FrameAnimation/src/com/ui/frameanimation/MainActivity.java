package com.ui.frameanimation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView iv_animation;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv_animation = (ImageView) findViewById(R.id.iv_animation);
		//��֡��������Դ�ļ�ָ��Ϊiv�ı���
		iv_animation.setBackgroundResource(R.drawable.frameanimation);
		//��ȡiv�ı���
		AnimationDrawable ad = (AnimationDrawable) iv_animation.getBackground();
		ad.start();
	}

}
