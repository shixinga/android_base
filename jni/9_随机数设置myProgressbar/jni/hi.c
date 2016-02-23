#include <jni.h>
#include <stdio.h>
#include <stdlib.h>

int getPressure(){
	//��������ѹ��������õ�ѹ��ֵ
	return rand() % 101;
}
int flag;

JNIEXPORT void JNICALL Java_com_myprogressbar_MainActivity_startp
  (JNIEnv * env, jobject obj) {

	flag = 1;
	while(flag) {

		//��ȡ��¯ѹ��
		int pressure = getPressure();

		//jclass      (*FindClass)(JNIEnv*, const char*);
		jclass clazz = (*env)->FindClass(env, "com/myprogressbar/MainActivity");
		//jmethodID   (*GetMethodID)(JNIEnv*, jclass, const char*, const char*);
		jmethodID methodId = (*env)->GetMethodID(env, clazz, "setMyProgressBarData", "(I)V");
		//void        (*CallVoidMethod)(JNIEnv*, jobject, jmethodID, ...);
		(*env)->CallVoidMethod(env, obj, methodId, pressure);
		sleep(1);
	}
}

/*
 * Class:     com_myprogressbar_MainActivity
 * Method:    stop
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_myprogressbar_MainActivity_stopp
  (JNIEnv * env, jobject obj) {
	flag = 0;
}

