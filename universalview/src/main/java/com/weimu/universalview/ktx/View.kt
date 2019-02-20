package com.weimu.universalview.ktx

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.weimu.universalib.ktx.toast
import io.reactivex.Observable
import java.util.concurrent.TimeUnit


//设置宽度和高度
fun View.setViewLayoutParams(width: Int, height: Int) {
    val p = this.layoutParams
    p.width = width
    p.height = height
    this.layoutParams = p
}

//设置高度
fun View.setHeight(height: Int) {
    this.setViewLayoutParams(-1, height)
}

//设置宽度
fun View.setWidth(width: Int) {
    this.setViewLayoutParams(width, -1)
}

//设置外边界
fun View.setMargins(l: Int, t: Int, r: Int, b: Int) {
    if (this.layoutParams is ViewGroup.MarginLayoutParams) {
        val p = this.layoutParams as ViewGroup.MarginLayoutParams
        p.setMargins(l, t, r, b)
        this.requestLayout()
    }
}

fun View.setMarginTop(t: Int) {
    if (this.layoutParams is ViewGroup.MarginLayoutParams) {
        val p = this.layoutParams as ViewGroup.MarginLayoutParams
        p.topMargin = t
        this.requestLayout()
    }
}


//请求获取焦点
fun View.requestFocus() {
    this.isFocusable = true
    this.isFocusableInTouchMode = true
    this.requestFocus()
}

//请求去除焦点
fun View.clearFocus(view: View) {
    view.isFocusable = false
    view.isFocusableInTouchMode = false
    view.clearFocus()
}

/**
 * 修改字体样式
 */
fun ViewGroup.changeFonts() {

    val tf = Typeface.createFromAsset(context.getAssets(), "font/HelveticaNeue-Light.ttf")
    for (i in 0..this.childCount - 1) {
        val v = this.getChildAt(i)
        if (v is TextView) {
            v.typeface = tf
        } else if (v is Button) {
            v.typeface = tf
        } else if (v is EditText) {
            v.typeface = tf
        } else if (v is ViewGroup) {
            v.changeFonts()
        }
    }

}


//解析xml视图
fun ViewGroup.inflate(layoutRes: Int): View = LayoutInflater.from(context).inflate(layoutRes, this, false)

fun Context.inflate(layoutRes: Int): View = LayoutInflater.from(this).inflate(layoutRes, null, false)

//防止重复点击1
fun View.setOnClickListenerPro(singleClick: View.OnClickListener) {
    var isDoing = false//是否正在处理事件
    this.setOnClickListener {
        if (isDoing) return@setOnClickListener
        singleClick.onClick(this)
        isDoing = true
        Observable.timer(600, TimeUnit.MILLISECONDS).subscribe { isDoing = false }
    }
}


//防止重复点击2
fun View.setOnClickListenerPro(onclick: ((View) -> Unit)) {
    var isDoing = false//是否正在处理事件
    this.setOnClickListener {
        if (isDoing) return@setOnClickListener
        onclick.invoke(this)
        isDoing = true
        Observable.timer(600, TimeUnit.MILLISECONDS).subscribe { isDoing = false }
    }
}

//获取当前视图对应的Bitmap
@Deprecated("图片超过屏幕时会crash")
fun View.getBitmap(handle: (viewBitmap: Bitmap) -> Unit) {
    isDrawingCacheEnabled = true
    buildDrawingCache()
    val viewBitmap = drawingCache
    handle(viewBitmap)
    isDrawingCacheEnabled = false
}


/**
 * 替代getDrawingCache方法
 *
 */
fun View.screenShot(handle: (viewBitmap: Bitmap) -> Unit) {
    try {
        val screenshot: Bitmap = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888)
        val c = Canvas(screenshot)
        c.translate((-this.scrollX).toFloat(), (-this.scrollY).toFloat())
        this.draw(c)
        handle(screenshot)
    } catch (e: Exception) {
        System.gc()
        toast(context, "保存错误，请重新点击")
    }
}

//显示
fun View.visible() {
    this.visibility = View.VISIBLE
}

//隐藏-占位
fun View.invisible() {
    this.visibility = View.INVISIBLE
}

//隐藏-不占位
fun View.gone() {
    this.visibility = View.GONE
}


//隐藏所有视图  无占位
fun hideAllViews(vararg views: View) {
    for (view in views) {
        view.visibility = View.GONE
    }
}


//隐藏所有视图  有占位
fun inVisibleAllViews(vararg views: View) {
    for (view in views) {
        view.visibility = View.INVISIBLE
    }
}


//显示所有视图
fun showAllViews(vararg views: View) {
    for (view in views) {
        view.visibility = View.VISIBLE
    }
}

//显示视图 one by one
fun showAllViewOneByOne(timeMillis: Long, vararg views: View) {
    if (views.isEmpty()) return
    views[0].visibility = View.VISIBLE
    for (i in 1 until views.size) {
        val view = views[i]
        Handler().postDelayed({ view.visibility = View.VISIBLE }, timeMillis * i)
    }
}


//动态修改View的背景 颜色，圆角
class ViewBgOption {
    var color: Int = -1
    var radius: Float = -1f
}

//修改背景
fun View.bg(option: ViewBgOption) {
    var bg = background
    if (bg !is GradientDrawable) {
        bg = GradientDrawable()
    }
    val targetBg = bg as GradientDrawable
    if (option.color != -1)
        targetBg.setColor(option.color)
    if (option.radius != -1f)
        targetBg.cornerRadius = option.radius
    background = targetBg
}














