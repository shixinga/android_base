package com.contentprovider.insertcontact;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
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
    	ContentResolver cr = getContentResolver();
    	//先查询raw_contacts表，获取最新联系人的主键，然后主键+1，就是要插入的联系人的id
    	Cursor cursorContactId = cr.query(Uri.parse("content://com.android.contacts/raw_contacts"), new String[]{"_id"}, null, null, null);
    	//默认联系人id就是1
    	int contact_id = 1;
    	if(cursorContactId.moveToLast()){
    		//拿到主键
    		int _id = cursorContactId.getInt(0);
    		//主键+1，就是要插入的联系人id
    		contact_id = ++_id;
    	}
    	
    	ContentValues values = new ContentValues();
    	values.put("contact_id", contact_id);
    	//把联系人id插入raw_contacts数据库
    	cr.insert(Uri.parse("content://com.android.contacts/raw_contacts"), values);
    	
    	values.clear();
    	values.put("data1", "二bi");
    	values.put("mimetype", "vnd.android.cursor.item/name");
    	values.put("raw_contact_id", contact_id);
    	cr.insert(Uri.parse("content://com.android.contacts/data"), values);
    	
    	values.clear();
    	values.put("data1", "1344567");
    	values.put("mimetype", "vnd.android.cursor.item/phone_v2");
    	values.put("raw_contact_id", contact_id);
    	cr.insert(Uri.parse("content://com.android.contacts/data"), values);
    }
}
