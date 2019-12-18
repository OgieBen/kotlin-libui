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

actual class NativePaint

actual class Paint {

    actual fun asFrameworkPaint(): NativePaint { TODO() }

    actual var alpha: Float
        get() { TODO() }
        set(value) { TODO() }

    // Whether to apply anti-aliasing to lines and images drawn on the
    // canvas.
    //
    // Defaults to true.
    actual var isAntiAlias: Boolean
            get() { TODO() }
            set(value) { TODO() }

    // The color to use when stroking or filling a shape.
    //
    // Defaults to opaque black.
    //
    // See also:
    //
    //  * [style], which controls whether to stroke or fill (or both).
    //  * [colorFilter], which overrides [color].
    //  * [shader], which overrides [color] with more elaborate effects.
    //
    // This color is not used when compositing. To colorize a layer, use
    // [colorFilter].
    actual var color: Color
        get() { TODO() }
        set(color) { TODO() }

    // A blend mode to apply when a shape is drawn or a layer is composited.
    //
    // The source colors are from the shape being drawn (e.g. from
    // [Canvas.drawPath]) or layer being composited (the graphics that were drawn
    // between the [Canvas.saveLayer] and [Canvas.restore] calls), after applying
    // the [colorFilter], if any.
    //
    // The destination colors are from the background onto which the shape or
    // layer is being composited.
    //
    // Defaults to [BlendMode.srcOver].
    //
    // See also:
    //
    //  * [Canvas.saveLayer], which uses its [Paint]'s [blendMode] to composite
    //    the layer when [restore] is called.
    //  * [BlendMode], which discusses the user of [saveLayer] with [blendMode].
    actual var blendMode: BlendMode
        get() { TODO() }
        set(value) { TODO() }

    // Whether to paint inside shapes, the edges of shapes, or both.
    //
    // Defaults to [PaintingStyle.fill].
    actual var style: PaintingStyle
        get() { TODO() }
        set(value) { TODO() }

    // How wide to make edges drawn when [style] is set to
    // [PaintingStyle.stroke]. The width is given in logical pixels measured in
    // the direction orthogonal to the direction of the path.
    //
    // Defaults to 0.0, which correspond to a hairline width.
    actual var strokeWidth: Float
        get() { TODO() }
        set(value) { TODO() }

    // The kind of finish to place on the end of lines drawn when
    // [style] is set to [PaintingStyle.stroke].
    //
    // Defaults to [StrokeCap.butt], i.e. no caps.
    actual var strokeCap: StrokeCap
        get() { TODO() }
        set(value) { TODO() }

    // The kind of finish to place on the joins between segments.
    //
    // This applies to paths drawn when [style] is set to [PaintingStyle.stroke],
    // It does not apply to points drawn as lines with [Canvas.drawPoints].
    //
    // Defaults to [StrokeJoin.miter], i.e. sharp corners. See also
    // [strokeMiterLimit] to control when miters are replaced by bevels.
    actual var strokeJoin: StrokeJoin
        get() { TODO() }
        set(value) { TODO() }

    // The limit for miters to be drawn on segments when the join is set to
    // [StrokeJoin.miter] and the [style] is set to [PaintingStyle.stroke]. If
    // this limit is exceeded, then a [StrokeJoin.bevel] join will be drawn
    // instead. This may cause some 'popping' of the corners of a path if the
    // angle between line segments is animated.
    //
    // This limit is expressed as a limit on the length of the miter.
    //
    // Defaults to 4.0.  Using zero as a limit will cause a [StrokeJoin.bevel]
    // join to be used all the time.
    actual var strokeMiterLimit: Float
        get() { TODO() }
        set(value) { TODO() }

    // A mask filter (for example, a blur) to apply to a shape after it has been
    // drawn but before it has been composited into the image.
    //
    // See [MaskFilter] for details.
    actual var maskFilter: MaskFilter
        get() { TODO() }
        set(value) { TODO() }

    // Controls the performance vs quality trade-off to use when applying
    // filters, such as [maskFilter], or when drawing images, as with
    // [Canvas.drawImageRect] or [Canvas.drawImageNine].
    //
    // Defaults to [FilterQuality.none].
    // TODO(ianh): verify that the image drawing methods actually respect this
    actual var filterQuality: FilterQuality
        get() { TODO() }
        set(value) { TODO() }

    // The shader to use when stroking or filling a shape.
    //
    // When this is null, the [color] is used instead.
    //
    // See also:
    //
    //  * [Gradient], a shader that paints a color gradient.
    //  * [ImageShader], a shader that tiles an [Image].
    //  * [colorFilter], which overrides [shader].
    //  * [color], which is used if [shader] and [colorFilter] are null.
    actual var shader: Shader?
        get() { TODO() }
        set(value) { TODO() }

    // A color filter to apply when a shape is drawn or when a layer is
    // composited.
    //
    // See [ColorFilter] for details.
    //
    // When a shape is being drawn, [colorFilter] overrides [color] and [shader].
    actual var colorFilter: ColorFilter?
        get() { TODO() }
        set(value) { TODO() }
}
