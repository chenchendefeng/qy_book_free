//package com.wy.core.glide;
//
//import android.content.Context;
//import android.graphics.drawable.Drawable;
//import android.text.TextUtils;
//import android.widget.ImageView;
//
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.RequestBuilder;
//import com.bumptech.glide.request.RequestOptions;
//
//public class ImageLoader {
//    private static ImageLoader mImageLoader;
//
//    private ImageLoader() {
//    }
//
//    public static ImageLoader getInstance() {
//        if (mImageLoader == null) {
//            mImageLoader = new ImageLoader();
//        }
//        return mImageLoader;
//    }
//
//    public void displayImage(Context context, Object url, ImageView imageView) {
//        //RequestOptions options = new RequestOptions().centerCrop();
//        displayImage(context, url, imageView, null);
//
//    }
//
//    public void displayImage(Context context, Object url, ImageView imageView, RequestOptions options) {
//        if (url == null || TextUtils.isEmpty(url.toString())) {
//            return;
//        }
//        RequestBuilder<Drawable> manager = Glide.with(context).load(url);
//        if (options != null) {
//            manager.apply(options);
//        }
//        manager.into(imageView);
//
//    }
//
//}
//
