LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := hi
LOCAL_SRC_FILES := hi.c

include $(BUILD_SHARED_LIBRARY)
