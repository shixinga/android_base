package com.contentprovider.message;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlSerializer;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;

public class MainActivity extends Activity {

	List<Message> smsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        smsList = new ArrayList<Message>();
    }


    public void click(View v){
    	//访问内容提供者获取短信
    	ContentResolver cr = getContentResolver();
    	//						短信内容提供者的主机名
    	Cursor cursor = cr.query(Uri.parse("content://sms"), new String[]{"address", "date", "body", "type"}, 
    			null, null, null);
    	while(cursor.moveToNext()){
    		String address = cursor.getString(0);
    		long date = cursor.getLong(1);
    		String body = cursor.getString(2);
    		String type = cursor.getString(3);
    		Message sms = new Message(body, type, address, date);
    		smsList.add(sms);
    	}
    }
    
    public void click2(View v){
    	XmlSerializer xs = Xml.newSerializer();
    	File file = new File(getFilesDir(), "messages.xml");
    	FileOutputStream fos;
		try {
			fos = new FileOutputStream(file);
			xs.setOutput(fos, "utf-8");
			
			xs.startDocument("utf-8", true);
			xs.startTag(null, "message");
			
			for (Message sms : smsList) {
				xs.startTag(null, "sms");
				
				xs.startTag(null, "body");
				xs.text(sms.getBody());
				xs.endTag(null, "body");
				
				xs.startTag(null, "date");
				xs.text(sms.getDate() + "");
				xs.endTag(null, "date");
				
				xs.startTag(null, "type");
				xs.text(sms.getType());
				xs.endTag(null, "type");
				
				xs.startTag(null, "address");
				xs.text(sms.getAddress());
				xs.endTag(null, "address");
				
				xs.endTag(null, "sms");
			}
			
			xs.endTag(null, "message");
			xs.endDocument();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
