package com.wy.adbook.mvp.view.web.bean

/**
 * Created by leafye on 2019-05-23.
 */
class WebViewMessageEvent {
    /**
     * java调用js 发出的消息
     */
    class WebViewResponseEvent {
        var value: String = ""
        var obj: Any? = null
    }

    /**
     * js调用java 发出的消息
     */
    class JSCallJavaEvent {
        var value: String = ""
        var obj: Any? = null
    }

    class WebViewResponseEvent_GoBack {
        var info: ExitInfo? = null
    }

}