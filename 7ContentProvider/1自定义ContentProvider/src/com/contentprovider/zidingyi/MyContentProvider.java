package com.contentprovider.zidingyi;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyContentProvider extends ContentProvider {

	private MySqliteOpenHelper msoh;

	private SQLiteDatabase db;
	@Override
	public boolean onCreate() {
		msoh = new MySqliteOpenHelper(getContext());
		db = msoh.getWritableDatabase();
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
		String[] selectionArgs, String sortOrder) {
		Cursor cursor = db.query("person", null, null, null, null, null, null, null);
		//发送数据改变的通知
		//uri:通知发送到哪一个uri上，所有注册在这个uri上的内容观察者都可以收到这个通知
		getContext().getContentResolver().notifyChange(uri, null);
		return cursor;
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		//把要插入的数据全部封装至ContentValues对象
		db.insert("person", null, values);
		//发送数据改变的通知
		//uri:通知发送到哪一个uri上，所有注册在这个uri上的内容观察者都可以收到这个通知
		getContext().getContentResolver().notifyChange(uri, null);
		return uri;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		int i = db.delete("person", selection, selectionArgs);
		//发送数据改变的通知
		//uri:通知发送到哪一个uri上，所有注册在这个uri上的内容观察者都可以收到这个通知
		getContext().getContentResolver().notifyChange(uri, null);
		return i;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		
		int i = db.update("person", values, selection, selectionArgs);
		//发送数据改变的通知
		//uri:通知发送到哪一个uri上，所有注册在这个uri上的内容观察者都可以收到这个通知
		getContext().getContentResolver().notifyChange(uri, null);
		return i;
	}

}
