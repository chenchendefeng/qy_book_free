package com.freebookqy.viewlib.book;

import android.support.annotation.StringDef;
import com.freebookqy.utilslib.Utils;
import com.freebookqy.viewlib.book.utils.FileUtils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by leafye on 2019/5/7.
 */
public class Constant {

    @StringDef({
            Gender.MALE,
            Gender.FEMALE
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface Gender {
        String MALE = "male";

        String FEMALE = "female";
    }

    public static final String ISNIGHT = "isNight";

    public static String PATH_DATA = FileUtils.createRootPath(Utils.INSTANCE.getApp()) + "/cache";

    public static String PATH_COLLECT = FileUtils.createRootPath(Utils.INSTANCE.getApp()) + "/collect";

    public static String PATH_TXT = PATH_DATA + "/book/";

    public static String PATH_EPUB = PATH_DATA + "/epub";

    public static String PATH_CHM = PATH_DATA + "/chm";

    public static String BASE_PATH = Utils.INSTANCE.getApp().getCacheDir().getPath();

    public static final String SUFFIX_TXT = ".txt";
    public static final String SUFFIX_PDF = ".pdf";
    public static final String SUFFIX_EPUB = ".epub";
    public static final String SUFFIX_ZIP = ".zip";
    public static final String SUFFIX_CHM = ".chm";

    public static final String ISBYUPDATESORT = "isByUpdateSort";

}
