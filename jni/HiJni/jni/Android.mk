 LOCAL_PATH := $(call my-dir)

    include $(CLEAR_VARS)
	#�������ɵ��ļ�������ʲô����
    LOCAL_MODULE    := hello
    #Ҫ�����c�ļ�
    LOCAL_SRC_FILES := hi.c

    include $(BUILD_SHARED_LIBRARY)