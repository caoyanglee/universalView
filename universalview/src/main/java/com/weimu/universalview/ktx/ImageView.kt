package com.weimu.universalview.ktx

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.annotation.DrawableRes
import android.util.Base64
import android.widget.ImageView
import com.bumptech.glide.GenericTransitionOptions
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.weimu.universalview.glide.GlideRoundTransform
import com.weimu.universalview.R
import java.io.File

/**
 * Author:你需要一台永动机
 * Date:2018/5/21 09:26
 * Description:
 */

//图片加载 normal
fun ImageView.load(url: String = "", placeholder: Int = 0, error: Int = 0, useAnim: Boolean = true) {
    if (context is Activity && (context as Activity).isFinishing) return
    val requestBuilder = Glide.with(context)
            .load(url)
            .apply(RequestOptions().placeholder(placeholder).error(error))
    if (useAnim) requestBuilder.transition(GenericTransitionOptions.with(R.anim.fade_in))

    requestBuilder.into(this)
}

fun ImageView.load(@DrawableRes drawableRes: Int = 0, placeholder: Int = 0, error: Int = 0, useAnim: Boolean = true) {
    if (context is Activity && (context as Activity).isFinishing) return
    val options = RequestOptions()
            .placeholder(placeholder)
            .error(error)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
    val requestBuilder = Glide.with(context)
            .load(drawableRes)
            .apply(options)
    if (useAnim)
        requestBuilder.transition(GenericTransitionOptions.with(R.anim.fade_in))
    requestBuilder.into(this)
}


fun ImageView.load(file: File, placeholder: Int = 0, error: Int = 0, useAnim: Boolean = true) {
    if (context is Activity && (context as Activity).isFinishing) return
    val requestBuilder = Glide.with(context)
            .load(file)
            .apply(RequestOptions().placeholder(placeholder).error(error))
    if (useAnim) requestBuilder.transition(GenericTransitionOptions.with(R.anim.fade_in))
    requestBuilder.into(this)
}


fun ImageView.load(bitmap: Bitmap, placeholder: Int = 0, error: Int = 0, useAnim: Boolean = true) {
    if (context is Activity && (context as Activity).isFinishing) return
    val requestBuilder = Glide.with(context)
            .load(bitmap)
            .apply(RequestOptions().placeholder(placeholder).error(error))
    if (useAnim) requestBuilder.transition(GenericTransitionOptions.with(R.anim.fade_in))
    requestBuilder.into(this)
}


//图片加载 centerCrop
fun ImageView.load4CenterCrop(url: String = "", placeholder: Int = 0, error: Int = 0, useAnim: Boolean = true) {
    if (context is Activity && (context as Activity).isFinishing) return
    val requestBuilder = Glide.with(context)
            .load(url)
            .apply(RequestOptions().centerCrop().placeholder(placeholder).error(error))
    if (useAnim) requestBuilder.transition(GenericTransitionOptions.with(R.anim.fade_in))
    requestBuilder.into(this)
}

fun ImageView.load4CenterCrop(@DrawableRes drawableRes: Int = 0, placeholder: Int = 0, error: Int = 0, useAnim: Boolean = true) {
    if (context is Activity && (context as Activity).isFinishing) return
    val options = RequestOptions()
            .centerCrop()
            .placeholder(placeholder)
            .error(error)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
    val requestBuilder = Glide.with(context)
            .load(drawableRes)
            .apply(options)
    if (useAnim)
        requestBuilder.transition(GenericTransitionOptions.with(R.anim.fade_in))
    requestBuilder.into(this)
}


fun ImageView.load4CenterCrop(file: File, placeholder: Int = 0, error: Int = 0, useAnim: Boolean = true) {
    if (context is Activity && (context as Activity).isFinishing) return
    val requestBuilder = Glide.with(context)
            .load(file)
            .apply(RequestOptions().centerCrop().placeholder(placeholder).error(error))
    if (useAnim) requestBuilder.transition(GenericTransitionOptions.with(R.anim.fade_in))
    requestBuilder.into(this)
}


fun ImageView.load4CenterCrop(bitmap: Bitmap, placeholder: Int = 0, error: Int = 0, useAnim: Boolean = true) {
    if (context is Activity && (context as Activity).isFinishing) return
    val requestBuilder = Glide.with(context)
            .load(bitmap)
            .apply(RequestOptions().centerCrop().placeholder(placeholder).error(error))
    if (useAnim) requestBuilder.transition(GenericTransitionOptions.with(R.anim.fade_in))
    requestBuilder.into(this)
}

//图片加载 circle
fun ImageView.load4Circle(url: String = "", placeholder: Int = 0, error: Int = 0, useAnim: Boolean = true) {
    if (context is Activity && (context as Activity).isFinishing) return
    val requestBuilder = Glide.with(context)
            .load(url)
            .apply(RequestOptions().circleCrop().placeholder(placeholder).error(error))
    if (useAnim) requestBuilder.transition(GenericTransitionOptions.with(R.anim.fade_in))
    requestBuilder.into(this)
}

fun ImageView.load4Circle(@DrawableRes drawableRes: Int = 0, placeholder: Int = 0, error: Int = 0, useAnim: Boolean = true) {
    if (context is Activity && (context as Activity).isFinishing) return
    val options = RequestOptions()
            .circleCrop()
            .placeholder(placeholder)
            .error(error)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
    val requestBuilder = Glide.with(context)
            .load(drawableRes)
            .apply(options)
    if (useAnim)
        requestBuilder.transition(GenericTransitionOptions.with(R.anim.fade_in))
    requestBuilder.into(this)
}


fun ImageView.load4Circle(file: File, placeholder: Int = 0, error: Int = 0, useAnim: Boolean = true) {
    if (context is Activity && (context as Activity).isFinishing) return
    val requestBuilder = Glide.with(context)
            .load(file)
            .apply(RequestOptions().circleCrop().placeholder(placeholder).error(error))
    if (useAnim) requestBuilder.transition(GenericTransitionOptions.with(R.anim.fade_in))
    requestBuilder.into(this)
}


fun ImageView.load4Circle(bitmap: Bitmap, placeholder: Int = 0, error: Int = 0, useAnim: Boolean = true) {
    if (context is Activity && (context as Activity).isFinishing) return
    val requestBuilder = Glide.with(context)
            .load(bitmap)
            .apply(RequestOptions().circleCrop().placeholder(placeholder).error(error))
    if (useAnim) requestBuilder.transition(GenericTransitionOptions.with(R.anim.fade_in))

    requestBuilder.into(this)
}


//图片加载 round
fun ImageView.load4Round(url: String = "", radius: Int = 6, placeholder: Int = 0, error: Int = 0, useAnim: Boolean = true) {
    if (context is Activity && (context as Activity).isFinishing) return
    val requestBuilder = Glide.with(context)
            .load(url)
            .apply(RequestOptions().transform(GlideRoundTransform(radius)).placeholder(placeholder).error(error))
    if (useAnim) requestBuilder.transition(GenericTransitionOptions.with(R.anim.fade_in))
    requestBuilder.into(this)
}

fun ImageView.load4Round(@DrawableRes drawableRes: Int = 0, radius: Int = 6, placeholder: Int = 0, error: Int = 0, useAnim: Boolean = true) {
    if (context is Activity && (context as Activity).isFinishing) return
    val options = RequestOptions()
            .transform(GlideRoundTransform(radius))
            .placeholder(placeholder)
            .error(error)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
    val requestBuilder = Glide.with(context)
            .load(drawableRes)
            .apply(options)
    if (useAnim)
        requestBuilder.transition(GenericTransitionOptions.with(R.anim.fade_in))
    requestBuilder.into(this)
}


fun ImageView.load4Round(file: File, radius: Int = 6, placeholder: Int = 0, error: Int = 0, useAnim: Boolean = true) {
    if (context is Activity && (context as Activity).isFinishing) return
    val requestBuilder = Glide.with(context)
            .load(file)
            .apply(RequestOptions().transform(GlideRoundTransform(radius)).placeholder(placeholder).error(error))
    if (useAnim) requestBuilder.transition(GenericTransitionOptions.with(R.anim.fade_in))
    requestBuilder.into(this)
}


fun ImageView.load4Round(bitmap: Bitmap, radius: Int = 6, placeholder: Int = 0, error: Int = 0, useAnim: Boolean = true) {
    if (context is Activity && (context as Activity).isFinishing) return
    val requestBuilder = Glide.with(context)
            .load(bitmap)
            .apply(RequestOptions().transform(GlideRoundTransform(radius)).placeholder(placeholder).error(error))
    if (useAnim) requestBuilder.transition(GenericTransitionOptions.with(R.anim.fade_in))
    requestBuilder.into(this)
}


//不进行缓存的图片请求
fun ImageView.load4NoCache(url: String = "", placeholder: Int = 0, error: Int = 0, useAnim: Boolean = true) {
    if (context is Activity && (context as Activity).isFinishing) return
    val options = RequestOptions()
            .placeholder(placeholder)
            .error(error)
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
    val requestBuilder = Glide.with(context)
            .load(url)
            .apply(options)
    if (useAnim)
        requestBuilder.transition(GenericTransitionOptions.with(R.anim.fade_in))

    requestBuilder.into(this)
}

//加载base64的图片
fun ImageView.loadBae64(base64Data: String) {
    val bytes = Base64.decode(base64Data, Base64.DEFAULT)
    val btm = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    this.load(btm)
}
