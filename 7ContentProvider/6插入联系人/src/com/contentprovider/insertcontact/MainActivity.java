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
    	//�Ȳ�ѯraw_contacts����ȡ������ϵ�˵�������Ȼ������+1������Ҫ�������ϵ�˵�id
    	Cursor cursorContactId = cr.query(Uri.parse("content://com.android.contacts/raw_contacts"), new String[]{"_id"}, null, null, null);
    	//Ĭ����ϵ��id����1
    	int contact_id = 1;
    	if(cursorContactId.moveToLast()){
    		//�õ�����
    		int _id = cursorContactId.getInt(0);
    		//����+1������Ҫ�������ϵ��id
    		contact_id = ++_id;
    	}
    	
    	ContentValues values = new ContentValues();
    	values.put("contact_id", contact_id);
    	//����ϵ��id����raw_contacts���ݿ�
    	cr.insert(Uri.parse("content://com.android.contacts/raw_contacts"), values);
    	
    	values.clear();
    	values.put("data1", "��bi");
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
