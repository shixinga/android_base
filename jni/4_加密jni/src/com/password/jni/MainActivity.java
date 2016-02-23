package com.password.jni;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
/**
 * 不能用java代码实现md5加密，因为java代码可以被反编译
 * 所以通过jni实现在c代码中实现加密算法，c很难被反编译
 * @author Administrator
 *
 */
public class MainActivity extends Activity {

	static {
		System.loadLibrary("hihi");
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void getPasswordOnClick(View view) {
		EditText editText = (EditText) findViewById(R.id.ed_password);
		int password = Integer.parseInt(editText.getText().toString());
		Toast.makeText(this, "加密后的密码是：" + getPassword(password), 0).show();
	}
	
	public native int getPassword(int i);
}
