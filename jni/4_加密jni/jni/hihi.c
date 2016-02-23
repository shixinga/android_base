#include <jni.h>
jint Java_com_password_jni_MainActivity_getPassword
  (JNIEnv * env, jobject obj, jint i) {
	return i + 2;
}
