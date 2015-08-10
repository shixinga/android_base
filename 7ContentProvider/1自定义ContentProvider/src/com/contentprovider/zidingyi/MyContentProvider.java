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
		//�������ݸı��֪ͨ
		//uri:֪ͨ���͵���һ��uri�ϣ�����ע�������uri�ϵ����ݹ۲��߶������յ����֪ͨ
		getContext().getContentResolver().notifyChange(uri, null);
		return cursor;
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		//��Ҫ���������ȫ����װ��ContentValues����
		db.insert("person", null, values);
		//�������ݸı��֪ͨ
		//uri:֪ͨ���͵���һ��uri�ϣ�����ע�������uri�ϵ����ݹ۲��߶������յ����֪ͨ
		getContext().getContentResolver().notifyChange(uri, null);
		return uri;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		int i = db.delete("person", selection, selectionArgs);
		//�������ݸı��֪ͨ
		//uri:֪ͨ���͵���һ��uri�ϣ�����ע�������uri�ϵ����ݹ۲��߶������յ����֪ͨ
		getContext().getContentResolver().notifyChange(uri, null);
		return i;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		
		int i = db.update("person", values, selection, selectionArgs);
		//�������ݸı��֪ͨ
		//uri:֪ͨ���͵���һ��uri�ϣ�����ע�������uri�ϵ����ݹ۲��߶������յ����֪ͨ
		getContext().getContentResolver().notifyChange(uri, null);
		return i;
	}

}
