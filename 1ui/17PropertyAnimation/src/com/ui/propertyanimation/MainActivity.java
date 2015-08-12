package com.ui.propertyanimation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private ImageView iv_show;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv_show = (ImageView) findViewById(R.id.iv_show);
		//说明PropertyAnimation的ImageView组件随Animation位置的改变而改变
		iv_show.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(MainActivity.this, "点不到我haha", 0).show();
			}
		});
	}

	public void translateOnClick(View view) {
//		TranslateAnimation ta = new TranslateAnimation(0, 150, 0, 0);
//		ta.setDuration(2000);
//		ta.setFillAfter(true);
//		iv_show.startAnimation(ta);
		
		//target:动画作用于哪个组件
		ObjectAnimator oa = ObjectAnimator.ofFloat(iv_show, "translationX", 10, 70, 20, 100);
		oa.setDuration(2000);
		oa.setRepeatCount(1);
		oa.setRepeatMode(ValueAnimator.REVERSE);
		oa.start();
	}

	public void scaleOnClick(View view) {
		ObjectAnimator oa = ObjectAnimator.ofFloat(iv_show, "scaleX", 1, 1.6f, 1.2f, 2);
		oa.setDuration(2000);
		oa.start();
	}

	public void alphaOnClick(View view) {
		ObjectAnimator oa = ObjectAnimator.ofFloat(iv_show, "alpha", 0, 0.6f, 0.2f, 1);
		oa.setDuration(2000);
		oa.start();
	}

	public void rotateOnClick(View view) {
		ObjectAnimator oa = ObjectAnimator.ofFloat(iv_show, "rotationY", 0, 180, 90, 360);
		oa.setDuration(2000);
		oa.setRepeatCount(1);
		oa.setRepeatMode(ValueAnimator.REVERSE);
		oa.start();
	}

	public void fourSetOnClick(View view) {
AnimatorSet set = new AnimatorSet();
		
		ObjectAnimator oa1 = ObjectAnimator.ofFloat(iv_show, "translationX", 10, 70, 20, 100);
		oa1.setDuration(2000);
		oa1.setRepeatCount(1);
		oa1.setRepeatMode(ValueAnimator.REVERSE);
		
		ObjectAnimator oa2 = ObjectAnimator.ofFloat(iv_show, "translationY", 10, 70, 20, 100);
		oa2.setDuration(2000);
		oa2.setRepeatCount(1);
		oa2.setRepeatMode(ValueAnimator.REVERSE);
		
		ObjectAnimator oa3 = ObjectAnimator.ofFloat(iv_show, "scaleX", 1, 1.6f, 1.2f, 2);
		oa3.setDuration(2000);
		oa3.setRepeatCount(1);
		oa3.setRepeatMode(ValueAnimator.REVERSE);
		
		ObjectAnimator oa4 = ObjectAnimator.ofFloat(iv_show, "rotation", 0, 180, 90, 360);
		oa4.setDuration(2000);
		oa4.setRepeatCount(1);
		oa4.setRepeatMode(ValueAnimator.REVERSE);
		
		//设置挨个飞
//		set.playSequentially(oa1, oa2, oa3, oa4);
		//设置一起飞
		set.playTogether(oa1, oa2, oa3, oa4);
		set.start();
	}

	public void xmlOnClick(View v){
		Animator at = AnimatorInflater.loadAnimator(this, R.animator.objanimator);
		//设置作用于哪个组件
		at.setTarget(iv_show);
		at.start();
	}
}
