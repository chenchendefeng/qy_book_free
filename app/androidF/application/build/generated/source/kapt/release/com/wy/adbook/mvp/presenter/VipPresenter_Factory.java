package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.VipContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class VipPresenter_Factory implements Factory<VipPresenter> {
  private final Provider<VipContract.Model> modelProvider;

  private final Provider<VipContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public VipPresenter_Factory(
      Provider<VipContract.Model> modelProvider,
      Provider<VipContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public VipPresenter get() {
    VipPresenter instance = new VipPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static VipPresenter_Factory create(
      Provider<VipContract.Model> modelProvider,
      Provider<VipContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new VipPresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static VipPresenter newVipPresenter(VipContract.Model model, VipContract.View view) {
    return new VipPresenter(model, view);
  }
}
