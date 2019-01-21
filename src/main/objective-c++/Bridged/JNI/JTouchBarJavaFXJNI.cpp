/**
 * JTouchBar
 *
 * Copyright (c) 2018 thizzer.com
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 *
 * @author  	M. ten Veldhuis
 */
#include "JTouchBarJavaFXJNI.h"

#import <Cocoa/Cocoa.h>
#import <JavaVM/JavaVM.h>

JNIEXPORT jlong JNICALL Java_com_thizzer_jtouchbar_javafx_JTouchBarJavaFX_getJavaFXViewPointer0(JNIEnv *env, jclass cls, jobject component) {
    jclass componentClass = env->GetObjectClass(component);
    
    jfieldID peerField = env->GetFieldID(componentClass, "impl_peer", "Lcom/sun/javafx/tk/TKStage;");
    if(peerField == nullptr) {
        peerField = env->GetFieldID(componentClass, "peer", "Lcom/sun/javafx/tk/TKStage;");
    }
    
    if(peerField == nullptr) {
        return 0L;
    }
    
    jobject peer = env->GetObjectField(component, peerField);
    if(peer == nullptr) {
        return 0L;
    }
    
    jclass peerClass = env->GetObjectClass(peer);
    if(peerClass == nullptr) {
        return 0L;
    }
    
    jmethodID platformWindowMethod = env->GetMethodID(peerClass, "getPlatformWindow", "()Lcom/sun/glass/ui/Window;");
    if(platformWindowMethod == nullptr) {
        return 0L;
    }

    jobject window = env->CallObjectMethod(peer, platformWindowMethod);
    if(window == nullptr) {
        return 0L;
    }
    
    jclass windowClass = env->FindClass("com/sun/glass/ui/Window");
    if(windowClass == nullptr) {
        return 0L;
    }
    
    jmethodID contentViewMethod = env->GetMethodID(windowClass, "getView", "()Lcom/sun/glass/ui/View;");
    if(contentViewMethod == nullptr) {
        return 0L;
    }
    
    jobject contentView = env->CallObjectMethod(window, contentViewMethod);
    if(contentView == nullptr) {
        return 0L;
    }
    
    jclass contentViewClass = env->GetObjectClass(contentView);
    if(contentViewClass == nullptr) {
        return 0L;
    }
    
    jmethodID nativeViewMethod = env->GetMethodID(contentViewClass, "getNativeView", "()J");
    if(nativeViewMethod == nullptr) {
        return 0L;
    }
    
    jlong nativeHandle = env->CallLongMethod(contentView, nativeViewMethod);
    return (long) nativeHandle;
}
