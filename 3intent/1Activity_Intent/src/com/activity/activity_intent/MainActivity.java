package com.activity.activity_intent;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * 跳转至打电话activity
     * 跳转至其他应用的activity
     * 隐式跳转：通过指定action和data
     * @param v
     */
    
    public void click1(View view) {
    	Intent intent = new Intent();
    	intent.setAction(Intent.ACTION_CALL);
    	intent.setData(Uri.parse("tel:110"));
    	startActivity(intent);
    }
    /**
     * 显示跳转至拨号器
     */
    public void click2(View view) {
    	Intent intent = new Intent();
    	//指定目标Activity的包名和类名
    	intent.setClassName("com.android.dialer", "com.android.dialer.DialtactsActivity");
    	startActivity(intent);
    }
    
    /**
     * 隐式跳转至拨号器
     */
    public void click3(View view) {
    	Intent intent = new Intent();
    	//隐式设置拨号器的动作
    	intent.setAction(Intent.ACTION_DIAL);
    	startActivity(intent);
    }
    
    /**
     * 跳转至secondActivity
     * 在本应用中跳转
     * 显示跳转：直接指定目标Activity的包名和类名
     * @param v
     */
    public void click4(View view) {
    	Intent intent = new Intent();
    	intent.setClass(MainActivity.this, SecondActivity.class);
    	startActivity(intent);
    }
    
    /**
     * 隐式跳转至secondActivity
     * @param v
     */
    public void click5(View view) {
    	Intent intent = new Intent();
    	intent.setAction("com.csx.xxxx");
    	//Data和Type水火不相容，就像妈妈和女朋友掉水里
//    	intent.setData(Uri.parse("heima2:qwe"));
//    	intent.setType("text/username");
//    	intent.setData(Uri.parse("heima2:qwe123"));
    	//所以有了下面这个函数,DataAndType
    	intent.setDataAndType(Uri.parse("zzzz:qwe123"), "text/username");
    	
    	//系统会自动添加默认的category
    	intent.addCategory(Intent.CATEGORY_DEFAULT);
    	startActivity(intent);
    	
    }
    
    /**
     * 显式跳转至浏览器
     */
    
    public void click6(View view) {
    	Intent intent = new Intent();
    	intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
    	startActivity(intent);
    }
    /**
     * 隐式跳转至浏览器
     * @param v
     */
    public void click7(View view) {
    	Intent intent = new Intent();
    	intent.setAction(Intent.ACTION_VIEW);
    	intent.setData(Uri.parse("http://www.baidu.com"));
    	startActivity(intent);
    }
}
