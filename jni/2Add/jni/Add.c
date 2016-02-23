#include<jni.h>

jint Java_com_example_add_MainActivity_add(JNIEnv* env, jobject obj, int i, int j) {
	return i + j;
}
