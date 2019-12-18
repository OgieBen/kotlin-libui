/*
 * Copyright 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.ui.graphics

actual typealias NativeBlendMode = android.graphics.PorterDuff.Mode

actual fun NativeClearBlendMode(): NativeBlendMode = android.graphics.PorterDuff.Mode.CLEAR
actual fun NativeSrcBlendMode(): NativeBlendMode = android.graphics.PorterDuff.Mode.SRC
actual fun NativeDstBlendMode(): NativeBlendMode = android.graphics.PorterDuff.Mode.DST
actual fun NativeSrcOverBlendMode(): NativeBlendMode = android.graphics.PorterDuff.Mode.SRC_OVER
actual fun NativeDstOverBlendMode(): NativeBlendMode = android.graphics.PorterDuff.Mode.DST_OVER
actual fun NativeSrcInBlendMode(): NativeBlendMode = android.graphics.PorterDuff.Mode.SRC_IN
actual fun NativeDstInBlendMode(): NativeBlendMode = android.graphics.PorterDuff.Mode.DST_IN
actual fun NativeSrcOutBlendMode(): NativeBlendMode = android.graphics.PorterDuff.Mode.SRC_OUT
actual fun NativeDstOutBlendMode(): NativeBlendMode = android.graphics.PorterDuff.Mode.DST_OUT
actual fun NativeSrcATopBlendMode(): NativeBlendMode = android.graphics.PorterDuff.Mode.SRC_ATOP
actual fun NativeDstATopBlendMode(): NativeBlendMode = android.graphics.PorterDuff.Mode.DST_ATOP
actual fun NativeXorBlendMode(): NativeBlendMode = android.graphics.PorterDuff.Mode.XOR
actual fun NativePlusBlendMode(): NativeBlendMode = android.graphics.PorterDuff.Mode.ADD
actual fun NativeScreenBlendMode(): NativeBlendMode = android.graphics.PorterDuff.Mode.SCREEN
actual fun NativeOverlayBlendMode(): NativeBlendMode = android.graphics.PorterDuff.Mode.OVERLAY
actual fun NativeDarkenBlendMode(): NativeBlendMode = android.graphics.PorterDuff.Mode.DARKEN
actual fun NativeLightenBlendMode(): NativeBlendMode = android.graphics.PorterDuff.Mode.LIGHTEN
actual fun NativeMultiplyBlendMode(): NativeBlendMode = android.graphics.PorterDuff.Mode.MULTIPLY
