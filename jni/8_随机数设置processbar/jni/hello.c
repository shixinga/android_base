#include <jni.h>
#include <stdio.h>
#include <stdlib.h>

int getPressure(){
	//……监测电压……运算得到压力值
	return rand() % 101;
}
int flag;
JNIEXPORT void JNICALL Java_com_processbar_calljava_MainActivity_startPb
  (JNIEnv *env, jobject obj) {
	flag = 1;
	while(flag) {

		//获取锅炉压力
		int pressure = getPressure();

		//jclass      (*FindClass)(JNIEnv*, const char*);
		jclass clazz = (*env)->FindClass(env, "com/processbar/calljava/MainActivity");
		//jmethodID   (*GetMethodID)(JNIEnv*, jclass, const char*, const char*);
		jmethodID methodId = (*env)->GetMethodID(env, clazz, "setProgressBar", "(I)V");
		//void        (*CallVoidMethod)(JNIEnv*, jobject, jmethodID, ...);
		(*env)->CallVoidMethod(env, obj, methodId, pressure);
		sleep(1);
	}
}

/*
 * Class:     com_processbar_calljava_MainActivity
 * Method:    stopPb
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_processbar_calljava_MainActivity_stopPb
	(JNIEnv *env, jobject obj) {
	flag = 0;

}
