package com.hijni;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/*
 * 
 * ##使用jni
1. 在项目根目录下创建jni文件夹
2. 在jni文件中创建一个c文件
3. 在java代码中，创建一个本地方法callC

		public native String callC();
4. 在jni中定义函数实现这个方法，函数名必须为

		jstring Java_com_hijni_MainActivity_callC(JNIEnv* env, jobject obj)
5. 返回一个字符串，用c定义一个字符串

		char* cstr = "hello from c";
6. 把c的字符串转换成java的字符串

		jstring jstr = (*env)->NewStringUTF(env, cstr);
		return jstr；
7. 在jni中创建Android.mk文件
8. 在c文件中添加<jni.h>头文件
9. 在jni文件夹下执行ndk-build.cmd指令
10. java代码中加载so类库，调用本地方法

 */
public class MainActivity extends Activity {
	static{
		//加载打包完毕的so类库
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
