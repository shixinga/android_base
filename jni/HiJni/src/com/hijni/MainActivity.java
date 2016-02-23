package com.hijni;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/*
 * 
 * ##ʹ��jni
1. ����Ŀ��Ŀ¼�´���jni�ļ���
2. ��jni�ļ��д���һ��c�ļ�
3. ��java�����У�����һ�����ط���callC

		public native String callC();
4. ��jni�ж��庯��ʵ���������������������Ϊ

		jstring Java_com_hijni_MainActivity_callC(JNIEnv* env, jobject obj)
5. ����һ���ַ�������c����һ���ַ���

		char* cstr = "hello from c";
6. ��c���ַ���ת����java���ַ���

		jstring jstr = (*env)->NewStringUTF(env, cstr);
		return jstr��
7. ��jni�д���Android.mk�ļ�
8. ��c�ļ������<jni.h>ͷ�ļ�
9. ��jni�ļ�����ִ��ndk-build.cmdָ��
10. java�����м���so��⣬���ñ��ط���

 */
public class MainActivity extends Activity {
	static{
		//���ش����ϵ�so���
		System.loadLibrary("hello");
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void callCOnClick(View view) {
    	Toast.makeText(this, callC(), 0).show();
    }
    
    public  native String callC();
}
