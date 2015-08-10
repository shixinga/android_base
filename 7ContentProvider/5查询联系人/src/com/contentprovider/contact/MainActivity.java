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
    	//ͨ�������ṩ�߷�����ϵ�����ݿ�
    	ContentResolver cr = getContentResolver();
    	Cursor cursorContactId = cr.query(Uri.parse("content://com.android.contacts/raw_contacts"), new String[]{"contact_id"}, null, null, null);
    	while(cursorContactId.moveToNext()){
    		//��ȡ��ϵ��id
    		String contactId = cursorContactId.getString(0);
    		Cursor cursorData =  cr.query(Uri.parse("content://com.android.contacts/data"), new String[]{"data1", "mimetype"}, 
    				"raw_contact_id = ?", new String[]{contactId}, null);
    		//��ȡ�����ֶε�����
//    		String[] names = cursorData.getColumnNames();
//    		for (String string : names) {
//				System.out.println(string);
//			}
    		Contact con = new Contact();
    		while(cursorData.moveToNext()){
    			String data1 = cursorData.getString(0);
    			String mimetype = cursorData.getString(1);
    			//ͨ��mimetype���жϣ���data1�����Ӧ������
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
