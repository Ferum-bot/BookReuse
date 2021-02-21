package com.github.ferum_bot.bottom_navigation_view.ui

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.annotation.ColorInt
import androidx.annotation.Px
import androidx.core.graphics.toRectF
import com.github.ferum_bot.bottom_navigation_view.R
import com.github.ferum_bot.bottom_navigation_view.core.extensions.dpToPx
import com.github.ferum_bot.bottom_navigation_view.core.extensions.refactorToBookReuseWidth
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * Created by Matvey Popov.
 * Date: 21.02.2021
 * Time: 23:12
 * Project: BookReuse
 */
class BookReuseBottomNavigationView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
): BottomNavigationView(context, attrs, defStyleAttr) {

    @Px
    private var topStrokeWidth = context.dpToPx(DEFAULT_TOP_STROKE_WIDTH).refactorToBookReuseWidth()
    @ColorInt
    private var topStrokeColor = DEFAULT_TOP_STROKE_COLOR

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var viewWidth = 1f

    init {
        if (attrs != null) {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.BookReuseBottomNavigationView)
            topStrokeWidth = typedArray.getDimension(
                R.styleable.BookReuseBottomNavigationView_top_stoke_width,
                context.dpToPx(DEFAULT_TOP_STROKE_WIDTH)
            ).refactorToBookReuseWidth()
            topStrokeColor = typedArray.getColor(
                R.styleable.BookReuseBottomNavigationView_top_stroke_color,
                DEFAULT_TOP_STROKE_COLOR
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

        canvas.drawRect(0f, 0f, viewWidth, topStrokeWidth, paint)
    }

    private fun setUp() {
        with(paint) {
            color = topStrokeColor
            style = Paint.Style.FILL
        }
    }

    companion object {
        private const val DEFAULT_TOP_STROKE_COLOR = Color.WHITE
        private const val DEFAULT_TOP_STROKE_WIDTH = 1
    }
}