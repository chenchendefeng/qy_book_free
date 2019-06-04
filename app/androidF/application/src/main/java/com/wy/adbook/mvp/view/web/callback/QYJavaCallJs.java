package com.wy.adbook.mvp.view.web.callback;

import com.google.gson.GsonBuilder;
import com.wy.adbook.app.manager.QYAccount;
import com.wy.adbook.mvp.model.entity.accout.UserInfo;
import com.wy.adbook.mvp.view.web.act.WebActivity;
import com.wy.adbook.mvp.view.web.bean.ExitInfo;
import com.wy.adbook.mvp.view.web.bean.H5UserInfo;
import com.wy.adbook.mvp.view.web.bean.H5VideoComplete;

public class QYJavaCallJs {
    private static final String TAG = QYJavaCallJs.class.getSimpleName();

    public static void getUserInfo(UserInfo info) {
        H5UserInfo info1 = new H5UserInfo();
        info1.setUid(info.getCuId());
        info1.setToken(QYAccount.INSTANCE.getUserToken());
        String callValue = linkCall(H5UserInfo.METHOD_NAME, info1);
        WebActivity.loadJsFunc(callValue);
    }

    public static void viewVideo(){
        H5VideoComplete h5VideoComplete = new H5VideoComplete();
        String callValue = linkCall(H5VideoComplete.METHOD_NAME, h5VideoComplete);
        WebActivity.loadJsFunc(callValue);
    }



    public static void java2Js(String name, Object obj) {
        String linkCall = linkCall(name, obj);
        WebActivity.loadJsFunc(linkCall);
    }

    //2. 页面导航栏返回
    public static void goBack() {
        WebActivity.loadJsFunc(injectJSAndGoBack());
    }

    //3  刷新
    public static void refresh() {
        WebActivity.loadJsFunc(linkCallValue("refresh", null));
    }

    /**
     * 生成js注入脚本
     *
     * @param method 方法名
     * @param object 需要传递给js的json数据
     * @return 生成的注入脚本
     */
    private static String linkCallValue(String method, Object object) {
        String data = "{}";
        if (object != null) {
            //避免gson对url链接转义处理
            data = new GsonBuilder().disableHtmlEscaping().create().toJson(object);
        }
        return "javascript:window.webkit." + method + "(  " + data + " ) ";
    }

    public static String linkCall(String method, Object object) {
        String data = "{}";
        if (object != null) {
            //避免gson对url链接转义处理
            data = new GsonBuilder().disableHtmlEscaping().create().toJson(object);
        }
        return "javascript:window.McDispatcher({ \n" +
                "  \"type\": \"" + method + "\",\n" +
                "  \"data\": " + data + "\n" +
                "})";

        //{
        //  "type": "getUserInfo",
        //  "data": { "mobile": "18677776666", "token": "token"}
        //}

//        return "javascript:\n" +
//                //如果McDispatcher不存在或是存在但直接将method返回，说明需要客户端自己处理goBack事件
//                "if (typeof window.McDispatcher === 'undefined'\n" +
//                "\t\t|| window.McDispatcher({\"type\":\"" + method + "\",\"data\":" + data + "}) === \'" + method + "\') {\n" +
//                //手动调用注入的的goBack方法, 并将isExit值置为返回上一个页面
//                "\tvar callJavaJson = " + "\'{type:\\'" + method + "\\',isExit:\\'" + ExitInfo.BACK + "\\'}\';\n" +
//                "\twindow.webkit.goBack(callJavaJson)\n" +
//                "}";
    }

    /**
     * 由于js在某些界面没有定义goBack方法,导致客户端在按返回键时无法判断是回到上一个界面还是关闭当前Activity<br>
     * 处理思路：<br>
     * 在注入js的脚本中先判断js是否存在McDispatcher方法， <br>
     * 如果存在则直接调用这个方法并判断返回值是否为‘undefined’<br>
     * (h5的处理方式为如果他们处理了goBack方法则没有返回值，如果没有goBack方法则直接将‘goBack’字符串返回)<br>
     * 否则的话就直接回调我们注入的goBack方法{@link QYJsCallJava#goBack(String)}<br>
     *
     * @return 生成的注入脚本
     */
    private static String injectJSAndGoBack() {
        final String method = "goBack";
        String callJsJson = "{code:\'0\',msg:\'success\', type:\'" + method + "\', data:{}}";
        return "javascript:\n" +
                //如果McDispatcher不存在或是存在但直接将method返回，说明需要客户端自己处理goBack事件
                "if (typeof window.McDispatcher === 'undefined'\n" +
                "\t\t|| window.McDispatcher(" + callJsJson + ") === \'" + method + "\') {\n" +
                //手动调用注入的的goBack方法, 并将isExit值置为返回上一个页面
                "\tvar callJavaJson = " + "\'{type:\\'" + method + "\\',isExit:\\'" + ExitInfo.BACK + "\\'}\';\n" +
                "\twindow.webkit.goBack(callJavaJson)\n" +
                "}";
    }

    /**
     * 判断js对应的方法是否存在，不存在就不做处理<br>
     * 由于h5那边只对外提供了McDispatcher方法，然后通过这个方法分发事件，所以无法直接通过方法名判断js是否有对应的方法<br>
     * 最后的处理思路是如果js不存在对应的方法，则会在McDispatcher方法中直接返回这个方法名
     *
     * @param methodName 方法名
     * @return 生成的注入脚本
     */
    private static String checkJSFunctionExists(String methodName, Object object) {
        String callJsJson = "{code:\'0\',msg:\'success\', type:\'" + methodName + "\', data:" + object + "}";
        return "javascript:\n" +
                //如果McDispatcher不存在或是存在但直接将methodName返回
                "if (typeof window.McDispatcher === 'undefined'\n" +
                "\t\t|| window.McDispatcher(" + callJsJson + ") === \'" + methodName + "\') {\n" +
//                        "\talert(\\'存在："+ methodName+ "方法\\');\n" +
                "\talert(\'\\'存在:\\'" + methodName + "\\'方法\\'\');\n" +
                "} else {\n" +
                "\talert('不存在');\n" +
                "}";
    }
}