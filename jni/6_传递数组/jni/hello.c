#include <jni.h>
void Java_com_array_MainActivity_passArray
  (JNIEnv *env, jobject obj, jintArray jintarr) {
	//�õ���������ĳ����Լ���0��Ԫ�صĵ�ַ
	 //jsize       (*GetArrayLength)(JNIEnv*, jarray);
	int length = (*env)->GetArrayLength(env, jintarr);
	 //jint*       (*GetIntArrayElements)(JNIEnv*, jintArray, jboolean*);
	int* arrp = (*env)->GetIntArrayElements(env, jintarr, 0);

	int i;
	for(i = 0;i < length; i++){
		*(arrp + i) += 10;
	}
}
