package com.freebookqy.application.mvp.account.Login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.support.annotation.IntDef
import android.text.Editable
import android.text.TextWatcher
import android.text.style.ClickableSpan
import android.view.View
import cn.smssdk.EventHandler
import cn.smssdk.SMSSDK
import com.freebookqy.application.app.base.QYBaseActivity
import com.freebookqy.application.app.base.QYView
import com.freebookqy.application.app.rx.RxUtils
import com.freebookqy.application.di.component.DaggerLoginComponent
import com.freebookqy.application.di.module.LoginModule
import com.freebookqy.application.ext.showKeyboard
import com.freebookqy.application.mvp.contranct.LoginContract
import com.freebookqy.application.wxapi.WXEntryActivity
import com.freebookqy.utilslib.ResUtils
import com.freebookqy.utilslib.SpanUtils
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.RxLifecycleUtils
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_login.*
import org.simple.eventbus.Subscriber
import org.simple.eventbus.ThreadMode
import java.lang.ref.WeakReference
import java.util.concurrent.TimeUnit


/**
 * Created by leafye on 2019-05-08.
 */
class LoginActivity : QYBaseActivity<LoginPresenter>(), LoginContract.View {


    companion object {

        const val WEI_XIN_LOGIN = "wxLogin"
        /**
         * 电话号码长度
         */
        private const val NUM_PHONE = 11
        /**
         * 验证码/密码长度
         */
        private const val NUM_CODE = 6
        /**
         * 倒计时时间 s
         */
        private const val COUNT_DOWN = 60

        private const val LOGIN_FOR_PUT_ON = "loginForPutOn"

        @JvmStatic
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, LoginActivity::class.java))
        }

        @JvmStatic
        fun startActivity(context: Context, @LoginFor loginFor: Int) {
            context.startActivity(Intent(context, LoginActivity::class.java).apply {
                putExtra(LOGIN_FOR_PUT_ON, loginFor)
            })
        }

        private var weakActivity: WeakReference<LoginActivity>? = null

        private var eventHandler: EventHandler = object : EventHandler() {
            override fun afterEvent(event: Int, result: Int, data: Any) {
                // afterEvent会在子线程被调用，因此如果后续有UI相关操作，需要将数据发送到UI线程
                val msg = Message()
                msg.arg1 = event
                msg.arg2 = result
                msg.obj = data
                Handler(Looper.getMainLooper(), object : Handler.Callback {
                    override fun handleMessage(msg: Message): Boolean {
                        val event = msg.arg1
                        val result = msg.arg2
                        val data = msg.obj
                        if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                            if (result == SMSSDK.RESULT_COMPLETE) {
                                // 处理成功得到验证码的结果
                                // 请注意，此时只是完成了发送验证码的请求，验证码短信还需要几秒钟之后才送达
                                weakActivity?.get()?.showSuccess("验证码发送成功")
                                weakActivity?.get()?.startCountdown()
                            } else {
                                // 处理错误的结果
                                (data as Throwable).printStackTrace()
                                weakActivity?.get()?.showError("验证码发送失败")
                            }
                        }
//                    else if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
//                        if (result == SMSSDK.RESULT_COMPLETE) {
//                            // 处理验证码验证通过的结果
//                        } else {
//                            //  处理错误的结果
//                            (data as Throwable).printStackTrace()
//                        }
//                    }
                        // 其他接口的返回结果也类似，根据event判断当前数据属于哪个接口
                        return false
                    }
                }).sendMessage(msg)
            }
        }
    }

    private var countDownDisposable: Disposable? = null

    override fun getToolbar(): View? = title_bar_view

    override fun setupActivityComponent(appComponent: AppComponent) {
        DaggerLoginComponent.builder()
            .appComponent(appComponent)
            .loginModule(LoginModule((this@LoginActivity)))
            .build()
            .inject(this@LoginActivity)
    }

    override fun initView(savedInstanceState: Bundle?): Int {
        weakActivity = WeakReference(this)
        setSwipeBackEnable(false)
        return com.freebookqy.application.R.layout.activity_login
    }

    override fun initData(savedInstanceState: Bundle?) {
        protocol_tv.text = getLoginProtocolText()
        initListener()
        RxUtils.delay(
            this@LoginActivity,
            500,
            TimeUnit.MILLISECONDS,
            this::delayShowKeyboard
        )
    }

    override fun useEventBus(): Boolean = true

    private fun delayShowKeyboard() {
        showKeyboard(login_phone_et)
    }


    private fun initListener() {
        SMSSDK.registerEventHandler(eventHandler)
        title_bar_view.setOnLeftButtonClickListener { finish() }
        login_phone_et.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    get_verification_code_tv.isEnabled = it.length == NUM_PHONE
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        enter_code_et.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    phone_login_btn.isEnabled = it.length == NUM_CODE && login_phone_et.text.length == NUM_PHONE
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        code_clear_btn.setOnClickListener {
            enter_code_et.setText("")
        }
        phone_clear_btn.setOnClickListener {
            login_phone_et.setText("")
        }
        phone_login_btn.setOnClickListener {
            mPresenter?.login(
                login_phone_et.text.toString().trim(),
                enter_code_et.text.toString().trim()
            )
        }
        get_verification_code_tv.setOnClickListener {
            mPresenter?.getVerificationCode("86", login_phone_et.text.toString().trim())
        }
        wx_login_tv.setOnClickListener {
            mPresenter?.requestWx()
        }
    }

    private fun getLoginProtocolText() =
        SpanUtils()
            .append(getString(com.freebookqy.application.R.string.login_on_behalf_you_have_read_agreed_to))
            .append(getString(com.freebookqy.application.R.string.user_agreement))
            .setForegroundColor(ResUtils.getColor(com.freebookqy.application.R.color.red_text_color))
            .setClickSpan(object : ClickableSpan() {
                override fun onClick(widget: View) {
                    mPresenter?.enterUserProtocol()//进入用户协议界面
                }
            })
            .append(getString(com.freebookqy.application.R.string.with))
            .append(getString(com.freebookqy.application.R.string.privacy_agreement))
            .setForegroundColor(ResUtils.getColor(com.freebookqy.application.R.color.red_text_color))
            .setClickSpan(object : ClickableSpan() {
                override fun onClick(widget: View) {
                    mPresenter?.enterPrivacyAgreement()//进入隐私协议界面
                }
            })
            .create()

    /**
     * 开始验证码倒计时
     */
    override fun startCountdown() {
        if (countDownDisposable != null && !countDownDisposable!!.isDisposed) return
        countDownDisposable = Observable
            .interval(0L, 1L, TimeUnit.SECONDS, AndroidSchedulers.mainThread())
            .compose(RxLifecycleUtils.bindToLifecycle(this as QYView))
            .subscribe {
                val diff = COUNT_DOWN - it
                if (diff <= 0L) {
                    countDownDisposable?.dispose()
                    countDownDisposable = null
                    get_verification_code_tv.isEnabled = true
                    get_verification_code_tv.setText(com.freebookqy.application.R.string.get_verification_code)
                } else {
                    get_verification_code_tv.isEnabled = false
                    get_verification_code_tv.text =
                        ResUtils.getString(com.freebookqy.application.R.string.to_obtain_n_seconds, diff)
                }
            }
    }

    /**
     * 监听微信登录成功
     */
    @Subscriber(mode = ThreadMode.MAIN)
    fun subscribeWxEvent(key: WXEntryActivity.WxEventBusKey) {
        if (key.key == WXEntryActivity.WxEventBusKey.WX_LOGIN_SUCCESS) {
            //获取回调并存储数据
            val code = key.strArgs
            mPresenter?.loginWx(code)
        }
    }

}

@IntDef(
    LoginFor.FOR_PUT_ON,
    LoginFor.FOR_REMOVE
)
annotation class LoginFor {
    companion object {
        const val FOR_PUT_ON = 1
        const val FOR_REMOVE = 2
    }
}