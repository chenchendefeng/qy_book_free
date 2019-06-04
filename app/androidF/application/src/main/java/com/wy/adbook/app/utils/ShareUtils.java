package com.wy.adbook.app.utils;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;
import com.jess.arms.utils.LogUtils;
import com.wy.adbook.app.constant.Constant;
import com.wy.adbook.wxapi.WxManager;
import com.freebookqy.utilslib.Utils;
import com.freebookqy.utilslib.ViewUtils;
import com.tencent.connect.share.QQShare;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;

import java.io.File;

import static com.freebookqy.utilslib.TencentUtil.bmpToByteArray;
import static com.freebookqy.utilslib.TencentUtil.buildTransaction;

/**
 * 分享工具类
 */
public class ShareUtils {

    public static final String SHARE_WX_SCENE_SESSION = "ShareWXSceneSession";
    public static final String SHARE_WX_SCENE_TIMELINE = "ShareWXSceneTimeline";


    private static Tencent mTencent;

    /**
     * 分享至微信聊天界面
     *
     * @param bitmap
     */
    public static void ShareWXSceneSession(Bitmap bitmap) {
        WXImageObject imageObject = new WXImageObject(bitmap);
        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = imageObject;

        //设置缩略图
        Bitmap mBp = Bitmap.createScaledBitmap(bitmap, 120, 120, true);
        bitmap.recycle();
        msg.thumbData = bmpToByteArray(mBp, true);

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction(ShareUtils.SHARE_WX_SCENE_SESSION);//  transaction字段用于唯一标识请求
        req.message = msg;
        req.scene = SendMessageToWX.Req.WXSceneSession;
        WxManager.INSTANCE.wxApi().sendReq(req);
    }

    public static void ShareWXSceneSession(String title, String content, String url) {
        WXWebpageObject webpage = new WXWebpageObject();
        webpage.webpageUrl = url;
        WXMediaMessage msg = new WXMediaMessage(webpage);
        msg.title = title;
        msg.description = content;
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction(ShareUtils.SHARE_WX_SCENE_SESSION);//  transaction字段用于唯一标识请求
        req.message = msg;
        req.scene = SendMessageToWX.Req.WXSceneSession;
        WxManager.INSTANCE.wxApi().sendReq(req);
    }

    public static void ShareWXSceneSession(String title, String content, String url, Bitmap bitmap) {
        WXWebpageObject webpage = new WXWebpageObject();
        webpage.webpageUrl = url;
        WXMediaMessage msg = new WXMediaMessage(webpage);
        msg.title = title;
        msg.description = content;
        msg.thumbData = bmpToByteArray(bitmap, true);
        bitmap.recycle();
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction(ShareUtils.SHARE_WX_SCENE_SESSION);//  transaction字段用于唯一标识请求
        req.message = msg;
        req.scene = SendMessageToWX.Req.WXSceneSession;
        WxManager.INSTANCE.wxApi().sendReq(req);
    }

    /**
     * 分享至朋友圈界面
     *
     * @param bitmap
     */
    public static void ShareWXSceneTimeline(Bitmap bitmap) {
        WXImageObject imageObject = new WXImageObject(bitmap);
        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = imageObject;

        //设置缩略图
        Bitmap mBp = Bitmap.createScaledBitmap(bitmap, 120, 120, true);
        bitmap.recycle();
        msg.thumbData = bmpToByteArray(mBp, true);

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction(ShareUtils.SHARE_WX_SCENE_TIMELINE);//  transaction字段用于唯一标识请求
        req.message = msg;
        req.scene = SendMessageToWX.Req.WXSceneTimeline;
        WxManager.INSTANCE.wxApi().sendReq(req);
    }

    public static void ShareWXSceneTimeline(String title, String content, String url, Bitmap bitmap) {
        WXWebpageObject webpage = new WXWebpageObject();
        webpage.webpageUrl = url;
        WXMediaMessage msg = new WXMediaMessage(webpage);
        msg.title = title;
        msg.description = content;
        msg.thumbData = bmpToByteArray(bitmap, true);
        bitmap.recycle();

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction(ShareUtils.SHARE_WX_SCENE_TIMELINE);//  transaction字段用于唯一标识请求
        req.message = msg;
        req.scene = SendMessageToWX.Req.WXSceneTimeline;
        WxManager.INSTANCE.wxApi().sendReq(req);
    }

    public static void ShareWXSceneTimeline(String title, String content, String url) {
        WXWebpageObject webpage = new WXWebpageObject();
        webpage.webpageUrl = url;
        WXMediaMessage msg = new WXMediaMessage(webpage);
        msg.title = title;
        msg.description = content;
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction(ShareUtils.SHARE_WX_SCENE_TIMELINE);//  transaction字段用于唯一标识请求
        req.message = msg;
        req.scene = SendMessageToWX.Req.WXSceneTimeline;
        WxManager.INSTANCE.wxApi().sendReq(req);
    }

    /**
     * 分享QQ
     *
     * @param context
     * @param baseUiListener
     */
    public static void ShareQQ(Activity context, String title, String content, String url, Bitmap bitmap, BaseUiListener baseUiListener) {
        if (mTencent == null) {
            initTencent();
        }
        if (mTencent.isQQInstalled(context)) {
            ViewUtils.saveBitmap(bitmap);
            File file;
            File files;

            if (ViewUtils.isHaveSDCard()) {
                file = Environment.getExternalStorageDirectory();
            } else {
                file = Environment.getDataDirectory();
            }
            files = new File(file.getPath() + "/MotieReader/data/");
            Bundle params = new Bundle();
            params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);// 设置分享类型为纯图片分享
            params.putString(QQShare.SHARE_TO_QQ_IMAGE_LOCAL_URL, files.getPath() + ViewUtils.picName);// 需要分享的本地图片URL
            params.putString(QQShare.SHARE_TO_QQ_TITLE, title);//
            params.putString(QQShare.SHARE_TO_QQ_SUMMARY, content);//
            params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, url);//
            mTencent.shareToQQ(context, params, baseUiListener);
        } else {
            Toast.makeText(context, "您还没有安装QQ", Toast.LENGTH_LONG).show();
        }
    }

    public static void ShareQQ(Activity context, Bitmap bitmap, BaseUiListener baseUiListener) {
        if (mTencent == null) {
            initTencent();
        }
        if (mTencent == null) {
            LogUtils.debugInfo("初始化qq失败");
            return;
        }
        if (mTencent.isQQInstalled(context)) {
            ViewUtils.saveBitmap(bitmap);
            File file;
            File files;

            if (ViewUtils.isHaveSDCard()) {
                file = Environment.getExternalStorageDirectory();
            } else {
                file = Environment.getDataDirectory();
            }
            files = new File(file.getPath() + "/MotieReader/data/");
            Bundle params = new Bundle();
            params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);// 设置分享类型为纯图片分享
            params.putString(QQShare.SHARE_TO_QQ_IMAGE_LOCAL_URL, files.getPath() + ViewUtils.picName);// 需要分享的本地图片URL
            mTencent.shareToQQ(context, params, baseUiListener);
        } else {
            Toast.makeText(context, "您还没有安装QQ", Toast.LENGTH_LONG).show();
        }
    }

    public static void ShareQQ(Activity context, String title, String content, String url, BaseUiListener baseUiListener) {
        if (mTencent == null) {
            initTencent();
        }
        if (mTencent.isQQInstalled(context)) {
            //ViewUtils.saveBitmap(bitmap);
//            File file;
//            File files;
//            if (ViewUtils.isHaveSDCard()) {
//                file = Environment.getExternalStorageDirectory();
//            } else {
//                file = Environment.getDataDirectory();
//            }
//            files = new File(file.getPath() + "/MotieReader/data/");
            Bundle params = new Bundle();
            params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);// 设置分享类型为纯图片分享
            //params.putString(QQShare.SHARE_TO_QQ_IMAGE_LOCAL_URL, files.getPath() + ViewUtils.picName);// 需要分享的本地图片URL
            params.putString(QQShare.SHARE_TO_QQ_TITLE, title);//
            params.putString(QQShare.SHARE_TO_QQ_SUMMARY, content);//
            params.putString(QQShare.SHARE_TO_QQ_TARGET_URL, url);//
            mTencent.shareToQQ(context, params, baseUiListener);
        } else {
            Toast.makeText(context, "您还没有安装QQ", Toast.LENGTH_LONG).show();
        }
    }

    public static void ShareQQImage(Activity context, Bitmap bitmap, BaseUiListener baseUiListener) {
        if (mTencent == null) {
            initTencent();
        }
        if (mTencent.isQQInstalled(context)) {
            ViewUtils.saveBitmap(bitmap);
            File file;
            File files;

            if (ViewUtils.isHaveSDCard()) {
                file = Environment.getExternalStorageDirectory();
            } else {
                file = Environment.getDataDirectory();
            }
            files = new File(file.getPath() + "/MotieReader/data/");
            Bundle params = new Bundle();
            params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_IMAGE);// 设置分享类型为纯图片分享
            params.putString(QQShare.SHARE_TO_QQ_IMAGE_LOCAL_URL, files.getPath() + ViewUtils.picName);// 需要分享的本地图片URL

            mTencent.shareToQQ(context, params, baseUiListener);
        } else {
            Toast.makeText(context, "您还没有安装QQ", Toast.LENGTH_LONG).show();
        }
    }

    private static void initTencent() {
        mTencent = Tencent.createInstance(Constant.QQ_APP_ID, Utils.INSTANCE.getApp());
    }

    public static class BaseUiListener implements IUiListener {
        public BaseUiListener() {
        }

        @Override
        public void onComplete(Object response) {

        }

        @Override
        public void onError(UiError uiError) {
            Toast.makeText(Utils.INSTANCE.getApp(), "分享失败", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCancel() {
            Toast.makeText(Utils.INSTANCE.getApp(), "分享取消", Toast.LENGTH_LONG).show();
        }
    }
}
