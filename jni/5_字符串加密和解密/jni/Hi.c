#include <jni.h>
#include <string.h>
//把java的字符串转换成c的字符串
char*   Jstring2CStr(JNIEnv*   env,   jstring   jstr)
{
	 char*   rtn   =   NULL;
	 jclass   clsstring   =   (*env)->FindClass(env,"java/lang/String");
	 jstring   strencode   =   (*env)->NewStringUTF(env,"GB2312");
	 jmethodID   mid   =   (*env)->GetMethodID(env,clsstring,   "getBytes",   "(Ljava/lang/String;)[B");
	 jbyteArray   barr=   (jbyteArray)(*env)->CallObjectMethod(env,jstr,mid,strencode); // String .getByte("GB2312");
	 jsize   alen   =   (*env)->GetArrayLength(env,barr);
	 jbyte*   ba   =   (*env)->GetByteArrayElements(env,barr,JNI_FALSE);
	 if(alen   >   0)
	 {
	  rtn   =   (char*)malloc(alen+1);         //"\0"
	  memcpy(rtn,ba,alen);
	  rtn[alen]=0;
	 }
	 (*env)->ReleaseByteArrayElements(env,barr,ba,0);  //
	 return rtn;
}
jstring Java_com_string_encode_MainActivity_encode
  (JNIEnv *env, jobject obj, jstring str, jint length) {
	char* cstr = Jstring2CStr(env, str);
		int i;
		for(i = 0;i < length; i++){
			*(cstr + i) += 1;
		}
		return (*env)->NewStringUTF(env, cstr);
}

jstring Java_com_string_encode_MainActivity_decode
  (JNIEnv *env, jobject obj, jstring str, jint length) {
	char* cstr = Jstring2CStr(env, str);
		int i;
		for(i = 0;i < length; i++){
			*(cstr + i) -= 1;
		}
		return (*env)->NewStringUTF(env, cstr);

}
