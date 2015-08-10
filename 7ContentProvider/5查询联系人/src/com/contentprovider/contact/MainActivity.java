package com.contentprovider.contact;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
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
    	//通过内容提供者访问联系人数据库
    	ContentResolver cr = getContentResolver();
    	Cursor cursorContactId = cr.query(Uri.parse("content://com.android.contacts/raw_contacts"), new String[]{"contact_id"}, null, null, null);
    	while(cursorContactId.moveToNext()){
    		//获取联系人id
    		String contactId = cursorContactId.getString(0);
    		Cursor cursorData =  cr.query(Uri.parse("content://com.android.contacts/data"), new String[]{"data1", "mimetype"}, 
    				"raw_contact_id = ?", new String[]{contactId}, null);
    		//获取所有字段的名字
//    		String[] names = cursorData.getColumnNames();
//    		for (String string : names) {
//				System.out.println(string);
//			}
    		Contact con = new Contact();
    		while(cursorData.moveToNext()){
    			String data1 = cursorData.getString(0);
    			String mimetype = cursorData.getString(1);
    			//通过mimetype的判断，把data1存入对应的属性
    			if("vnd.android.cursor.item/email_v2".equals(mimetype)){
    				con.setEmail(data1);
    			}
    			else if("vnd.android.cursor.item/phone_v2".equals(mimetype)){
    				con.setPhone(data1);
    			}
    			else if("vnd.android.cursor.item/name".equals(mimetype)){
    				con.setName(data1);
    			}
    		}
    		System.out.println(con.toString());
    	}
    }
}
