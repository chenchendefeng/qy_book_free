package com.freebookqy.viewlib.banner

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.freebookqy.utilslib.ScreenUtils
import com.youth.banner.loader.ImageLoader
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

/**
 * Created by leafye on 2019/5/4.
 */
class BannerImageLoader : ImageLoader() {
    override fun displayImage(context: Context, path: Any?, imageView: ImageView) {
        val transform = RequestOptions().transform(
            RoundedCornersTransformation(
                ScreenUtils.dpToPx(9),
                0,
                RoundedCornersTransformation.CornerType.ALL
            )
        ).fitCenter()
            .optionalFitCenter()

        Glide
            .with(context)
            .load(path)
            .apply(transform)
            .into(imageView)
    }

    override fun createImageView(context: Context?): ImageView {
        return ImageView(context).apply {
            setPadding(ScreenUtils.dpToPx(15), 0, ScreenUtils.dpToPx(15), 0)
        }

    }
}