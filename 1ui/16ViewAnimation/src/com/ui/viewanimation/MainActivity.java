package com.ui.viewanimation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private ImageView iv_show;
	private RotateAnimation ra;
	private AlphaAnimation aa;
	private ScaleAnimation sa;
	private TranslateAnimation ta;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv_show = (ImageView) findViewById(R.id.iv_show);
		//说明ViewAnimation的ImageView组件不随Animation位置的改变而改变
		iv_show.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "点不到我haha", 0).show();
			}
		});
	}

	public void translateOnClick(View view) {
		// ta = new TranslateAnimation(10, 100, 20, 200);
		ta = new TranslateAnimation(Animation.RELATIVE_TO_SELF, -1,
				Animation.RELATIVE_TO_SELF, 2, Animation.RELATIVE_TO_SELF,
				-0.5f, Animation.RELATIVE_TO_SELF, 1.5f);
		// 设置播放时间
		ta.setDuration(2000);
		// 设置重复次数
		ta.setRepeatCount(1);
		ta.setRepeatMode(Animation.REVERSE);
		iv_show.startAnimation(ta);
	}

	public void scaleOnClick(View view) {
		// sa = new ScaleAnimation(fromX, toX, fromY, toY, iv_show.getWidth() / 2,
		// iv_show.getHeight() / 2);
		sa = new ScaleAnimation(0.5f, 2, 0.1f, 3, Animation.RELATIVE_TO_SELF,
				0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
		sa.setDuration(2000);
		// 填充动画的结束位置
		sa.setRepeatCount(1);
		sa.setRepeatMode(Animation.REVERSE);
		sa.setFillAfter(true);
		iv_show.startAnimation(sa);
	}

	public void alphaOnClick(View view) {
		aa = new AlphaAnimation(0, 1);
		aa.setDuration(2000);
		sa.setRepeatCount(1);
		iv_show.startAnimation(aa);
	}

	public void rotateOnClick(View view) {
		ra = new RotateAnimation(0, 720, Animation.RELATIVE_TO_SELF, 0.5f,
				Animation.RELATIVE_TO_SELF, 0.5f);
		ra.setDuration(2000);
		ra.setRepeatCount(1);
		ra.setRepeatMode(Animation.REVERSE);
		iv_show.startAnimation(ra);
	}

	public void fourSetOnClick(View view) {
		AnimationSet set = new AnimationSet(false);
		set.addAnimation(ta);
		set.addAnimation(sa);
		set.addAnimation(ra);
		set.addAnimation(aa);

		iv_show.startAnimation(set);
	}

}
