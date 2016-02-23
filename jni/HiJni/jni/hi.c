#include<stdio.h>
#include<stdlib.h>
#include<jni.h>
//函数名必须是这样写！！！！！
jstring Java_com_hijni_MainActivity_callC(JNIEnv* env, jobject obj) {
	//c语言的字符串
	char* cstr = "hello from c,mather";
	//把C语言的字符串转换成java的字符串
	// jstring     (*NewStringUTF)(JNIEnv*, const char*);
	//	jstring jstr = (*(*env)).NewStringUTF(env, cstr);
		jstring jstr = (*env)->NewStringUTF(env, cstr);
		return jstr;
}
