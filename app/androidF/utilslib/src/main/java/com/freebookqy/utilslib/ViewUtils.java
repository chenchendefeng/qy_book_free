package com.freebookqy.utilslib;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Environment;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.view.View.*;

/**
 * 将布局转化成view对象
 *
 */
public class ViewUtils {

    public static String picName = "shareQQImage.jpg";

    /**
     * 布局转换成图片
     *
     * @param view
     * @return
     */

    public static Bitmap getBitmap(View view) {
        Bitmap bitmap = null;
        int width = view.getRight() - view.getLeft();
        int height = view.getBottom() - view.getTop();
        final boolean opaque = view.getDrawingCacheBackgroundColor() != 0 || view.isOpaque();
        Bitmap.Config quality;
        if (!opaque) {
            switch (view.getDrawingCacheQuality()) {
                case DRAWING_CACHE_QUALITY_AUTO:
                case DRAWING_CACHE_QUALITY_LOW:
                case DRAWING_CACHE_QUALITY_HIGH:
                default:
                    quality = Bitmap.Config.ARGB_8888;
                    break;
            }
        } else {
            quality = Bitmap.Config.RGB_565;
        }
        bitmap = Bitmap.createBitmap(view.getResources().getDisplayMetrics(),
                width, height, quality);
        bitmap.setDensity(view.getResources().getDisplayMetrics().densityDpi);
        if (opaque) bitmap.setHasAlpha(false);
        boolean clear = view.getDrawingCacheBackgroundColor() != 0;
        Canvas canvas = new Canvas(bitmap);
        if (clear) {
            bitmap.eraseColor(view.getDrawingCacheBackgroundColor());
        }
        view.computeScroll();
        final int restoreCount = canvas.save();
        canvas.translate(-view.getScrollX(), -view.getScrollY());
        view.draw(canvas);
        canvas.restoreToCount(restoreCount);
        canvas.setBitmap(null);

        return bitmap;
    }

    /**
     * 保存图片到本地
     */
    public static void saveBitmap(Bitmap bm) {
        File file;
        File files;
        isHaveSDCard();
        if (isHaveSDCard()) {
            file = Environment.getExternalStorageDirectory();
        } else {
            file = Environment.getDataDirectory();
        }
        files = new File(file.getPath() + "/MotieReader/data/");
        if (!file.isDirectory()) {
            file.delete();
            file.mkdirs();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
        writeBitmap(files.getPath(), picName, bm);
    }


    /**
     * 保存图片
     *
     * @param path
     * @param name
     * @param bitmap
     */
    public static void writeBitmap(String path, String name, Bitmap bitmap) {
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }

        File _file = new File(path + name);
        if (_file.exists()) {
            _file.delete();
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(_file);
            if (name != null && !"".equals(name)) {
                int index = name.lastIndexOf(".");
                if (index != -1 && (index + 1) < name.length()) {
                    String extension = name.substring(index + 1).toLowerCase();
                    if ("png".equals(extension)) {
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                    } else if ("jpg".equals(extension)
                            || "jpeg".equals(extension)) {
                        bitmap.compress(Bitmap.CompressFormat.JPEG, 75, fos);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 是否有sd卡
     *
     * @return
     */
    public static boolean isHaveSDCard() {
        String SDState = android.os.Environment.getExternalStorageState();
        if (SDState.equals(android.os.Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }
}
