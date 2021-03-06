package com.wy.adbook.view.readview;


import com.wy.adbook.view.page.PageMode;
import com.wy.adbook.view.page.PageStyle;
import com.freebookqy.utilslib.ScreenUtils;
import com.freebookqy.utilslib.Utils;
import com.jess.arms.utils.DataHelper;

/**
 * Created by newbiechen on 17-5-17.
 * 阅读器的配置管理
 */

public class ReadSettingManager {

    private static int READ_TEXT_SIZE_DEFAULT = ScreenUtils.dpToPx(20);

    private final String SHARED_READ_BG = "shared_read_bg";

    private final String SHARED_IS_NIGHT = "share_is_night";

    private final String SHARED_READ_TEXT_SIZE = "shared_read_text_size";

    private final String SHARED_READ_PAGE_MODE = "shared_read_mode";

    /**
     * 12、16、20、28、36
     */
    /**
     * 字体最大数
     */
    public final static int TEXT_SIZE_MAX = 36;
    /**
     * 字体最小数
     */
    public final static int TEXT_SIZE_MIN = 12;


    private static volatile ReadSettingManager sInstance;


    public static ReadSettingManager getInstance() {
        if (sInstance == null) {
            synchronized (ReadSettingManager.class) {
                if (sInstance == null) {
                    sInstance = new ReadSettingManager();
                }
            }
        }
        return sInstance;
    }

    private ReadSettingManager() {

    }

    public void setReadBackground(PageStyle theme) {
        DataHelper.setIntergerSF(Utils.INSTANCE.getApp(), SHARED_READ_BG, theme.ordinal());
    }

    public void setTextSize(int textSize) {
        DataHelper.setIntergerSF(Utils.INSTANCE.getApp(), SHARED_READ_TEXT_SIZE, textSize);
    }

    public void setPageMode(PageMode mode) {
        DataHelper.setIntergerSF(Utils.INSTANCE.getApp(), SHARED_READ_PAGE_MODE, mode.ordinal());
    }

    /**
     * 得到的是转换成px的数值
     *
     */
    public int getTextSize() {
        int textSize = DataHelper.getIntergerSF(Utils.INSTANCE.getApp(), SHARED_READ_TEXT_SIZE);
        if (textSize == -1) {
            textSize = READ_TEXT_SIZE_DEFAULT;
        }
        return textSize;
    }

    public int preTextSize() {
        int textSize = getTextSize();
        int dp = ScreenUtils.pxToDp(textSize);
        //12、16、20、28、36
        if (dp == 12) {
            return 12;
        } else if (dp == 16) {
            return 12;
        } else if (dp == 20) {
            return 16;
        } else if (dp == 28) {
            return 20;
        } else if (dp == 36) {
            return 28;
        } else {
            return 20;
        }
    }

    public int nextTextSize() {
        int textSize = getTextSize();
        int dp = ScreenUtils.pxToDp(textSize);
        //12、16、20、28、36
        if (dp == 12) {
            return 16;
        } else if (dp == 16) {
            return 20;
        } else if (dp == 20) {
            return 28;
        } else if (dp == 28) {
            return 36;
        } else if (dp == 36) {
            return 36;
        } else {
            return 20;
        }
    }

    public PageMode getPageMode() {
        int mode = DataHelper.getIntergerSF(Utils.INSTANCE.getApp(), SHARED_READ_PAGE_MODE);
        if (mode == -1) {
            mode = PageMode.SIMULATION.ordinal();
        }
        return PageMode.values()[mode];
    }

    public PageStyle getReadBgTheme() {
        int theme = DataHelper.getIntergerSF(Utils.INSTANCE.getApp(), SHARED_READ_BG);
        if (theme == -1) {
            theme = PageStyle.BG_0.ordinal();
        }
        return PageStyle.values()[theme];
    }

    public boolean isNightMode() {
        return DataHelper.getIntergerSF(Utils.INSTANCE.getApp(), SHARED_IS_NIGHT) == 1;
    }

    public void setNightMode(boolean isNight) {
        DataHelper.setIntergerSF(Utils.INSTANCE.getApp(), SHARED_IS_NIGHT, isNight ? 1 : 0);
    }

    public void reset() {
        // 获取 屏幕背景
        ReadSettingManager.getInstance().setReadBackground(PageStyle.BG_0);
        // 字体大小
        ReadSettingManager.getInstance().setTextSize(READ_TEXT_SIZE_DEFAULT);
    }
}
