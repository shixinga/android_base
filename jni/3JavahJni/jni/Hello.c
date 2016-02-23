#include<jni.h>
JNIEXPORT jstring JNICALL Java_com_javahjni_MainActivity_getS(JNIEnv* env, jobject obj) {
	//cÓïÑÔµÄ×Ö·û´®
	char* cstr = "hello from c";
	//°ÑCÓïÑÔµÄ×Ö·û´®×ª»»³ÉjavaµÄ×Ö·û´®
	// jstring     (*NewStringUTF)(JNIEnv*, const char*);
	//	jstring jstr = (*(*env)).NewStringUTF(env, cstr);
	jstring jstr = (*env)->NewStringUTF(env, cstr);
	return jstr;
}
