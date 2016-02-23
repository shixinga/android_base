#include <jni.h>
JNIEXPORT void JNICALL Java_com_ccalljava_MainActivity_ccalljava
  (JNIEnv * env, jobject obj){

	//jclass      (*FindClass)(JNIEnv*, const char*);
	jclass clazz = (*env)->FindClass(env, "com/ccalljava/MainActivity");
	//jmethodID   (*GetMethodID)(JNIEnv*, jclass, const char*, const char*);
	jmethodID methodID = (*env)->GetMethodID(env, clazz, "showDialog", "(Ljava/lang/String;)V");
	//void        (*CallVoidMethod)(JNIEnv*, jobject, jmethodID, ...);
	(*env)->CallVoidMethod(env, obj, methodID, (*env)->NewStringUTF(env, "umeatherf!!!"));
}
