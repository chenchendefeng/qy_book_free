package com.wy.adbook.mvp.presenter;

import com.wy.adbook.app.base.QYBasePresenter_MembersInjector;
import com.wy.adbook.mvp.contranct.SettingContract;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class SettingPresenter_Factory implements Factory<SettingPresenter> {
  private final Provider<SettingContract.Model> modelProvider;

  private final Provider<SettingContract.View> viewProvider;

  private final Provider<RxErrorHandler> mErrorHandlerProvider;

  public SettingPresenter_Factory(
      Provider<SettingContract.Model> modelProvider,
      Provider<SettingContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    this.modelProvider = modelProvider;
    this.viewProvider = viewProvider;
    this.mErrorHandlerProvider = mErrorHandlerProvider;
  }

  @Override
  public SettingPresenter get() {
    SettingPresenter instance = new SettingPresenter(modelProvider.get(), viewProvider.get());
    QYBasePresenter_MembersInjector.injectMErrorHandler(instance, mErrorHandlerProvider.get());
    return instance;
  }

  public static SettingPresenter_Factory create(
      Provider<SettingContract.Model> modelProvider,
      Provider<SettingContract.View> viewProvider,
      Provider<RxErrorHandler> mErrorHandlerProvider) {
    return new SettingPresenter_Factory(modelProvider, viewProvider, mErrorHandlerProvider);
  }

  public static SettingPresenter newSettingPresenter(
      SettingContract.Model model, SettingContract.View view) {
    return new SettingPresenter(model, view);
  }
}
