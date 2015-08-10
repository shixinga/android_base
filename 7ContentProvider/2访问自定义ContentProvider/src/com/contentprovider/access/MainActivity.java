package com.contentprovider.access;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static String CURRENT_URI = "content://com.contentprovider.xxxx";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void addOnClick(View view) {
		ContentResolver cr = getContentResolver();
		//把要插入的数据全部封装至ContentValues对象
		ContentValues values = new ContentValues();
		values.put("name", "nima");
		values.put("salary", 111000);
		cr.insert(Uri.parse(CURRENT_URI), values);
	}
	public void deleteOnClick(View view) {
		ContentResolver cr = getContentResolver();
    	int i = cr.delete(Uri.parse(CURRENT_URI), "name = ?", new String[]{"nima"});
//    	int i = cr.delete(Uri.parse(CURRENT_URI), null, null);
//    	System.out.println(i);
    	Toast.makeText(this, "被修改的行数是：" + i, 0).show();
	}
	public void updateOnClick(View view) {

		
		ContentResolver cr = getContentResolver();
    	ContentValues values = new ContentValues();
    	values.put("salary", 44000);
    	int i = cr.update(Uri.parse(CURRENT_URI), values, "name = ?", new String[]{"nima"});
		Toast.makeText(this, "被修改的行数是：" + i, 0).show();
	}
	public void selectOnClick(View view) {
		Cursor cursor = getContentResolver().query(Uri.parse(CURRENT_URI), null, null, null, null);
		while(cursor.moveToNext()){
			//通过列索引获取列的值
			String name = cursor.getString(cursor.getColumnIndex("name"));
			String salary = cursor.getString(cursor.getColumnIndex("salary"));
//			System.out.println(name + ";" + salary);
			Toast.makeText(this, name + ";" + salary, 0).show();
		}
	}

}
