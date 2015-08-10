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
     * ��ת����绰activity
     * ��ת������Ӧ�õ�activity
     * ��ʽ��ת��ͨ��ָ��action��data
     * @param v
     */
    
    public void click1(View view) {
    	Intent intent = new Intent();
    	intent.setAction(Intent.ACTION_CALL);
    	intent.setData(Uri.parse("tel:110"));
    	startActivity(intent);
    }
    /**
     * ��ʾ��ת��������
     */
    public void click2(View view) {
    	Intent intent = new Intent();
    	//ָ��Ŀ��Activity�İ���������
    	intent.setClassName("com.android.dialer", "com.android.dialer.DialtactsActivity");
    	startActivity(intent);
    }
    
    /**
     * ��ʽ��ת��������
     */
    public void click3(View view) {
    	Intent intent = new Intent();
    	//��ʽ���ò������Ķ���
    	intent.setAction(Intent.ACTION_DIAL);
    	startActivity(intent);
    }
    
    /**
     * ��ת��secondActivity
     * �ڱ�Ӧ������ת
     * ��ʾ��ת��ֱ��ָ��Ŀ��Activity�İ���������
     * @param v
     */
    public void click4(View view) {
    	Intent intent = new Intent();
    	intent.setClass(MainActivity.this, SecondActivity.class);
    	startActivity(intent);
    }
    
    /**
     * ��ʽ��ת��secondActivity
     * @param v
     */
    public void click5(View view) {
    	Intent intent = new Intent();
    	intent.setAction("com.csx.xxxx");
    	//Data��Typeˮ�����ݣ����������Ů���ѵ�ˮ��
//    	intent.setData(Uri.parse("heima2:qwe"));
//    	intent.setType("text/username");
//    	intent.setData(Uri.parse("heima2:qwe123"));
    	//�������������������,DataAndType
    	intent.setDataAndType(Uri.parse("zzzz:qwe123"), "text/username");
    	
    	//ϵͳ���Զ����Ĭ�ϵ�category
    	intent.addCategory(Intent.CATEGORY_DEFAULT);
    	startActivity(intent);
    	
    }
    
    /**
     * ��ʽ��ת�������
     */
    
    public void click6(View view) {
    	Intent intent = new Intent();
    	intent.setClassName("com.android.browser", "com.android.browser.BrowserActivity");
    	startActivity(intent);
    }
    /**
     * ��ʽ��ת�������
     * @param v
     */
    public void click7(View view) {
    	Intent intent = new Intent();
    	intent.setAction(Intent.ACTION_VIEW);
    	intent.setData(Uri.parse("http://www.baidu.com"));
    	startActivity(intent);
    }
}
