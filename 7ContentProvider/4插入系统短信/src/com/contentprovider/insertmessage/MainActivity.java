package com.contentprovider.insertmessage;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void click(View v){
    	Thread t = new Thread(){
    		@Override
    		public void run() {
    			try {
					sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			ContentResolver cr = getContentResolver();
    	    	ContentValues values = new ContentValues();
    	    	values.put("address", 95555);
    	    	values.put("type", 1);
    	    	values.put("date", System.currentTimeMillis());
    	    	values.put("body", "��β��ΪXXXX�����ÿ��յ�1,000,000RMBת�ˣ���ע�����");
    	    	cr.insert(Uri.parse("content://sms"), values);
    		}
    	};
    	t.start();
    }
}
