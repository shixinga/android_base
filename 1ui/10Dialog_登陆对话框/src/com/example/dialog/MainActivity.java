package com.example.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Button bn = (Button) findViewById(R.id.bn);
		// 定义一个AlertDialog.Builder对象
		final Builder builder = new AlertDialog.Builder(this);
		// 为按钮绑定事件监听器
		bn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View source) {
				// 设置对话框的图标
				builder.setIcon(R.drawable.ic_launcher);
				// 设置对话框的标题
				builder.setTitle("自定义普通对话框");
				// 装载/res/layout/login.xml界面布局
				TableLayout loginForm = (TableLayout) getLayoutInflater()
						.inflate(R.layout.login, null);
				// 设置对话框显示的View对象
				builder.setView(loginForm);
				// 为对话框设置一个“确定”按钮
				builder.setPositiveButton("登录"
				// 为按钮设置监听器
						, new OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// 此处可执行登录处理
							}
						});
				// 为对话框设置一个“取消”按钮
				builder.setNegativeButton("取消", new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// 取消登录，不做任何事情。
					}
				});
				// 创建、并显示对话框
				builder.create().show();
			}
		});
	}

}
