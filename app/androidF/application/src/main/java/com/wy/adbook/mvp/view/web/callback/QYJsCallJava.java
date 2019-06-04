package com.wy.adbook.mvp.view.web.callback;

import android.webkit.JavascriptInterface;
import com.jess.arms.integration.EventBusManager;
import com.jess.arms.utils.LogUtils;
import com.wy.adbook.app.manager.QYAccount;
import com.wy.adbook.mvp.model.entity.accout.UserInfo;
import com.wy.adbook.mvp.view.web.bean.WebViewMessageEvent;

/**
 *
 */
public class QYJsCallJava {

    private static final String TAG = QYJsCallJava.class.getSimpleName();

    public static String VIEW_VIDEO = "viewVideo";

    @JavascriptInterface
    public void getUserInfo() {
        UserInfo userInfo = QYAccount.INSTANCE.getUserInfo();
        LogUtils.debugInfo("调用了getUserInfo:${userInfo}" + userInfo);
        QYJavaCallJs.getUserInfo(userInfo);
    }

    @JavascriptInterface
    public void wxshare() {

    }

    @JavascriptInterface
    public void viewVideo() {
        WebViewMessageEvent.JSCallJavaEvent event = new WebViewMessageEvent.JSCallJavaEvent();
        event.setValue(VIEW_VIDEO);
        EventBusManager.getInstance().post(event);
    }


//    @JavascriptInterface
//    public void startInviteShare(String value) {
//        LogUtils.debugInfo(TAG, "share value:" + value);
//        InviteFriendsManager manage = new InviteFriendsManager();
//        manage.startShare(new Gson().fromJson(value, InviteShareInfo.class));
//    }

//    @JavascriptInterface
//    public void reflashBookMoney() {
//        AccountManager.getInstance().reflashBookMoney();
//    }
//
//    @JavascriptInterface
//    public void reflashBookMoney(String value) {
//        LogUtils.e(TAG, "reflashBookMoney value:" + value);
//        AccountManager.getInstance().reflashBookMoney();
//
//    }
//
//    //3.页面导航栏返回
//    @JavascriptInterface
//    public void goBack(String value) {
//        LogUtils.e(TAG, "goBack value:" + value);
//        if (TextUtils.isEmpty(value)) {
//            return;
//        }
//        WebViewMessageEvent.WebViewResponseEvent_GoBack response = new WebViewMessageEvent.WebViewResponseEvent_GoBack();
//        response.info = new Gson().fromJson(value, ExitInfo.class);
//        EventBus.getDefault().post(response);
//
//    }
//
//    @JavascriptInterface
//    public void startLogin() {
//        LogUtils.e(TAG, "startLogin value:" );
//        LoginActivity.start(ActivityManager.getInstance().getCurrentTopActivity());
//    }

}