package com.wy.adbook.view.readview.utils;

import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v4.content.res.ResourcesCompat;
import android.widget.TextView;
import com.freebookqy.application.R;
import com.wy.adbook.app.QYApplication;

public class TypeFaceUtils {

    public static void bindTypeFace_SourceHanSerifCN_Regular(TextView tv) {
        Typeface tf = ResourcesCompat.getFont(tv.getContext(), R.font.hs_regular);
        tv.setIncludeFontPadding(false);
        tv.setTypeface(tf);
    }

    public static void bindTypeFace_SourceHanSerifCN_Regular(Paint paint) {
        Typeface tf = ResourcesCompat.getFont(QYApplication.cxt(), R.font.hs_regular);
        paint.setTypeface(tf);
    }
}
