package com.example.add;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
/*
 * 
 * ##常见错误
* findLibrary returned null
	* CPU平台不匹配
	* 加载类库时，写错类库名字

* 本地方法找不到
	* 忘记加载类库
	* c代码中方法名写错了

Application.mk的作用：适用于不同手机cpu的文件配置
 */
public class MainActivity extends Activity {

	static {
		System.loadLibrary("hh");
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void addOnClick(View view) {
		Toast.makeText(this, "3+4=" + add(3,4), 0).show();
	}
	
	public native int add(int i, int j);
}
