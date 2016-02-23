LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := Hi
LOCAL_SRC_FILES := Hi.c

include $(BUILD_SHARED_LIBRARY)
