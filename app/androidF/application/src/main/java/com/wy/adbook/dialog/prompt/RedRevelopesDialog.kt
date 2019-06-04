package com.wy.adbook.dialog.prompt

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.freebookqy.application.R
import com.wy.adbook.app.QYApplication
import com.wy.adbook.app.rx.SimpleObserver
import com.wy.adbook.ext.gif
import com.wy.adbook.ext.inflate
import com.wy.adbook.ext.onClick
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.dialog_view_red_revelopes.view.*
import java.util.concurrent.TimeUnit


/**
 * Created by leafye on 2019-05-27.
 */
class RedRevelopesDialog : FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    init {
        context.inflate(com.freebookqy.application.R.layout.dialog_view_red_revelopes, this)
        ok_btn.onClick { mL?.ok() }
    }

    fun startAnim() {
        Glide.with(QYApplication.cxt()).load(R.mipmap.red_envelopers_dialog_gif_1)
            .into(object : SimpleTarget<Drawable>() {
                override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                    if (resource is GifDrawable) {
                        resource.setLoopCount(1)
                        gif_1.setImageDrawable(resource)
                        resource.start()
                    }
                }
            })
        Observable
            .create(ObservableOnSubscribe<Int> { emitter ->
                emitter.onNext(1)
            })
            .delay(2, TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SimpleObserver<Int>() {
                override fun onNext(t: Int) {
                    gif_2.gif(com.freebookqy.application.R.mipmap.red_envelopes_dialog_gif_2)
                    ok_btn.visibility = View.VISIBLE
                }
            })
        //gif_1.gif(com.freebookqy.application.R.mipmap.red_envelopers_dialog_gif_1)
    }

    private var mL: RedRevelopesListener? = null

    fun setRedRevelopesListener(l: RedRevelopesListener) {
        this.mL = l
    }

    interface RedRevelopesListener {
        fun ok()
    }


}