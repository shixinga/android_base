 LOCAL_PATH := $(call my-dir)

    include $(CLEAR_VARS)
	#�������ɵ��ļ�������ʲô����
    LOCAL_MODULE    := hh
    #Ҫ�����c�ļ�
    LOCAL_SRC_FILES := Add.c

    include $(BUILD_SHARED_LIBRARY)