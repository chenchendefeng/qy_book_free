package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.HelpCenterContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class HelpCenterPresenter_Factory implements Factory<HelpCenterPresenter> {
  private final Provider<HelpCenterContract.Model> modelProvider;

  private final Provider<HelpCenterContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public HelpCenterPresenter_Factory(
      Provider<HelpCenterContract.Model> modelProvider,
      Provider<HelpCenterContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public HelpCenterPresenter get() {
    HelpCenterPresenter instance = new HelpCenterPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static HelpCenterPresenter_Factory create(
      Provider<HelpCenterContract.Model> modelProvider,
      Provider<HelpCenterContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new HelpCenterPresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static HelpCenterPresenter newHelpCenterPresenter(
      HelpCenterContract.Model model, HelpCenterContract.View view) {
    return new HelpCenterPresenter(model, view);
  }
}
