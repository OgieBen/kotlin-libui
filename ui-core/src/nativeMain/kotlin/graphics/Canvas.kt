/*
 * Copyright 2019 The Android Open Source Project
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

import androidx.ui.engine.geometry.Rect

actual class NativeCanvas

/**
 * Create a new Canvas instance that targets its drawing commands
 * to the provided [Image]
 */
actual fun Canvas(image: Image): Canvas { TODO() }

/**
 * Create a new Canvas instance that targets its drawing commands to the provided
 * [PictureRecorder] in order to be replayed later
 */
actual fun Canvas(
    recorder: PictureRecorder,
    cullRect: Rect
): Canvas { TODO() }

fun Canvas(c: NativeCanvas): Canvas { TODO() }

/**
 * Saves a copy of the current transform and clip on the save stack and executes the
 * provided lambda with the current transform applied. Once the lambda has been executed,
 * the transformation is popped from the stack, undoing the transformation.
 *
 *
 * See also:
 *
 *  [Canvas.saveLayer], which does the same thing but additionally also groups the
 *    commands
 */
actual fun Canvas.withSave(block: () -> Unit) { TODO() }

