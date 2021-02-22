package com.github.ferum_bot.tool_bar_view.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.Toolbar
import androidx.annotation.ColorInt
import androidx.annotation.Px
import com.github.ferum_bot.tool_bar_view.R
import com.github.ferum_bot.tool_bar_view.core.extensions.dpToPx
import com.github.ferum_bot.tool_bar_view.core.extensions.refactorToBookReuseWidth

/**
 * Created by Matvey Popov.
 * Date: 22.02.2021
 * Time: 21:06
 * Project: BookReuse
 */
class BookReuseToolBarView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): Toolbar(context, attrs, defStyleAttr) {

    @Px
    private var bottomStrokeWidth = context.dpToPx(DEFAULT_BOTTOM_STROKE_WIDTH).refactorToBookReuseWidth()
    @ColorInt
    private var bottomStrokeColor = DEFAULT_BOTTOM_STROKE_COLOR

    private val viewPaint = Paint()
    private var viewWidth = 1f

    init {
        if (attrs != null) {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.BookReuseToolBarView)
            bottomStrokeWidth = typedArray.getDimension(
                R.styleable.BookReuseToolBarView_bottom_stoke_width,
                context.dpToPx(DEFAULT_BOTTOM_STROKE_WIDTH)
            ).refactorToBookReuseWidth()
            bottomStrokeColor = typedArray.getColor(
                R.styleable.BookReuseToolBarView_bottom_stroke_color,
                DEFAULT_BOTTOM_STROKE_COLOR
            )
            setUp()
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        viewWidth = context.dpToPx(w)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.drawRect(0f, 0f, viewWidth, bottomStrokeWidth, viewPaint)
    }

    private fun setUp() {
        with(viewPaint) {
            color = bottomStrokeColor
            style = Paint.Style.FILL
        }
    }

    companion object {
        private const val DEFAULT_BOTTOM_STROKE_COLOR = Color.WHITE
        private const val DEFAULT_BOTTOM_STROKE_WIDTH = 1
    }
}