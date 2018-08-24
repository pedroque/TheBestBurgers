package com.pedroabinajm.thebestburgers.espresso.matcher

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.support.test.espresso.matcher.BoundedMatcher
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.ImageView
import org.hamcrest.Description

class WithDrawableMatcher constructor(
    private val expectedId: Int
) : BoundedMatcher<View, ImageView>(ImageView::class.java) {
    private var resourceName: String? = null

    override fun matchesSafely(target: ImageView): Boolean {
        val context = target.context
        resourceName = context.resources.getResourceEntryName(expectedId)
        val expectedDrawable = ContextCompat.getDrawable(context, expectedId)
        return expectedDrawable?.let { target.drawable.sameAs(it) } ?: false
    }

    private fun Drawable.sameAs(otherDrawable: Drawable): Boolean {
        val bitmap = toBitmap()
        val otherBitmap = otherDrawable.toBitmap()
        return bitmap.sameAs(otherBitmap)
    }

    private fun Drawable.toBitmap() =
        Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888).apply {
            Canvas(this).let { canvas ->
                setBounds(TOP_LEFT_POSITION, TOP_LEFT_POSITION, canvas.width, canvas.height)
                draw(canvas)
            }
        }

    override fun describeTo(description: Description): Unit = description.run {
        appendText("with drawable from resource id")
        resourceName?.let {
            appendText(": [$it]")
        }
    }
}

private const val TOP_LEFT_POSITION = 0
