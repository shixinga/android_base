#include<jni.h>
JNIEXPORT jstring JNICALL Java_com_javahjni_MainActivity_getS(JNIEnv* env, jobject obj) {
	//c���Ե��ַ���
	char* cstr = "hello from c";
	//��C���Ե��ַ���ת����java���ַ���
	// jstring     (*NewStringUTF)(JNIEnv*, const char*);
	//	jstring jstr = (*(*env)).NewStringUTF(env, cstr);
	jstring jstr = (*env)->NewStringUTF(env, cstr);
	return jstr;
}
