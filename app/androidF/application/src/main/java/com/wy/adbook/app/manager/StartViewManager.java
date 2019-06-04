package com.wy.adbook.app.manager;

import android.text.TextUtils;
import com.wy.adbook.app.QYApplication;
import com.wy.adbook.mvp.model.entity.StartPage;
import com.freebookqy.utilslib.ConvertUtils;
import com.google.gson.Gson;
import com.jess.arms.utils.DataHelper;

import java.util.Date;

public class StartViewManager {
    public final static String TYPE_IMG = "pic";
    public final static String TYPE_GIF = "gif";
    public final static String TYPE_VIDEO = "video";

    private static final String SP_START_VIEW = "startView";

    private static StartViewManager mStartViewManager;
    private StartPage mStartViewBean;


    public static StartViewManager getInstance() {
        if (mStartViewManager == null) {
            mStartViewManager = new StartViewManager();
        }
        return mStartViewManager;
    }

//    private String getStartViewPath() {
//        return Constant.CACHE_PATH_DATA + "/startView.tmp";
//    }

    private StartViewManager() {

    }

    public StartPage getStartView() {
        String value = DataHelper.getStringSF(QYApplication.cxt(), SP_START_VIEW);
        if (TextUtils.isEmpty(value)) {
            return null;
        }
        return new Gson().fromJson(value, StartPage.class);
    }

    public void saveStartView(StartPage bean) {
        if (bean == null) {
            return;
        }
        if (TextUtils.isEmpty(bean.getFileUrl())) {
            mStartViewBean = bean;
            DataHelper.setStringSF(QYApplication.cxt(), SP_START_VIEW, "");
            return;
        }
        mStartViewBean = bean;
        DataHelper.setStringSF(QYApplication.cxt(), SP_START_VIEW, new Gson().toJson(bean));
    }

//    public void saveResources(String url) {
//        if (url == null || mStartViewBean.data.type != TYPE_VIDEO) {
//            return;
//        }
//        String file = getStartViewPath();
//        if (url.equals(mStartViewBean.downUrl) && mStartViewBean.isDownOver) {
//            return;
//        }
//        if (!url.equals(mStartViewBean.downUrl)) {
//            FileUtils.deleteFile(file);
//        }
//        mStartViewBean.downUrl = url;
//        saveStartView(mStartViewBean);
//        new Thread() {
//            public void run() {
//                DownloadExecutorTarget target = new DownloadExecutorTarget();
//                target.url = url;
//                target.savePath = file;
//                intface CONNECT_TIME_OUT = 60000;
//                target.connectTimeout = CONNECT_TIME_OUT;
//                target.readTimeout = CONNECT_TIME_OUT;
//
//
//                DownloadExecutor executor = new DownloadExecutor(target);
//                executor.setDownloadListener(new IDownloadListener() {
//                    @Override
//                    public boolean onDownloadStateChanged(DownloadState state) {
//                        if (state.getState() == DownloadState.STATE_SUC) {
//                            mStartViewBean.isDownOver = true;
//                            mStartViewBean.downUrl = url;
//                            saveStartView(mStartViewBean);
//                        }
//                        return true;
//                    }
//                });
//                executor.startDownload();
//            }
//        }.start();
//
//    }


    public boolean isOpen() {
        initStartViewData();
        if (mStartViewBean == null) {
            return false;
        }
        String dateFormate = "yyyy-MM-dd HH:mm:ss";
        Date startDate = ConvertUtils.covertDate(mStartViewBean.getBeginDate(), dateFormate);
        Date endDate = ConvertUtils.covertDate(mStartViewBean.getEndDate(), dateFormate);
        Date now = new Date();
        if (now.after(endDate) || now.before(startDate)) {
            return false;
        }
        return true;
    }

    public String getViewUrl() {
        initStartViewData();
        if (mStartViewBean == null) {
            return null;
        }
        return mStartViewBean.getFileUrl();
    }


    public String getStartViewType() {
        initStartViewData();
        if (mStartViewBean == null) {
            return "";
        }
        return mStartViewBean.getFileType();
    }

    private void initStartViewData() {
        if (mStartViewBean == null) {
            mStartViewBean = getStartView();
        }
    }
}
