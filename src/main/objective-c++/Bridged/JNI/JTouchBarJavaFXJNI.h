/**
 * JTouchBar
 *
 * Copyright (c) 2018 - 2019 thizzer.com
 *
 * This software may be modified and distributed under the terms
 * of the MIT license.  See the LICENSE file for details.
 *
 * @author  	M. ten Veldhuis
 */
#ifndef JTOUCHBARJAVAFXJNI_H
#define JTOUCHBARJAVAFXJNI_H

#include <jni.h>

#ifdef __cplusplus
extern "C" {
#endif
    
JNIEXPORT jlong JNICALL Java_com_thizzer_jtouchbar_javafx_JTouchBarJavaFX_getJavaFXViewPointer0(JNIEnv *env, jclass cls, jobject window);
    
#ifdef __cplusplus
}
#endif

#endif // JTOUCHBARJAVAFXJNI_H
