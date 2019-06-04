package com.wy.adbook.app.base

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.InflateException
import android.view.View
import butterknife.ButterKnife
import butterknife.Unbinder
import com.freebookqy.utilslib.StatusBarUtils
import com.freebookqy.viewlib.load.LoadDialog
import com.jaeger.library.StatusBarUtil
import com.jess.arms.base.delegate.IActivity
import com.jess.arms.integration.cache.Cache
import com.jess.arms.integration.cache.CacheType
import com.jess.arms.integration.lifecycle.ActivityLifecycleable
import com.jess.arms.mvp.IPresenter
import com.jess.arms.utils.ArmsUtils
import com.jess.arms.utils.ThirdViewUtil.convertAutoView
import com.trello.rxlifecycle2.android.ActivityEvent
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.Subject
import me.imid.swipebacklayout.lib.app.SwipeBackActivity
import org.jetbrains.anko.contentView
import javax.inject.Inject

/**
 * Created by leafye on 2019/4/29.
 */
abstract class QYBaseActivity<P : IPresenter>
    : SwipeBackActivity(),
    IActivity,
    ActivityLifecycleable {

    fun getContext(): Context {
        return this@QYBaseActivity
    }

//    private val svProgressHUD: SVProgressHUD by lazy {
//        SVProgressHUD(this@QYBaseActivity)
//    }

    private val loadDialog: LoadDialog by lazy {
        LoadDialog(this@QYBaseActivity)
    }

    private val disposables: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    private fun handlerStatusBarHeight() {
        StatusBarUtil.setLightMode(this)
        if (isHandlerStatusBarHeight()) {
            val statusBarHeight = StatusBarUtils.getStatusBarOffsetPx(this)
            contentView?.setPadding(0, statusBarHeight, 0, 0)
        }
    }

    /**
     * 显示加载
     */
    fun showLoading() {
        val disposable: Disposable = Observable.just(1)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                loadDialog.showLoading()
            }
        disposables.add(disposable)
    }

    fun showLoading(str: String) {
        val disposable: Disposable = Observable.just(1)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                loadDialog.showLoading()
            }
        disposables.add(disposable)
    }

    fun showError(str: String) {
        val disposable: Disposable = Observable.just(1)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                loadDialog.showMsg(str)
            }
        disposables.add(disposable)
    }

    fun showMessage(msg: String) {
        val disposable: Disposable = Observable.just(1)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                loadDialog.showMsg(msg)
            }
        disposables.add(disposable)
    }

    fun showSuccess(success: String) {
        val disposable: Disposable = Observable.just(1)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                loadDialog.showMsg(success)
            }
        disposables.add(disposable)
    }

    /**
     * 隐藏加载
     */
    fun hideLoading() {
        val disposable: Disposable = Observable.just(1)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                loadDialog.dismiss()
            }
        disposables.add(disposable)
    }

    open fun isHandlerStatusBarHeight(): Boolean {
        return false
    }

    open fun getToolbar(): View? {
        return null
    }

    protected val TAG = this.javaClass.simpleName
    private val mLifecycleSubject = BehaviorSubject.create<ActivityEvent>()
    private var mCache: Cache<String, Any>? = null
    private var mUnbinder: Unbinder? = null

    @JvmField
    @Inject
    var mPresenter: P? = null//如果当前页面逻辑简单, Presenter 可以为 null

    @Synchronized
    override fun provideCache(): Cache<String, Any> {
        if (mCache == null) {
            val cacheFactory = ArmsUtils
                .obtainAppComponentFromContext(this)
                .cacheFactory()
            mCache = cacheFactory
                .build(CacheType.ACTIVITY_CACHE) as Cache<String, Any>
        }
        return mCache!!
    }

    override fun provideLifecycleSubject(): Subject<ActivityEvent> {
        return mLifecycleSubject
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return convertAutoView(name, context, attrs) ?: super.onCreateView(name, context, attrs)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            val layoutResID = initView(savedInstanceState)
            //如果initView返回0,框架则不会调用setContentView(),当然也不会 Bind ButterKnife
            if (layoutResID != 0) {
                setContentView(layoutResID)
                //绑定到butterknife
                mUnbinder = ButterKnife.bind(this)
            }
            StatusBarUtils
                .from(this)
                .setTransparentStatusbar(true)
                .setActionbarView(getToolbar())
                .setLightStatusBar(true)
                .setActionBarOtherColor(true)
                .process()
        } catch (e: Exception) {
            if (e is InflateException) throw e
            e.printStackTrace()
        }
        handlerStatusBarHeight()
        initData(savedInstanceState)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mUnbinder != null && mUnbinder !== Unbinder.EMPTY)
            mUnbinder!!.unbind()
        this.mUnbinder = null
        if (mPresenter != null)
            mPresenter!!.onDestroy()//释放资源
        this.mPresenter = null
        disposables.clear()
    }

    /**
     * 是否使用 EventBus
     * Arms 核心库现在并不会依赖某个 EventBus, 要想使用 EventBus, 还请在项目中自行依赖对应的 EventBus
     * 现在支持两种 EventBus, greenrobot 的 EventBus 和畅销书 《Android源码设计模式解析与实战》的作者 何红辉 所作的 AndroidEventBus
     * 确保依赖后, 将此方法返回 true, Arms 会自动检测您依赖的 EventBus, 并自动注册
     * 这种做法可以让使用者有自行选择三方库的权利, 并且还可以减轻 Arms 的体积
     *
     * @return 返回 `true` (默认为使用 `true`), Arms 会自动注册 EventBus
     */
    override fun useEventBus(): Boolean {
        return true
    }

    /**
     * 这个Activity是否会使用Fragment,框架会根据这个属性判断是否注册[android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks]
     * 如果返回false,那意味着这个Activity不需要绑定Fragment,那你再在这个Activity中绑定继承于 [com.jess.arms.base.BaseFragment] 的Fragment将不起任何作用
     *
     * @return
     */
    override fun useFragment(): Boolean = true

    final override fun onBackPressed() {
        if (loadDialog.isShowing) {
            return
        }
        handlerBackPress()
    }

    open fun handlerBackPress() {
        super.onBackPressed()
    }

}