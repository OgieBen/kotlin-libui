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

import androidx.ui.engine.geometry.Offset
import androidx.ui.engine.geometry.RRect
import androidx.ui.engine.geometry.Radius
import androidx.ui.engine.geometry.Rect
import androidx.ui.vectormath64.Matrix4

expect class NativePath()

expect class Path(internalPath: NativePath = NativePath()) {

    fun toFrameworkPath(): NativePath

    /**
     * Determines how the interior of this path is calculated.
     *
     * Defaults to the non-zero winding rule, [PathFillType.nonZero].
     */
    fun getFillType(): PathFillType

    fun setFillType(value: PathFillType)

    /** Starts a new subpath at the given coordinate. */
    fun moveTo(dx: Float, dy: Float)

    /** Starts a new subpath at the given offset from the current point. */
    fun relativeMoveTo(dx: Float, dy: Float)

    /**
     * Adds a straight line segment from the current point to the given
     * point.
     */
    fun lineTo(dx: Float, dy: Float)

    /**
     * Adds a straight line segment from the current point to the point
     * at the given offset from the current point.
     */
    fun relativeLineTo(dx: Float, dy: Float)

    /**
     * Adds a quadratic bezier segment that curves from the current
     * point to the given point (x2,y2), using the control point
     * (x1,y1).
     */
    fun quadraticBezierTo(x1: Float, y1: Float, x2: Float, y2: Float)

    /**
     * Adds a quadratic bezier segment that curves from the current
     * point to the point at the offset (x2,y2) from the current point,
     * using the control point at the offset (x1,y1) from the current
     * point.
     */
    fun relativeQuadraticBezierTo(x1: Float, y1: Float, x2: Float, y2: Float)

    /**
     * Adds a cubic bezier segment that curves from the current point
     * to the given point (x3,y3), using the control points (x1,y1) and
     * (x2,y2).
     */
    fun cubicTo(x1: Float, y1: Float, x2: Float, y2: Float, x3: Float, y3: Float)

    /**
     * Adds a cubic bezier segment that curves from the current point
     * to the point at the offset (x3,y3) from the current point, using
     * the control points at the offsets (x1,y1) and (x2,y2) from the
     * current point.
     */
    fun relativeCubicTo(x1: Float, y1: Float, x2: Float, y2: Float, x3: Float, y3: Float)

    /**
     * Adds a bezier segment that curves from the current point to the
     * given point (x2,y2), using the control points (x1,y1) and the
     * weight w. If the weight is greater than 1, then the curve is a
     * hyperbola; if the weight equals 1, it's a parabola; and if it is
     * less than 1, it is an ellipse.
     *
     * Throws [UnsupportedOperationException] as Android framework does not support this API
     */
    fun conicTo(x1: Float, y1: Float, x2: Float, y2: Float, w: Float)

    /**
     * Adds a bezier segment that curves from the current point to the
     * point at the offset (x2,y2) from the current point, using the
     * control point at the offset (x1,y1) from the current point and
     * the weight w. If the weight is greater than 1, then the curve is
     * a hyperbola; if the weight equals 1, it's a parabola; and if it
     * is less than 1, it is an ellipse.
     *
     * Throws [UnsupportedOperationException] as Android framework does not support this API
     */
    fun relativeConicTo(x1: Float, y1: Float, x2: Float, y2: Float, w: Float)

    /**
     * If the [forceMoveTo] argument is false, adds a straight line
     * segment and an arc segment.
     *
     * If the [forceMoveTo] argument is true, starts a new subpath
     * consisting of an arc segment.
     *
     * In either case, the arc segment consists of the arc that follows
     * the edge of the oval bounded by the given rectangle, from
     * startAngle radians around the oval up to startAngle + sweepAngle
     * radians around the oval, with zero radians being the point on
     * the right hand side of the oval that crosses the horizontal line
     * that intersects the center of the rectangle and with positive
     * angles going clockwise around the oval.
     *
     * The line segment added if `forceMoveTo` is false starts at the
     * current point and ends at the start of the arc.
     */
    fun arcToRad(
        rect: Rect,
        startAngleRadians: Float,
        sweepAngleRadians: Float,
        forceMoveTo: Boolean
    )

    /**
     * If the [forceMoveTo] argument is false, adds a straight line
     * segment and an arc segment.
     *
     * If the [forceMoveTo] argument is true, starts a new subpath
     * consisting of an arc segment.
     *
     * In either case, the arc segment consists of the arc that follows
     * the edge of the oval bounded by the given rectangle, from
     * startAngle degrees around the oval up to startAngle + sweepAngle
     * degrees around the oval, with zero degrees being the point on
     * the right hand side of the oval that crosses the horizontal line
     * that intersects the center of the rectangle and with positive
     * angles going clockwise around the oval.
     *
     * The line segment added if `forceMoveTo` is false starts at the
     * current point and ends at the start of the arc.
     */
    fun arcTo(
        rect: Rect,
        startAngleDegrees: Float,
        sweepAngleDegrees: Float,
        forceMoveTo: Boolean
    )

    /**
     * Appends up to four conic curves weighted to describe an oval of `radius`
     * and rotated by `rotation`.
     *
     * The first curve begins from the last point in the path and the last ends
     * at `arcEnd`. The curves follow a path in a direction determined by
     * `clockwise` and `largeArc` in such a way that the sweep angle
     * is always less than 360 degrees.
     *
     * A simple line is appended if either either radii are zero or the last
     * point in the path is `arcEnd`. The radii are scaled to fit the last path
     * point if both are greater than zero but too small to describe an arc.
     *
     * Throws [UnsupportedOperationException] as Android framework does not support this API
     */
    fun arcToPoint(
        arcEnd: Offset,
        radius: Radius = Radius.zero,
        rotation: Float = 0.0f,
        largeArc: Boolean = false,
        clockwise: Boolean = true
    )

    /**
     * Appends up to four conic curves weighted to describe an oval of `radius`
     * and rotated by `rotation`.
     *
     * The last path point is described by (px, py).
     *
     * The first curve begins from the last point in the path and the last ends
     * at `arcEndDelta.dx + px` and `arcEndDelta.dy + py`. The curves follow a
     * path in a direction determined by `clockwise` and `largeArc`
     * in such a way that the sweep angle is always less than 360 degrees.
     *
     * A simple line is appended if either either radii are zero, or, both
     * `arcEndDelta.dx` and `arcEndDelta.dy` are zero. The radii are scaled to
     * fit the last path point if both are greater than zero but too small to
     * describe an arc.
     */
    fun relativeArcToPoint(
        arcEndDelta: Offset,
        radius: Radius = Radius.zero,
        rotation: Float = 0.0f,
        largeArc: Boolean = false,
        clockwise: Boolean = true
    )

    /**
     * Adds a new subpath that consists of four lines that outline the
     * given rectangle.
     */
    fun addRect(rect: Rect)

    /**
     * Adds a new subpath that consists of a curve that forms the
     * ellipse that fills the given rectangle.
     *
     * To add a circle, pass an appropriate rectangle as `oval`. [Rect.fromCircle]
     * can be used to easily describe the circle's center [Offset] and radius.
     */
    fun addOval(oval: Rect)

    /**
     * Adds a new subpath with one arc segment that consists of the arc
     * that follows the edge of the oval bounded by the given
     * rectangle, from startAngle radians around the oval up to
     * startAngle + sweepAngle radians around the oval, with zero
     * radians being the point on the right hand side of the oval that
     * crosses the horizontal line that intersects the center of the
     * rectangle and with positive angles going clockwise around the
     * oval.
     */
    fun addArcRad(oval: Rect, startAngleRadians: Float, sweepAngleRadians: Float)

    /**
     * Adds a new subpath with one arc segment that consists of the arc
     * that follows the edge of the oval bounded by the given
     * rectangle, from startAngle degrees around the oval up to
     * startAngle + sweepAngle degrees around the oval, with zero
     * degrees being the point on the right hand side of the oval that
     * crosses the horizontal line that intersects the center of the
     * rectangle and with positive angles going clockwise around the
     * oval.
     */
    fun addArc(oval: Rect, startAngleDegrees: Float, sweepAngleDegrees: Float)

    /**
     * Adds a new subpath with a sequence of line segments that connect the given
     * points.
     *
     * If `close` is true, a final line segment will be added that connects the
     * last point to the first point.
     *
     * The `points` argument is interpreted as offsets from the origin.
     */
    fun addPolygon(points: List<Offset>, close: Boolean)

    fun addRRect(rrect: RRect)

    /**
     * Adds a new subpath that consists of the given `path` offset by the given
     * `offset`.
     *
     * If `matrix4` is specified, the path will be transformed by this matrix
     * after the matrix is translated by the given offset. The matrix is a 4x4
     * matrix stored in column major order.
     */
    fun addPath(path: Path, offset: Offset = Offset.zero, matrix: Matrix4? = null)

    fun extendWithPath(path: Path, offset: Offset, matrix: Matrix4)

    /**
     * Closes the last subpath, as if a straight line had been drawn
     * from the current point to the first point of the subpath.
     */
    fun close()

    /**
     * Clears the [Path] object of all subpaths, returning it to the
     * same state it had when it was created. The _current point_ is
     * reset to the origin.
     */
    fun reset()

    /**
     * Tests to see if the given point is within the path. (That is, whether the
     * point would be in the visible portion of the path if the path was used
     * with [Canvas.clipPath].)
     *
     * The `point` argument is interpreted as an offset from the origin.
     *
     * Returns true if the point is in the path, and false otherwise.
     */
    fun contains(offset: Offset): Boolean

    /**
     * Translates all the segments of every subpath by the given offset.
     */
    fun shift(offset: Offset)

    /**
     * Returns a copy of the path with all the segments of every
     * subpath transformed by the given matrix.
     */
    fun transform(matrix: Matrix4): Path

    /**
     * Computes the bounding rectangle for this path.
     *
     * A path containing only axis-aligned points on the same straight line will
     * have no area, and therefore `Rect.isEmpty` will return true for such a
     * path. Consider checking `rect.width + rect.height > 0.0` instead, or
     * using the [computeMetrics] API to check the path length.
     *
     * For many more elaborate paths, the bounds may be inaccurate.  For example,
     * when a path contains a circle, the points used to compute the bounds are
     * the circle's implied control points, which form a square around the circle;
     * if the circle has a transformation applied using [transform] then that
     * square is rotated, and the (axis-aligned, non-rotated) bounding box
     * therefore ends up grossly overestimating the actual area covered by the
     * circle.
     */
    fun getBounds(): Rect

    companion object {
        /**
         * Combines the two paths according to the manner specified by the given
         * `operation`.
         *
         * The resulting path will be constructed from non-overlapping contours. The
         * curve order is reduced where possible so that cubics may be turned into
         * quadratics, and quadratics maybe turned into lines.
         *
         * Throws [IllegalArgumentException] as Android framework does not support this API
         */
        fun combine(
            operation: PathOperation,
            path1: Path,
            path2: Path
        ): Path
    }

    /**
     * Returns the path's convexity, as defined by the content of the path.
     *
     * A path is convex if it has a single contour, and only ever curves in a
     * single direction.
     *
     * This function will calculate the convexity of the path from its control
     * points, and cache the result.
     */
    val isConvex: Boolean

    /**
     * Returns true if the path is empty (contains no lines or curves)
     */
    val isEmpty: Boolean
}
