#include<stdio.h>
#include<stdlib.h>
#include<jni.h>
//����������������д����������
jstring Java_com_hijni_MainActivity_callC(JNIEnv* env, jobject obj) {
	//c���Ե��ַ���
	char* cstr = "hello from c,mather";
	//��C���Ե��ַ���ת����java���ַ���
	// jstring     (*NewStringUTF)(JNIEnv*, const char*);
	//	jstring jstr = (*(*env)).NewStringUTF(env, cstr);
		jstring jstr = (*env)->NewStringUTF(env, cstr);
		return jstr;
}
